package com.vpn.website.client.enums;

/**
 * @author wang
 * @Date 2020/4/30 9:21
 * @Desc 字典类型
 */
public enum AllianceCategoryEnum {
    A0601("产业联盟","0601"),
    A0602("服务联盟","0602"),
    A0603("两新党工委","0603"),
    ;
    private String name;
    private String val;

    public static String getName(String val){
        AllianceCategoryEnum[] values = values();
        for(AllianceCategoryEnum p:values){
            if(p.getVal().equals(val)){
                return p.getName();
            }
        }
        return null;
    }

    public static String getKey(String name){
        AllianceCategoryEnum[] values = values();
        for(AllianceCategoryEnum p:values){
            if(p.getName().equals(name)){
                return p.getVal();
            }
        }
        return null;
    }

    private AllianceCategoryEnum(String name, String val){
        this.name = name;
        this.val = val;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
