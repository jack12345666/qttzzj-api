package com.vpn.website.common.filter;

import com.vpn.website.client.enums.AuthTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wzh
 * @date 2020/4/30 23:38
 * 普通用户授权信息
 */
@Data
public class AuthInfo implements Serializable {
    @ApiModelProperty(value = "用户ID")
    private Integer id;
    @ApiModelProperty(value = "账号")
    private String no;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "身份证")
    private String idCard;
    @ApiModelProperty(value = "昵称")
    private String nickname;
    @ApiModelProperty(value = "部门序号")
    private Integer deptId;
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    @ApiModelProperty(value = "性别 0未知 1男 2女")
    private Integer gender;
    @ApiModelProperty(value = "电子邮件")
    private String email;
    @ApiModelProperty(value = "手机")
    private String mobile;
    @ApiModelProperty(value = "电话")
    private String tel;

    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "用户类型")
    private Integer userType;   //用户类型  1 政府 2 企业
    @ApiModelProperty(value = "用户类型")


    /**
     * 是否是普通用户
     * @return
     */
    public boolean isMember(){
        return AuthTypeEnum.CORP.getVal().equals(userType);
    }

    public String getUserKey(){
        return userType+"_"+id;
    }

    public AuthInfo(int id, int userType) {
        this.id = id;
        this.userType = userType;
    }

    public AuthInfo() {
    }
}
