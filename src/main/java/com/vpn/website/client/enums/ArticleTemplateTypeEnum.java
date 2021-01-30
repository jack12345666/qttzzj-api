package com.vpn.website.client.enums;

/**
 * 新闻信息-版块分类枚举
 *
 * @Author Create by zheng on 2020-06-18 23:22
 */
public enum ArticleTemplateTypeEnum {
    NOTICE("通知公告", "3101"),
    INFORMATION("资讯动态", "3102"),
    ACTIVITY("活动安排", "3103"),
    ;
    private String name;
    private String val;

    public static String getName(String val) {
        ArticleTemplateTypeEnum[] values = values();
        for (ArticleTemplateTypeEnum p : values) {
            if (p.getVal().equals(val)) {
                return p.getName();
            }
        }
        return null;
    }

    public static String getKey(String name) {
        ArticleTemplateTypeEnum[] values = values();
        for (ArticleTemplateTypeEnum p : values) {
            if (p.getName().equals(name)) {
                return p.getVal();
            }
        }
        return null;
    }

    private ArticleTemplateTypeEnum(String name, String val) {
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
