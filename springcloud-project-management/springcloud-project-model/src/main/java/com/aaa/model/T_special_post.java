package com.aaa.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class T_special_post {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 有效证件号
     */
    @Column(name = "id_number")
    private String idNumber;

    /**
     * 性别 0:女 1:男 2:保密
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 工作年限
     */
    @Column(name = "work_year")
    private Integer workYear;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 所学专业
     */
    private String major;

    /**
     * 学历
     */
    @Column(name = "education_background")
    private String educationBackground;

    /**
     * 学位
     */
    private String degree;

    /**
     * 特殊岗位
     */
    @Column(name = "special_post")
    private String specialPost;

    /**
     * 单位用户编号
     */
    @Column(name = "user_id")
    private Long userId;

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
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取有效证件号
     *
     * @return id_number - 有效证件号
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置有效证件号
     *
     * @param idNumber 有效证件号
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    /**
     * 获取性别 0:女 1:男 2:保密
     *
     * @return sex - 性别 0:女 1:男 2:保密
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别 0:女 1:男 2:保密
     *
     * @param sex 性别 0:女 1:男 2:保密
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取工作年限
     *
     * @return work_year - 工作年限
     */
    public Integer getWorkYear() {
        return workYear;
    }

    /**
     * 设置工作年限
     *
     * @param workYear 工作年限
     */
    public void setWorkYear(Integer workYear) {
        this.workYear = workYear;
    }

    /**
     * 获取毕业院校
     *
     * @return school - 毕业院校
     */
    public String getSchool() {
        return school;
    }

    /**
     * 设置毕业院校
     *
     * @param school 毕业院校
     */
    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    /**
     * 获取所学专业
     *
     * @return major - 所学专业
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置所学专业
     *
     * @param major 所学专业
     */
    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    /**
     * 获取学历
     *
     * @return education_background - 学历
     */
    public String getEducationBackground() {
        return educationBackground;
    }

    /**
     * 设置学历
     *
     * @param educationBackground 学历
     */
    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground == null ? null : educationBackground.trim();
    }

    /**
     * 获取学位
     *
     * @return degree - 学位
     */
    public String getDegree() {
        return degree;
    }

    /**
     * 设置学位
     *
     * @param degree 学位
     */
    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    /**
     * 获取特殊岗位
     *
     * @return special_post - 特殊岗位
     */
    public String getSpecialPost() {
        return specialPost;
    }

    /**
     * 设置特殊岗位
     *
     * @param specialPost 特殊岗位
     */
    public void setSpecialPost(String specialPost) {
        this.specialPost = specialPost == null ? null : specialPost.trim();
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