package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.ShiroUtils;
import java.util.List;
import java.util.stream.Collectors;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FamilyMyTodoMapper;
import com.ruoyi.system.domain.FamilyMyTodo;
import com.ruoyi.system.service.IFamilyMyTodoService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
/**
 * 首页通知Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-25
 */
@Service
public class FamilyMyTodoServiceImpl implements IFamilyMyTodoService 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    @Autowired
    private FamilyMyTodoMapper familyMyTodoMapper;

    /**
     * 查询首页通知
     * 
     * @param id 首页通知主键
     * @return 首页通知
     */
    @Override
    public FamilyMyTodo selectFamilyMyTodoById(Long id)
    {
        return familyMyTodoMapper.selectFamilyMyTodoById(id);
    }

    /**
     * 查询首页通知列表
     * 
     * @param familyMyTodo 首页通知
     * @return 首页通知
     */
    @Override
    public List<FamilyMyTodo> selectFamilyMyTodoList(FamilyMyTodo familyMyTodo)
    {
        List<FamilyMyTodo> familyMyTodo1= familyMyTodoMapper.selectFamilyMyTodoList(familyMyTodo);
        return familyMyTodo1;
    }

    /**
     * 新增首页通知
     * 
     * @param familyMyTodo 首页通知
     * @return 结果
     */
    @Override
    public Long insertFamilyMyTodo(FamilyMyTodo familyMyTodo)
    {
        familyMyTodoMapper.insertFamilyMyTodo(familyMyTodo);
        return familyMyTodo.getId();
    }

    /**
     * 修改首页通知
     * 
     * @param familyMyTodo 首页通知
     * @return 结果
     */
    @Override
    public int updateFamilyMyTodo(FamilyMyTodo familyMyTodo)
    {
        return familyMyTodoMapper.updateFamilyMyTodo(familyMyTodo);
    }

    /**
     * 批量删除首页通知
     * 
     * @param ids 需要删除的首页通知主键
     * @return 结果
     */
    @Override
    public int deleteFamilyMyTodoByIds(String ids)
    {
        return familyMyTodoMapper.deleteFamilyMyTodoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除首页通知信息
     * 
     * @param id 首页通知主键
     * @return 结果
     */
    @Override
    public int deleteFamilyMyTodoById(Long id)
    {
        return familyMyTodoMapper.deleteFamilyMyTodoById(id);
    }

    @Override
    public List<FamilyMyTodo> selectMyTodoList(FamilyMyTodo familyMyTodo) {
        String loginName = ShiroUtils.getLoginName();
        familyMyTodo.setResponsibler(loginName);
        familyMyTodo.setDoFlag("N");
        return familyMyTodoMapper.selectMyTodoList(familyMyTodo);
    }
}
