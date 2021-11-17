package com.ruoyi.child.service;

import java.util.List;
import com.ruoyi.child.domain.FamilyChildFundAgent;

/**
 * 资金代管Service接口
 * 
 * @author ruoyi
 * @date 2021-11-16
 */
public interface IFamilyChildFundAgentService 
{
    /**
     * 查询资金代管
     * 
     * @param id 资金代管主键
     * @return 资金代管
     */
    public FamilyChildFundAgent selectFamilyChildFundAgentById(Long id);

    /**
     * 查询资金代管列表
     * 
     * @param familyChildFundAgent 资金代管
     * @return 资金代管集合
     */
    public List<FamilyChildFundAgent> selectFamilyChildFundAgentList(FamilyChildFundAgent familyChildFundAgent);

    /**
     * 新增资金代管
     * 
     * @param familyChildFundAgent 资金代管
     * @return 结果
     */
    public Long insertFamilyChildFundAgent(FamilyChildFundAgent familyChildFundAgent);

    /**
     * 修改资金代管
     * 
     * @param familyChildFundAgent 资金代管
     * @return 结果
     */
    public int updateFamilyChildFundAgent(FamilyChildFundAgent familyChildFundAgent);

    /**
     * 批量删除资金代管
     * 
     * @param ids 需要删除的资金代管主键集合
     * @return 结果
     */
    public int deleteFamilyChildFundAgentByIds(String ids);

    /**
     * 删除资金代管信息
     * 
     * @param id 资金代管主键
     * @return 结果
     */
    public int deleteFamilyChildFundAgentById(Long id);
}
