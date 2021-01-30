package com.vpn.website.client.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 编码表
 * </p>
 *
 * @author xiaotao
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_code")
@ApiModel(value="Code对象", description="编码表")
public class Code implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "类型")
    private String category;

    @ApiModelProperty(value = "简称")
    private String simple;

    @ApiModelProperty(value = "显示顺序")
    @TableField("displayNo")
    private Integer displayNo;

    @ApiModelProperty(value = "是否有效")
    @TableField("isValid")
    private Integer isValid;


}
