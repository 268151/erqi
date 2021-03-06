package com.aaa.service;

import com.aaa.properties.FtpProperties;
import com.aaa.utils.FileNameUtils;
import com.aaa.utils.FtpUtils;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

import static com.aaa.staticproperties.RedisProperties.POINT;
import static com.aaa.staticproperties.TimeForatProperties.DATE_FORMAT;

@Service
public class UploadService {


    @Autowired
    private FtpProperties ftpProperties;
    /**
     * 文件上传
     * @param file
     * @return
     */
    public String upload(MultipartFile file){
        //1.获取文件的远程名称（为了获取后缀名）
        String oldFilename = file.getOriginalFilename();
        //2.生成新的文件名
        String newsFileName = FileNameUtils.getFileName();
        //3.截取后缀名,拼接到新的文件名上
         newsFileName = newsFileName + oldFilename.substring(oldFilename.lastIndexOf(POINT));
         //4.获取文件的上传路径
        String filePath = DateUtil.formatDate(new Date(), DATE_FORMAT);

        try {
            if(FtpUtils.upload(ftpProperties.getHost(), ftpProperties.getPort(), ftpProperties.getUsername(),
                    ftpProperties.getPassword(), ftpProperties.getBasePath(), filePath, newsFileName, file.getInputStream()) ){
                return ftpProperties.getHost()+":"+ftpProperties.getPort()+"/"+ftpProperties.getBasePath()+"/"+filePath+"/"+newsFileName;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
