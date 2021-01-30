package com.vpn.website.client.enums;

/**
 * @author wang
 * @Date 2020/4/30 9:21
 * @Desc 授权用户类型
 */
public enum AuthTypeEnum {
    NO_AUTH("未登录",0),
    CORP("企业用户",1),
    GOV("政府用户",2),
    ;
    private String name;
    private Integer val;

    public static String getName(Integer val){
        AuthTypeEnum[] values = values();
        for(AuthTypeEnum p:values){
            if(p.getVal().equals(val)){
                return p.getName();
            }
        }
        return null;
    }

    public static Integer getKey(String name){
        AuthTypeEnum[] values = values();
        for(AuthTypeEnum p:values){
            if(p.getName().equals(name)){
                return p.getVal();
            }
        }
        return null;
    }

    private AuthTypeEnum(String name, Integer val){
        this.name = name;
        this.val = val;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVal() {
        return val;
    }

    /**
     * 用于验证用户类型
     * @param userType
     * @return
     */
    public boolean checkUserType(Integer userType){
        return this.val.equals(userType);
    }

    public void setVal(Integer val) {
        this.val = val;
    }
}
