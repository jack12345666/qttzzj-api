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
 * 知识问答分类表
 * </p>
 *
 * @author tao
 * @since 2021-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_knowledgecategory")
@ApiModel(value="Knowledgecategory对象", description="知识问答分类表")
public class Knowledgecategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "分类")
    private String category;

    @ApiModelProperty(value = "上级编号")
    @TableField("parentId")
    private Integer parentId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String comment;

    @ApiModelProperty(value = "图标")
    @TableField("iconFont")
    private String iconFont;

    @ApiModelProperty(value = "显示顺序")
    @TableField("displayNo")
    private Integer displayNo;

    @ApiModelProperty(value = "是否有效")
    @TableField("isValid")
    private Integer isValid;


}
