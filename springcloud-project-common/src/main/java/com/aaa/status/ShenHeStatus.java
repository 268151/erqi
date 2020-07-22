package com.aaa.status;


public enum  ShenHeStatus {

    UNIT_SHEHE(1,"单位信息审核"),
    REGUNIT_SHEHE(5,"注册单位审核"),
    PROJECT_RESULT(4,"项目成果汇交"),
    PROJECT_FORWARD(3,"项目进度审核"),
    REGPROJECT_SHENHE(2,"项目登记审核");

    private String name;
    private Integer type;

     ShenHeStatus ( Integer type,String name){
        this.name=name;
        this.type=type;
    }

    public String getName() {
        return name;
    }

    public Integer getType() {
        return type;
    }
}
