package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FamilyMyTodo;

/**
 * 首页通知Service接口
 * 
 * @author ruoyi
 * @date 2021-11-25
 */
public interface IFamilyMyTodoService 
{
    /**
     * 查询首页通知
     * 
     * @param id 首页通知主键
     * @return 首页通知
     */
    public FamilyMyTodo selectFamilyMyTodoById(Long id);

    /**
     * 查询首页通知列表
     * 
     * @param familyMyTodo 首页通知
     * @return 首页通知集合
     */
    public List<FamilyMyTodo> selectFamilyMyTodoList(FamilyMyTodo familyMyTodo);

    /**
     * 新增首页通知
     * 
     * @param familyMyTodo 首页通知
     * @return 结果
     */
    public Long insertFamilyMyTodo(FamilyMyTodo familyMyTodo);

    /**
     * 修改首页通知
     * 
     * @param familyMyTodo 首页通知
     * @return 结果
     */
    public int updateFamilyMyTodo(FamilyMyTodo familyMyTodo);

    /**
     * 批量删除首页通知
     * 
     * @param ids 需要删除的首页通知主键集合
     * @return 结果
     */
    public int deleteFamilyMyTodoByIds(String ids);

    /**
     * 删除首页通知信息
     * 
     * @param id 首页通知主键
     * @return 结果
     */
    public int deleteFamilyMyTodoById(Long id);

    List<FamilyMyTodo> selectMyTodoList(FamilyMyTodo familyMyTodo);
}
