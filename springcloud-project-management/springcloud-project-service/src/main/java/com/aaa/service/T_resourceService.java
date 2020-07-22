package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.model.T_resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class T_resourceService extends BaseService<T_resource> {

    public List<T_resource> selectList(Long ref_biz_id){
        T_resource t_resource=new T_resource();
        t_resource.setRefBizId(ref_biz_id);

        List<T_resource> resourceList = super.selectList(t_resource);

        if (resourceList.size()>0 && resourceList!=null){
            return resourceList;
        }
        return null;
    }




}
