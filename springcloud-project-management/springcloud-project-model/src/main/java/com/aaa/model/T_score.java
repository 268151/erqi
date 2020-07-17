package com.aaa.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class T_score {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 增加的分值
     */
    @Column(name = "score_plus")
    private Integer scorePlus;

    /**
     * 减少的分值
     */
    @Column(name = "score_subtract")
    private Integer scoreSubtract;

    /**
     * 当前分值
     */
    private Integer score;

    /**
     * 关联单位编号
     */
    @Column(name = "unit_id")
    private Long unitId;

    /**
     * 增加/减少分值的原因
     */
    private String reason;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

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
     * 获取增加的分值
     *
     * @return score_plus - 增加的分值
     */
    public Integer getScorePlus() {
        return scorePlus;
    }

    /**
     * 设置增加的分值
     *
     * @param scorePlus 增加的分值
     */
    public void setScorePlus(Integer scorePlus) {
        this.scorePlus = scorePlus;
    }

    /**
     * 获取减少的分值
     *
     * @return score_subtract - 减少的分值
     */
    public Integer getScoreSubtract() {
        return scoreSubtract;
    }

    /**
     * 设置减少的分值
     *
     * @param scoreSubtract 减少的分值
     */
    public void setScoreSubtract(Integer scoreSubtract) {
        this.scoreSubtract = scoreSubtract;
    }

    /**
     * 获取当前分值
     *
     * @return score - 当前分值
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置当前分值
     *
     * @param score 当前分值
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取关联单位编号
     *
     * @return unit_id - 关联单位编号
     */
    public Long getUnitId() {
        return unitId;
    }

    /**
     * 设置关联单位编号
     *
     * @param unitId 关联单位编号
     */
    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    /**
     * 获取增加/减少分值的原因
     *
     * @return reason - 增加/减少分值的原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置增加/减少分值的原因
     *
     * @param reason 增加/减少分值的原因
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}