package com.ruoyi.system.service;

import org.springframework.web.multipart.MultipartFile;

public interface IOssService {
    public String uploadFileAvatar(MultipartFile file);
}
