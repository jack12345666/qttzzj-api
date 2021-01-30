package com.vpn.website.client.enums;

/**
 * 联盟扩展状态枚举
 * @Author Create by zheng on 2020-06-18 23:22
 */
public enum AllianceExtendStatusEnum {

    STATUS_DRAFT("草稿", "0801"),
    STATUS_PENDING_REVIEW("发布待审核", "0802"),
    STATUS_RELEASED("已发布", "0803"),
    STATUS_NOT_PASS("审核未通过", "0804"),
    STATUS_INVALID("已删除", "0805"),
    ;
    private String name;
    private String val;

    public static String getName(String val) {
        AllianceExtendStatusEnum[] values = values();
        for (AllianceExtendStatusEnum p : values) {
            if (p.getVal().equals(val)) {
                return p.getName();
            }
        }
        return null;
    }

    public static String getKey(String name) {
        AllianceExtendStatusEnum[] values = values();
        for (AllianceExtendStatusEnum p : values) {
            if (p.getName().equals(name)) {
                return p.getVal();
            }
        }
        return null;
    }

    private AllianceExtendStatusEnum(String name, String val) {
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
