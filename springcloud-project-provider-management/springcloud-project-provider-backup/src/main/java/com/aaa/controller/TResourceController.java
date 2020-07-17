package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_resource;
import com.aaa.service.TResourceService;
import com.aaa.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @description: TResourceController
 * @author: 彭于晏
 * @create: 2020-07-17 16:40
 **/
public class TResourceController extends CommonController<T_resource> {

    @Autowired
    private TResourceService tResourceService;

    @Autowired
    private UploadService uploadService;

    @Override
    public BaseService<T_resource> getBaseService() {
        return tResourceService;
    }

    @PostMapping("/getTResource")
    public ResultData getTResource(T_resource tResource){
        return reponseListStatus(tResourceService.selectList(tResource));
    }

    /**
     * 上传单位必须表
     * @param multipartFile
     * @param tResource
     * @return
     */
    @GetMapping("/uploadUnit")
    public ResultData updateResource(@RequestParam MultipartFile multipartFile,@RequestParam T_resource tResource){
        String upload = uploadService.upload(multipartFile);
        if(upload==null){
            return operationFailed();
        }
        tResource.setPath(upload);
        tResource.setModifyTime(new Date());
        return reponseupdate(tResourceService.update(tResource));
    }



}
