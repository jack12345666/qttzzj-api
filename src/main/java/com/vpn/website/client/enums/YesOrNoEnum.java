package com.vpn.website.client.enums;

/**
 * @author bitwang
 * @Date 2020/4/20 14:02
 * @Desc 1:是 0:否
 */
public enum YesOrNoEnum {
    YES("是",1),
    NO("否",0),
    ;
    private String name;
    private Integer val;

    public static String getName(Integer val){
        YesOrNoEnum[] values = values();
        for(YesOrNoEnum p:values){
            if(p.getVal()==val){
                return p.getName();
            }
        }
        return null;
    }

    public static Integer getKey(String name){
        YesOrNoEnum[] values = values();
        for(YesOrNoEnum p:values){
            if(p.getName().equals(name)){
                return p.getVal();
            }
        }
        return null;
    }

    private YesOrNoEnum(String name, Integer val){
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
