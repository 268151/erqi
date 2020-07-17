package com.aaa.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class T_audit {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 审核项
     */
    private String name;

    /**
     * 审核类别 1:单位信息审核 2:项目登记审核 3:项目上交审核 4:成果汇交审核
     */
    private Integer type;

    /**
     * 单位用户编号
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 审核状态 0:通过 1:拒绝
     */
    private Integer status;

    /**
     * 提交时间
     */
    @Column(name = "submit_time")
    private Date submitTime;

    /**
     * 审核时间
     */
    @Column(name = "audit_time")
    private Date auditTime;

    /**
     * 备注
     */
    private String memo;

    /**
     * 关联业务编号
     */
    @Column(name = "ref_id")
    private Long refId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取审核项
     *
     * @return name - 审核项
     */
    public String getName() {
        return name;
    }

    /**
     * 设置审核项
     *
     * @param name 审核项
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取审核类别 1:单位信息审核 2:项目登记审核 3:项目上交审核 4:成果汇交审核
     *
     * @return type - 审核类别 1:单位信息审核 2:项目登记审核 3:项目上交审核 4:成果汇交审核
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置审核类别 1:单位信息审核 2:项目登记审核 3:项目上交审核 4:成果汇交审核
     *
     * @param type 审核类别 1:单位信息审核 2:项目登记审核 3:项目上交审核 4:成果汇交审核
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取单位用户编号
     *
     * @return user_id - 单位用户编号
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置单位用户编号
     *
     * @param userId 单位用户编号
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取审核状态 0:通过 1:拒绝
     *
     * @return status - 审核状态 0:通过 1:拒绝
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置审核状态 0:通过 1:拒绝
     *
     * @param status 审核状态 0:通过 1:拒绝
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取提交时间
     *
     * @return submit_time - 提交时间
     */
    public Date getSubmitTime() {
        return submitTime;
    }

    /**
     * 设置提交时间
     *
     * @param submitTime 提交时间
     */
    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    /**
     * 获取审核时间
     *
     * @return audit_time - 审核时间
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 设置审核时间
     *
     * @param auditTime 审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 获取备注
     *
     * @return memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * 获取关联业务编号
     *
     * @return ref_id - 关联业务编号
     */
    public Long getRefId() {
        return refId;
    }

    /**
     * 设置关联业务编号
     *
     * @param refId 关联业务编号
     */
    public void setRefId(Long refId) {
        this.refId = refId;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}