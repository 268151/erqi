package com.aaa.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class T_user_config {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /**
     * 系统主题 dark暗色风格，light明亮风格
     */
    @Column(name = "THEME")
    private String theme;

    /**
     * 系统布局 side侧边栏，head顶部栏
     */
    @Column(name = "LAYOUT")
    private String layout;

    /**
     * 页面风格 1多标签页 0单页
     */
    @Column(name = "MULTI_PAGE")
    private String multiPage;

    /**
     * 页面滚动是否固定侧边栏 1固定 0不固定
     */
    @Column(name = "FIX_SIDERBAR")
    private String fixSiderbar;

    /**
     * 页面滚动是否固定顶栏 1固定 0不固定
     */
    @Column(name = "FIX_HEADER")
    private String fixHeader;

    /**
     * 主题颜色 RGB值
     */
    @Column(name = "COLOR")
    private String color;

    /**
     * 获取用户ID
     *
     * @return USER_ID - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取系统主题 dark暗色风格，light明亮风格
     *
     * @return THEME - 系统主题 dark暗色风格，light明亮风格
     */
    public String getTheme() {
        return theme;
    }

    /**
     * 设置系统主题 dark暗色风格，light明亮风格
     *
     * @param theme 系统主题 dark暗色风格，light明亮风格
     */
    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    /**
     * 获取系统布局 side侧边栏，head顶部栏
     *
     * @return LAYOUT - 系统布局 side侧边栏，head顶部栏
     */
    public String getLayout() {
        return layout;
    }

    /**
     * 设置系统布局 side侧边栏，head顶部栏
     *
     * @param layout 系统布局 side侧边栏，head顶部栏
     */
    public void setLayout(String layout) {
        this.layout = layout == null ? null : layout.trim();
    }

    /**
     * 获取页面风格 1多标签页 0单页
     *
     * @return MULTI_PAGE - 页面风格 1多标签页 0单页
     */
    public String getMultiPage() {
        return multiPage;
    }

    /**
     * 设置页面风格 1多标签页 0单页
     *
     * @param multiPage 页面风格 1多标签页 0单页
     */
    public void setMultiPage(String multiPage) {
        this.multiPage = multiPage == null ? null : multiPage.trim();
    }

    /**
     * 获取页面滚动是否固定侧边栏 1固定 0不固定
     *
     * @return FIX_SIDERBAR - 页面滚动是否固定侧边栏 1固定 0不固定
     */
    public String getFixSiderbar() {
        return fixSiderbar;
    }

    /**
     * 设置页面滚动是否固定侧边栏 1固定 0不固定
     *
     * @param fixSiderbar 页面滚动是否固定侧边栏 1固定 0不固定
     */
    public void setFixSiderbar(String fixSiderbar) {
        this.fixSiderbar = fixSiderbar == null ? null : fixSiderbar.trim();
    }

    /**
     * 获取页面滚动是否固定顶栏 1固定 0不固定
     *
     * @return FIX_HEADER - 页面滚动是否固定顶栏 1固定 0不固定
     */
    public String getFixHeader() {
        return fixHeader;
    }

    /**
     * 设置页面滚动是否固定顶栏 1固定 0不固定
     *
     * @param fixHeader 页面滚动是否固定顶栏 1固定 0不固定
     */
    public void setFixHeader(String fixHeader) {
        this.fixHeader = fixHeader == null ? null : fixHeader.trim();
    }

    /**
     * 获取主题颜色 RGB值
     *
     * @return COLOR - 主题颜色 RGB值
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置主题颜色 RGB值
     *
     * @param color 主题颜色 RGB值
     */
    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }
}