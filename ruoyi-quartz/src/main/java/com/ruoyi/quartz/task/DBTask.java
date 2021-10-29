package com.ruoyi.quartz.task;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.quartz.util.DbUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 定时任务调度测试
 * 
 * @author ruoyi
 */
@Component("dbTask")
public class DBTask
{

    @Value("${export.database.ip}")
    private String url;
    @Value("${export.database.username}")
    private String username;
    @Value("${export.database.password}")
    private String password;
    @Value("${export.database.database}")
    private String database;
    @Value("${export.database.savepath}")
    private String savePath;
    public void backupDB()
    {
        System.out.println("开始执行备份");
        String time = DateUtils.dateTimeNow(DateUtils.YYYYMMDDHHMMSS);
        DbUtils.backup(url,username,password,savePath,"homefee"+time,database);
    }
}
