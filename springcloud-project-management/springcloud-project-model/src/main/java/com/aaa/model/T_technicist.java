package com.aaa.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class T_technicist {
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
     * 计入专业技术人员类别
     */
    @Column(name = "major_type")
    private String majorType;

    /**
     * 证件类型
     */
    @Column(name = "id_type")
    private String idType;

    /**
     * 证件号码
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
     * 职务
     */
    private String duty;

    /**
     * 职称
     */
    private String title;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 毕业时间
     */
    @Column(name = "graduation_date")
    private Date graduationDate;

    /**
     * 学位
     */
    private String degree;

    /**
     * 学历
     */
    @Column(name = "education_background")
    private String educationBackground;

    /**
     * 所学专业
     */
    private String major;

    /**
     * 职称专业
     */
    @Column(name = "title_major")
    private String titleMajor;

    /**
     * 进入本单位时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 任职时间(获得职称时间)
     */
    @Column(name = "title_time")
    private Date titleTime;

    /**
     * 聘用或劳动合同开始时间
     */
    @Column(name = "start_contract")
    private Date startContract;

    /**
     * 聘用或劳动合同终止时间
     */
    @Column(name = "end_contract")
    private Date endContract;

    /**
     * 现从事工作
     */
    private String post;

    /**
     * 从事测绘工作年限
     */
    @Column(name = "mapping_year")
    private Integer mappingYear;

    /**
     * 特殊岗位
     */
    @Column(name = "special_post")
    private String specialPost;

    /**
     * 认定
     */
    private String affirm;

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
     * 获取计入专业技术人员类别
     *
     * @return major_type - 计入专业技术人员类别
     */
    public String getMajorType() {
        return majorType;
    }

    /**
     * 设置计入专业技术人员类别
     *
     * @param majorType 计入专业技术人员类别
     */
    public void setMajorType(String majorType) {
        this.majorType = majorType == null ? null : majorType.trim();
    }

    /**
     * 获取证件类型
     *
     * @return id_type - 证件类型
     */
    public String getIdType() {
        return idType;
    }

    /**
     * 设置证件类型
     *
     * @param idType 证件类型
     */
    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    /**
     * 获取证件号码
     *
     * @return id_number - 证件号码
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置证件号码
     *
     * @param idNumber 证件号码
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
     * 获取职务
     *
     * @return duty - 职务
     */
    public String getDuty() {
        return duty;
    }

    /**
     * 设置职务
     *
     * @param duty 职务
     */
    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    /**
     * 获取职称
     *
     * @return title - 职称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置职称
     *
     * @param title 职称
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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
     * 获取毕业时间
     *
     * @return graduation_date - 毕业时间
     */
    public Date getGraduationDate() {
        return graduationDate;
    }

    /**
     * 设置毕业时间
     *
     * @param graduationDate 毕业时间
     */
    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
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
     * 获取职称专业
     *
     * @return title_major - 职称专业
     */
    public String getTitleMajor() {
        return titleMajor;
    }

    /**
     * 设置职称专业
     *
     * @param titleMajor 职称专业
     */
    public void setTitleMajor(String titleMajor) {
        this.titleMajor = titleMajor == null ? null : titleMajor.trim();
    }

    /**
     * 获取进入本单位时间
     *
     * @return start_time - 进入本单位时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置进入本单位时间
     *
     * @param startTime 进入本单位时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取任职时间(获得职称时间)
     *
     * @return title_time - 任职时间(获得职称时间)
     */
    public Date getTitleTime() {
        return titleTime;
    }

    /**
     * 设置任职时间(获得职称时间)
     *
     * @param titleTime 任职时间(获得职称时间)
     */
    public void setTitleTime(Date titleTime) {
        this.titleTime = titleTime;
    }

    /**
     * 获取聘用或劳动合同开始时间
     *
     * @return start_contract - 聘用或劳动合同开始时间
     */
    public Date getStartContract() {
        return startContract;
    }

    /**
     * 设置聘用或劳动合同开始时间
     *
     * @param startContract 聘用或劳动合同开始时间
     */
    public void setStartContract(Date startContract) {
        this.startContract = startContract;
    }

    /**
     * 获取聘用或劳动合同终止时间
     *
     * @return end_contract - 聘用或劳动合同终止时间
     */
    public Date getEndContract() {
        return endContract;
    }

    /**
     * 设置聘用或劳动合同终止时间
     *
     * @param endContract 聘用或劳动合同终止时间
     */
    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }

    /**
     * 获取现从事工作
     *
     * @return post - 现从事工作
     */
    public String getPost() {
        return post;
    }

    /**
     * 设置现从事工作
     *
     * @param post 现从事工作
     */
    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

    /**
     * 获取从事测绘工作年限
     *
     * @return mapping_year - 从事测绘工作年限
     */
    public Integer getMappingYear() {
        return mappingYear;
    }

    /**
     * 设置从事测绘工作年限
     *
     * @param mappingYear 从事测绘工作年限
     */
    public void setMappingYear(Integer mappingYear) {
        this.mappingYear = mappingYear;
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
     * 获取认定
     *
     * @return affirm - 认定
     */
    public String getAffirm() {
        return affirm;
    }

    /**
     * 设置认定
     *
     * @param affirm 认定
     */
    public void setAffirm(String affirm) {
        this.affirm = affirm == null ? null : affirm.trim();
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