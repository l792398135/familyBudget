package com.ruoyi.car.service.impl;

import com.ruoyi.base.controller.FamilyCarMangeController;
import com.ruoyi.base.domain.FamilyCarMange;
import com.ruoyi.base.mapper.FamilyCarMangeMapper;
import com.ruoyi.car.domain.FamilyCarMangec;
import com.ruoyi.car.mapper.FamilyCarMangecMapper;
import com.ruoyi.common.utils.ShiroUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import com.ruoyi.common.utils.DateUtils;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.car.mapper.FamilyCarRepairBase1Mapper;
import com.ruoyi.car.domain.FamilyCarRepairBase1;
import com.ruoyi.car.service.IFamilyCarRepairBase1Service;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
/**
 * 车辆保养科目Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-30
 */
@Service
public class FamilyCarRepairBase1ServiceImpl implements IFamilyCarRepairBase1Service 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    @Autowired
    private FamilyCarRepairBase1Mapper familyCarRepairBase1Mapper;

    @Autowired
    private FamilyCarMangecMapper familyCarMangecMapper;

    @Autowired
    private FamilyCarMangeMapper familyCarMangeMapper;
    /**
     * 查询车辆保养科目
     * 
     * @param id 车辆保养科目主键
     * @return 车辆保养科目
     */
    @Override
    public FamilyCarRepairBase1 selectFamilyCarRepairBase1ById(Long id)
    {
        return familyCarRepairBase1Mapper.selectFamilyCarRepairBase1ById(id);
    }

    /**
     * 查询车辆保养科目列表
     * 
     * @param familyCarRepairBase1 车辆保养科目
     * @return 车辆保养科目
     */
    @Override
    public List<FamilyCarRepairBase1> selectFamilyCarRepairBase1List(FamilyCarRepairBase1 familyCarRepairBase1)
    {
        List<FamilyCarRepairBase1> familyCarRepairBase11= familyCarRepairBase1Mapper.selectFamilyCarRepairBase1List(familyCarRepairBase1);
        for (int i = 0; i <familyCarRepairBase11.size() ; i++) {
            //状态
            FamilyCarRepairBase1 item = familyCarRepairBase11.get(i);
            //上次保养日期
            Date carRepairCycleLast = item.getCarRepairCycleLast();
            //周期剩余天报警
            Long carRepairCycleCall = item.getCarRepairCycleCall();
            //保养周期(月)
            Long carRepairCycle = item.getCarRepairCycle();
            Date calledDate = DateUtils.addMonths(carRepairCycleLast, carRepairCycle.intValue());
            //下次保养时间
            Date carNextRepairTime = item.getCarNextRepairTime();
            if (carNextRepairTime!=null){
                int midInt = DateUtils.differentDaysByMillisecond(new Date(), carNextRepairTime);
                if (midInt<=0){
                    item.setStatus("weixian");
                }else {
                    if (midInt>carRepairCycleCall){
                        item.setStatus("jiankang");
                    }else {
                        item.setStatus("yajiankang");
                    }
                }
            }else {
                int midInt = DateUtils.differentDaysByMillisecond(carRepairCycleLast, calledDate);
                int startInt = midInt - carRepairCycleCall.intValue();
                int accInt = DateUtils.differentDaysByMillisecond(carRepairCycleLast, new Date());

                if (accInt < startInt) {
                    item.setStatus("jiankang");
                } else if (accInt > midInt) {
                    item.setStatus("weixian");
                } else {
                    item.setStatus("yajiankang");
                }
                Long carRepairMileLast = item.getCarRepairMileLast();
                Long carRepairMileCall = item.getCarRepairMileCall();
                Long carRepairMile = item.getCarRepairMile();
                if (carRepairMileCall != 0) {
                    FamilyCarMangec familyCarMangec = new FamilyCarMangec();
                    familyCarMangec.setCarCode(item.getCarCode());
                    List<FamilyCarMangec> familyCarMangecs = familyCarMangecMapper.selectFamilyCarMangecList(familyCarMangec);
                    if (!CollectionUtils.isEmpty(familyCarMangecs)) {
                        FamilyCarMangec familyCarMangec1 = familyCarMangecs.get(0);
                        Long carMile = familyCarMangec1.getCarMile();
                        long callMile = carRepairMileLast + carRepairMile;
                        long startCallMile = callMile - carRepairMileCall;
                        if (carMile > callMile) {
                            //危险
                            item.setStatus("weixian");
                        } else if (carMile < startCallMile) {
                            //健康
                        } else {
                            //亚健康
                            if (!item.getStatus().equals("weixian")) {
                                item.setStatus("yajiankang");
                            }
                        }
                    }
                }
            }
            //状态
            Long id = item.getId();
            SysAttachment sysAttachment = new SysAttachment();
            sysAttachment.setBusinessId(String.valueOf(id));
            sysAttachment.setBusinessType("carRepair");
            sysAttachment.setDelFlag(0);
            List<SysAttachment> sysAttachments = sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
            if (sysAttachments!=null) {
                List<String> collect = sysAttachments.stream().map(r -> r.getFilePath()).collect(Collectors.toList());
                item.setImgUrls(collect);
            }
            familyCarRepairBase11.set(i,item);
        }
        return familyCarRepairBase11;
    }

    /**
     * 新增车辆保养科目
     * 
     * @param familyCarRepairBase1 车辆保养科目
     * @return 结果
     */
    @Override
    public Long insertFamilyCarRepairBase1(FamilyCarRepairBase1 familyCarRepairBase1)
    {
        familyCarRepairBase1.setCreateTime(DateUtils.getNowDate());
        familyCarRepairBase1.setCreateUser(ShiroUtils.getLoginName());
        familyCarRepairBase1Mapper.insertFamilyCarRepairBase1(familyCarRepairBase1);
        return familyCarRepairBase1.getId();
    }

    /**
     * 修改车辆保养科目
     * 
     * @param familyCarRepairBase1 车辆保养科目
     * @return 结果
     */
    @Override
    public int updateFamilyCarRepairBase1(FamilyCarRepairBase1 familyCarRepairBase1)
    {
        return familyCarRepairBase1Mapper.updateFamilyCarRepairBase1(familyCarRepairBase1);
    }

    /**
     * 批量删除车辆保养科目
     * 
     * @param ids 需要删除的车辆保养科目主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCarRepairBase1ByIds(String ids)
    {
        return familyCarRepairBase1Mapper.deleteFamilyCarRepairBase1ByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆保养科目信息
     * 
     * @param id 车辆保养科目主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCarRepairBase1ById(Long id)
    {
        return familyCarRepairBase1Mapper.deleteFamilyCarRepairBase1ById(id);
    }
}
