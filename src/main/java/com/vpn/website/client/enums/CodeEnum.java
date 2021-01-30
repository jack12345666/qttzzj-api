package com.vpn.website.client.enums;

/**
 * @author wang
 * @Date 2020/4/30 9:21
 * @Desc 常用枚举类
 */
public enum CodeEnum {
    C0201("正常","0201"),
    C0202("停用","0202"),
    C1201("正常","1201"),
    C1209("停用","1209"),
    C0301("管理员","0301"),
    C0302("用户","0302"),
    ;
    private String name;
    private String val;

    public static String getName(String val){
        CodeEnum[] values = values();
        for(CodeEnum p:values){
            if(p.getVal().equals(val)){
                return p.getName();
            }
        }
        return null;
    }

    public static String getKey(String name){
        CodeEnum[] values = values();
        for(CodeEnum p:values){
            if(p.getName().equals(name)){
                return p.getVal();
            }
        }
        return null;
    }

    private CodeEnum(String name, String val){
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
