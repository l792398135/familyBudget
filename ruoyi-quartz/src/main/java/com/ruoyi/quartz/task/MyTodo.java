package com.ruoyi.quartz.task;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.FamilyMyTodo;
import com.ruoyi.system.service.IFamilyMyTodoService;
import com.ruoyi.system.service.impl.SysAttachmentServiceImpl;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("mytodoTask")
public class MyTodo {

    @Autowired
    private IFamilyMyTodoService todoService;

    public void everyPayAndIncome(String responser)
    {
        String[] split = responser.split(",");
        for (String responsibler : split) {
            FamilyMyTodo familyMyTodo = new FamilyMyTodo();
            familyMyTodo.setDoFlag("N");
            familyMyTodo.setCreateUser("admin");
            familyMyTodo.setCreateTime(new Date());
            familyMyTodo.setResponsibler(responsibler);
            familyMyTodo.setTitle("收入支出");
            String format = DateFormatUtils.format(new Date(), "yyyy年MM月dd日");
            familyMyTodo.setContent("请填写"+format+"的收入支出,转账！");
            todoService.insertFamilyMyTodo(familyMyTodo);
        }
    }

    public void doMonthBudget(String responser)
    {
        String[] split = responser.split(",");
        for (String responsibler : split) {
            FamilyMyTodo familyMyTodo = new FamilyMyTodo();
            familyMyTodo.setDoFlag("N");
            familyMyTodo.setCreateUser("admin");
            familyMyTodo.setCreateTime(new Date());
            familyMyTodo.setResponsibler(responsibler);
            familyMyTodo.setTitle("月度预算");
            String format = DateFormatUtils.format(new Date(), "yyyy年MM月");
            familyMyTodo.setContent("请填写"+format+"的月度预算！");
            todoService.insertFamilyMyTodo(familyMyTodo);
        }
    }

}
