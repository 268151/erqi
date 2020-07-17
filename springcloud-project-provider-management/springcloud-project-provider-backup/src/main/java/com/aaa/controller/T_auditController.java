package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_audit;
import com.aaa.service.T_auditService;
import com.aaa.vo.T_auditVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class T_auditController extends CommonController<T_audit> {
    @Override
    public BaseService<T_audit> getBaseService() {
        return auditService;
    }

    @Autowired
    private T_auditService auditService;

    @GetMapping("/allaudit")
    public ResultData selectAdit(T_audit audit,Integer pageNum,Integer pageSize) {
        try {

        PageInfo<T_audit> auditPageInfo = auditService.selectAuditByPage(audit, pageNum,pageSize);
        if (auditPageInfo.getList().size()>0&&auditPageInfo!=null) {
            return operationSuccess(auditPageInfo);
        }else {
            ResultData resultData = new ResultData();
            resultData.setCode("1");
            resultData.setMsg("暂无数据");
            return resultData;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        return operationFailed();
    }
}
