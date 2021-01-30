package com.vpn.website.client.enums;

/**
 * @author bitwang
 * @Date 2020/4/20 14:02
 * @Desc 角色 1 启用 0 禁用
 */
public enum RoleValidEnum {
    FOR("禁用",0),
    USING("启用",1),
    ;
    private String name;
    private Integer val;

    public static String getName(Integer val){
        RoleValidEnum[] values = values();
        for(RoleValidEnum p:values){
            if(p.getVal()==val){
                return p.getName();
            }
        }
        return null;
    }

    public static Integer getKey(String name){
        RoleValidEnum[] values = values();
        for(RoleValidEnum p:values){
            if(p.getName().equals(name)){
                return p.getVal();
            }
        }
        return null;
    }

    private RoleValidEnum(String name, Integer val){
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

    public void setVal(Integer val) {
        this.val = val;
    }
}
