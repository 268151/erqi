package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.model.T_audit;
import com.aaa.vo.T_auditVo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class T_auditService extends BaseService<T_audit> {

    /**
     * @author: dz
     * @createtime: 2020/7/16 16:05
     * @param:
     * @desc: 根据id查询项目审核记录
     */

    public PageInfo<T_audit> selectAuditByPage(T_audit audit,Integer pageNum,Integer pageSize) throws Exception {

        PageInfo<T_audit> auditPageInfo = super.selectListByPage(audit, pageNum,pageSize);
        return auditPageInfo;
    }


}
