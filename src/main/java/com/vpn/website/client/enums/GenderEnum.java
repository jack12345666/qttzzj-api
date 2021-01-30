package com.vpn.website.client.enums;

/**
 * @author bitwang
 * @Date 2020/4/20 14:02
 * @Desc 性别 0未知 1男 2女
 */
public enum GenderEnum {
    UNKNOW("未知",0),
    M("男",1),
    F("女",2),
    ;
    private String name;
    private Integer val;

    public static String getName(Integer val){
        GenderEnum[] values = values();
        for(GenderEnum p:values){
            if(p.getVal()==val){
                return p.getName();
            }
        }
        return null;
    }

    public static Integer getKey(String name){
        GenderEnum[] values = values();
        for(GenderEnum p:values){
            if(p.getName().equals(name)){
                return p.getVal();
            }
        }
        return null;
    }

    private GenderEnum(String name, Integer val){
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
