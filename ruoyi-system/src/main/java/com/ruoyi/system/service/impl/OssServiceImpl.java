package com.ruoyi.system.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.system.service.IOssService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class OssServiceImpl implements IOssService {

    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.file.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.oss.file.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.oss.file.bucketName}")
    private String bucketName;
    @Override
    public String uploadFileAvatar(MultipartFile file) {
        try{
            //创建OSSClient实例
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            //获取上传文件输入流
            InputStream inputStream = file.getInputStream();
            //在文件名称里面添加随机唯一的值
            String fileName = file.getOriginalFilename();
            fileName = Constants.RESOURCE_FILE_PREFIX + "/" +DateUtils.datePath() + "/" + IdUtils.fastUUID() + "." + file.getContentType();
            //获取当前日期
            ossClient.putObject(bucketName, fileName, inputStream);
            //关闭OSSClient
            ossClient.shutdown();
            //把上传之后文件路径返回
            String url = "https://" + bucketName + "." + endpoint + "/" + fileName;
            return url;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
