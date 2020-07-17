package com.aaa.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class T_news {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 正文摘要
     */
    private String digest;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 记录最近一次修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 正文
     */
    private String body;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取正文摘要
     *
     * @return digest - 正文摘要
     */
    public String getDigest() {
        return digest;
    }

    /**
     * 设置正文摘要
     *
     * @param digest 正文摘要
     */
    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取记录最近一次修改时间
     *
     * @return gmt_modified - 记录最近一次修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置记录最近一次修改时间
     *
     * @param gmtModified 记录最近一次修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取正文
     *
     * @return body - 正文
     */
    public String getBody() {
        return body;
    }

    /**
     * 设置正文
     *
     * @param body 正文
     */
    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }
}