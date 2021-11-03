package com.ruoyi.quartz.task;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.quartz.util.DbUtils;
import com.ruoyi.quartz.util.ImgFileUtils;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.service.impl.SysAttachmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private SysAttachmentServiceImpl attachmentService;
    public void backupDB()
    {
        System.out.println("开始执行备份");
        String time = DateUtils.dateTimeNow(DateUtils.YYYYMMDDHHMMSS);
        DbUtils.backup(url,username,password,savePath,"homefee"+time,database);
    }

    public void cleanImgFile(){
        String filePath = RuoYiConfig.getUploadPath();
        List<File> allFile = ImgFileUtils.getAllFile(filePath);
        List<SysAttachment> sysAttachments = attachmentService.selectSysAttachmentList(null);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < sysAttachments.size(); i++) {
            SysAttachment sysAttachment = sysAttachments.get(i);
            File file = new File(filePath + sysAttachment.getFileNameReal().substring(15));
            list.add(file.getAbsolutePath());
        }
        for (File file : allFile) {
            String absolutePath = file.getAbsolutePath();
            if (list.contains(absolutePath)){
                System.out.print("oksl");
            }else{
                System.out.println("删除文件1"+file.getAbsolutePath());
                file.delete();
            }
        }


    }


}
