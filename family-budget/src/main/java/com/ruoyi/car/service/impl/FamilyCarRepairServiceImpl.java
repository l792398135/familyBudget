package com.ruoyi.car.service.impl;

import com.ruoyi.car.domain.FamilyCarMangec;
import com.ruoyi.car.domain.FamilyCarRepairBase1;
import com.ruoyi.car.mapper.FamilyCarMangecMapper;
import com.ruoyi.car.mapper.FamilyCarRepairBase1Mapper;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.ShiroUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.payincome.domain.FamilyPay;
import com.ruoyi.payincome.mapper.FamilyPayMapper;
import com.ruoyi.system.mapper.SysDictDataMapper;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.car.mapper.FamilyCarRepairMapper;
import com.ruoyi.car.domain.FamilyCarRepair;
import com.ruoyi.car.service.IFamilyCarRepairService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
/**
 * 车辆维护费用Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-30
 */
@Service
public class FamilyCarRepairServiceImpl implements IFamilyCarRepairService 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    @Autowired
    private FamilyCarRepairMapper familyCarRepairMapper;

    @Autowired
    private FamilyCarMangecMapper familyCarMangecMapper;

    @Autowired
    private FamilyCarRepairBase1Mapper familyCarRepairBase1Mapper;

    @Autowired
    private FamilyPayMapper payMapper;

    @Autowired
    private SysDictDataMapper dictDataMapper;
    /**
     * 查询车辆维护费用
     * 
     * @param id 车辆维护费用主键
     * @return 车辆维护费用
     */
    @Override
    public FamilyCarRepair selectFamilyCarRepairById(Long id)
    {
        return familyCarRepairMapper.selectFamilyCarRepairById(id);
    }

    /**
     * 查询车辆维护费用列表
     * 
     * @param familyCarRepair 车辆维护费用
     * @return 车辆维护费用
     */
    @Override
    public List<FamilyCarRepair> selectFamilyCarRepairList(FamilyCarRepair familyCarRepair)
    {
        List<FamilyCarRepair> familyCarRepair1= familyCarRepairMapper.selectFamilyCarRepairList(familyCarRepair);
        for (int i = 0; i <familyCarRepair1.size() ; i++) {
            FamilyCarRepair item =familyCarRepair1.get(i);
            Long id = item.getId();
            SysAttachment sysAttachment = new SysAttachment();
            sysAttachment.setBusinessId(String.valueOf(id));
            sysAttachment.setBusinessType("carRepairCost");
            sysAttachment.setDelFlag(0);
            List<SysAttachment> sysAttachments = sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
            if (sysAttachments!=null) {
                List<String> collect = sysAttachments.stream().map(r -> r.getFilePath()).collect(Collectors.toList());
                item.setImgUrls(collect);
            }
            familyCarRepair1.set(i,item);
        }
        return familyCarRepair1;
    }

    /**
     * 新增车辆维护费用
     * 
     * @param familyCarRepair 车辆维护费用
     * @return 结果
     */
    @Override
    public Long insertFamilyCarRepair(FamilyCarRepair familyCarRepair)
    {
        familyCarRepair.setCreateTime(DateUtils.getNowDate());
        familyCarRepair.setCreateUser(ShiroUtils.getLoginName());
        familyCarRepairMapper.insertFamilyCarRepair(familyCarRepair);

        String carCode = familyCarRepair.getCarCode();
        FamilyCarMangec familyCarMangec = new FamilyCarMangec();
        familyCarMangec.setCarCode(carCode);
        List<FamilyCarMangec> familyCarMangecs = familyCarMangecMapper.selectFamilyCarMangecList(familyCarMangec);
        if (!CollectionUtils.isEmpty(familyCarMangecs)){
            FamilyCarMangec familyCarMangec1 = familyCarMangecs.get(0);
            Long carMile = familyCarMangec1.getCarMile();
            Date payDate = familyCarRepair.getPayDate();
            String carRepairCode = familyCarRepair.getCarRepairCode();
            FamilyCarRepairBase1 familyCarRepairBase1 = new FamilyCarRepairBase1();
            familyCarRepairBase1.setCarCode(carCode);
            familyCarRepairBase1.setCarRepairCode(carRepairCode);
            List<FamilyCarRepairBase1> familyCarRepairBase1s = familyCarRepairBase1Mapper.selectFamilyCarRepairBase1List(familyCarRepairBase1);
            if (!CollectionUtils.isEmpty(familyCarRepairBase1s)){
                FamilyCarRepairBase1 familyCarRepairBase11 = familyCarRepairBase1s.get(0);
                familyCarRepairBase11.setCarRepairMileLast(carMile);
                familyCarRepairBase11.setCarRepairCycleLast(payDate);
                familyCarRepairBase1Mapper.updateFamilyCarRepairBase1(familyCarRepairBase11);

                FamilyPay familyPay = new FamilyPay();
                familyPay.setPayCost(familyCarRepair.getCarCost());
                familyPay.setCreateDate(new Date());
                familyPay.setPayDate(payDate);
                familyPay.setPayTypeCode("che");
                familyPay.setPayMenber(familyCarRepair.getPayMenber());
                familyPay.setOperatorCode(familyCarRepair.getPayMenber());
                familyPay.setBookkeeperCode(familyCarRepair.getCreateUser());
                String carMange = dictDataMapper.selectDictLabel("car_manage", carCode);
                String carRepair = dictDataMapper.selectDictLabel("car_repair", carRepairCode);

                familyPay.setPayDetail(carMange +"车在"+carMile+"公里进行" +carRepair +"维修");
                payMapper.insertFamilyPay(familyPay);
            }else{
                throw new BusinessException("请先刷新保养科目！");
            }
        }else{
            throw new BusinessException("车辆无效！");
        }

        return familyCarRepair.getId();
    }

    /**
     * 修改车辆维护费用
     * 
     * @param familyCarRepair 车辆维护费用
     * @return 结果
     */
    @Override
    public int updateFamilyCarRepair(FamilyCarRepair familyCarRepair)
    {
        return familyCarRepairMapper.updateFamilyCarRepair(familyCarRepair);
    }

    /**
     * 批量删除车辆维护费用
     * 
     * @param ids 需要删除的车辆维护费用主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCarRepairByIds(String ids)
    {
        return familyCarRepairMapper.deleteFamilyCarRepairByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆维护费用信息
     * 
     * @param id 车辆维护费用主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCarRepairById(Long id)
    {
        return familyCarRepairMapper.deleteFamilyCarRepairById(id);
    }
}
