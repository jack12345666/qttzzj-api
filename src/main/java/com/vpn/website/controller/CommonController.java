package com.vpn.website.controller;

import com.vpn.website.client.util.AppUtil;
import com.vpn.website.common.base.BaseResult;
import com.vpn.website.common.configure.AppConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * @author Administrator
 */
@Api(tags = "通用方法")
@RequestMapping("/common")
@RestController
public class CommonController {

    @Autowired
    private AppConstants appConstants;

    @ApiOperation(value = "上传附件", notes = "上传附件")
    @PostMapping("/upload")
    public BaseResult uploadFile(MultipartFile file) {
        if (null == file) {
            return BaseResult.initFailResult("操作失败");
        }
        if (file.getSize() > appConstants.getFileMax() * 1000 * 1000) {
            return BaseResult.initFailResult("文件大小不超过" + appConstants.getFileMax() + "M");
        }
        FileOutputStream fos = null;
        try {
            String rootPath = appConstants.getFilepath();
            byte[] bytes = file.getBytes();
            String fileName = file.getOriginalFilename();
            String storeFileName = UUID.randomUUID().toString().replace("-", "") + fileName.substring(fileName.lastIndexOf("."));
            String storeFilePath = AppUtil.getFileSavepath(rootPath, null);
            File storeFile = new File(rootPath + storeFilePath + "/" + storeFileName);
            fos = new FileOutputStream(storeFile);
            fos.write(bytes);
            fos.flush();

            Map<String, Object> map = new HashMap<>(10);
            map.put("filePath", storeFilePath + storeFileName);
            map.put("fileName", fileName);
            map.put("fileExt", AppUtil.getFileExt(fileName));
            return BaseResult.initSuccessResult(map);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}