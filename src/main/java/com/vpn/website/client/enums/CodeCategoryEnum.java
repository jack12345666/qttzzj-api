package com.vpn.website.client.enums;

/**
 * @author wang
 * @Date 2020/4/30 9:21
 * @Desc 字典类型
 */
public enum CodeCategoryEnum {
    AllianceCategory("联盟类型","06"),
    AllianceExtendCategory("联盟信息扩展类型","07"),
    ArticleSourceWeb("文章来源网站","13"),
    ArticleStatus("文章状态","14"),
    ArticleTemplateType("文章版块分类","31"),
    CommonCategory("通用多级分类","01"),
    EmployeeStatus("EmployeeStatus","02"),
    LogCategory("日志类型","04"),
    NoticeCategory("通知类型","22"),
    NoticeStatus("通知状态","23"),
    NoticeType("通知方式","24"),
    OrgCodeCategory("机构代码类型","16"),
    OrgQuestionDetailCategory("机构问题处理明细类型","21"),
    OrgQuestionInnerStatus("机构问题内部状态","20"),
    OrgQuestionOuterStatus("机构问题外部状态","19"),
    OrgQuestionSourceChannel("机构问题来源渠道","08"),
    OrgStatus("机构状态","17"),
    OrgUserCategory("机构用户类型","18"),
    PermissionCategory("权限类型","05"),
    RoleCategory("角色类型","03"),
    UserStatus("用户状态","12"),
    ;
    private String name;
    private String val;

    public static String getName(String val){
        CodeCategoryEnum[] values = values();
        for(CodeCategoryEnum p:values){
            if(p.getVal().equals(val)){
                return p.getName();
            }
        }
        return null;
    }

    public static String getKey(String name){
        CodeCategoryEnum[] values = values();
        for(CodeCategoryEnum p:values){
            if(p.getName().equals(name)){
                return p.getVal();
            }
        }
        return null;
    }

    private CodeCategoryEnum(String name, String val){
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
