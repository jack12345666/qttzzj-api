package com.vpn.website.client.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: tao
 * @Date: 2020/12/30 17:47
 */
@Data
@ApiModel(value = "com-vpn-website-client-model-TBuildingleasestreet")
@TableName(value = "t_buildingleasestreet")
public class TBuildingleasestreet implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Long id;

    @TableField(value = "leaseId")
    @ApiModelProperty(value = "租赁序号")
    private Long leaseId;

    @TableField(value = "areaId")
    @ApiModelProperty(value = "街道id")
    private String areaId;

    @TableField(value = "areaName")
    @ApiModelProperty(value = "街道名称")
    private String areaName;

    @TableField(value = "isValid")
    @ApiModelProperty("是否有效")
    private Long isValid;


}