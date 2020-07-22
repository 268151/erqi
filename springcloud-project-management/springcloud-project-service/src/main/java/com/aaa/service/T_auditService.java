package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.T_mapping_unitMapper;
import com.aaa.model.T_audit;
import com.aaa.vo.T_auditVo;
import com.github.pagehelper.PageInfo;
import javafx.scene.chart.PieChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class T_auditService extends BaseService<T_audit> {
    @Autowired
    private T_mapping_unitMapper mapping_unitMapper;

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


    /**
     * @author: dz
     * @createtime: 2020/7/18 9:55
     * @param:
     * @desc: 生成单位审核后的记录
     */

    public Integer addAuditStatus(Long id, String name, Integer type, Long userid, Integer status, Date submit_time, String audit_time, Long ref_id, String create_time){
        T_audit audit=new T_audit();
        audit.setId(id).setName(name).setType(type).setUserId(userid).setStatus(status).setSubmitTime(submit_time).setAuditTime(audit_time).setRefId(ref_id).setCreateTime(create_time);
        if (audit != null && !"" .equals(audit)) {
            return super.add(audit);
        }

        return null;

    }



}
