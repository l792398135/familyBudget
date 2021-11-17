package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysSummernote;

/**
 * 富文本数据Service接口
 * 
 * @author ruoyi
 * @date 2021-11-16
 */
public interface ISysSummernoteService 
{
    /**
     * 查询富文本数据
     * 
     * @param id 富文本数据主键
     * @return 富文本数据
     */
    public SysSummernote selectSysSummernoteById(Long id);

    /**
     * 查询富文本数据列表
     * 
     * @param sysSummernote 富文本数据
     * @return 富文本数据集合
     */
    public List<SysSummernote> selectSysSummernoteList(SysSummernote sysSummernote);

    /**
     * 新增富文本数据
     * 
     * @param sysSummernote 富文本数据
     * @return 结果
     */
    public Long insertSysSummernote(SysSummernote sysSummernote);

    /**
     * 修改富文本数据
     * 
     * @param sysSummernote 富文本数据
     * @return 结果
     */
    public int updateSysSummernote(SysSummernote sysSummernote);

    /**
     * 批量删除富文本数据
     * 
     * @param ids 需要删除的富文本数据主键集合
     * @return 结果
     */
    public int deleteSysSummernoteByIds(String ids);

    /**
     * 删除富文本数据信息
     * 
     * @param id 富文本数据主键
     * @return 结果
     */
    public int deleteSysSummernoteById(Long id);

    SysSummernote selectSysSummernote(SysSummernote sysSummernote);
}
