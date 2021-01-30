package com.vpn.website.client.enums;

/**
 * @author bitwang
 * @Date 2020/4/20 14:02
 * @Desc redis的KEY
 */
public enum RedisKeyEnum {
    LOGIN_TOKEN("登录token","login_tokens:"),
    USER_INFO("用户信息","user_info:"),
    CODE("编码","code:"),
    ;
    private String name;
    private String val;

    public static String getName(String val){
        RedisKeyEnum[] values = values();
        for(RedisKeyEnum p:values){
            if(p.getVal().equals(val)){
                return p.getName();
            }
        }
        return null;
    }

    public static String getKey(String name){
        RedisKeyEnum[] values = values();
        for(RedisKeyEnum p:values){
            if(p.getName().equals(name)){
                return p.getVal();
            }
        }
        return null;
    }

    private RedisKeyEnum(String name, String val){
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

    /**
     * 组装Redis 的KEY
     * @param key
     * @return
     */
    public String getRedisKey(String key){
        return this.val+key;
    }
}
