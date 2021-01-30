package com.vpn.website.client.enums;

/**
 * 新闻状态枚举
 *
 * @Author Create by zheng on 2020-06-18 23:22
 */
public enum ArticleStatusEnum {

    STATUS_DRAFT("草稿", "1401"),
    STATUS_PENDING_REVIEW("发布待审核", "1402"),
    STATUS_RELEASED("正常发布", "1403"),
    STATUS_NOT_PASS("审核未通过", "1404"),
    STATUS_INVALID("无效", "1405"),
    ;
    private String name;
    private String val;

    public static String getName(String val) {
        ArticleStatusEnum[] values = values();
        for (ArticleStatusEnum p : values) {
            if (p.getVal().equals(val)) {
                return p.getName();
            }
        }
        return null;
    }

    public static String getKey(String name) {
        ArticleStatusEnum[] values = values();
        for (ArticleStatusEnum p : values) {
            if (p.getName().equals(name)) {
                return p.getVal();
            }
        }
        return null;
    }

    private ArticleStatusEnum(String name, String val) {
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
