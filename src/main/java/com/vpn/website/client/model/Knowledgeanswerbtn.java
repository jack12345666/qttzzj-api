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
 * 知识问答答案卡片样式按钮表
 * </p>
 *
 * @author tao
 * @since 2021-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_knowledgeanswerbtn")
@ApiModel(value="Knowledgeanswerbtn对象", description="知识问答答案卡片样式按钮表")
public class Knowledgeanswerbtn implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "答案id")
    @TableField("answerId")
    private Integer answerId;

    @ApiModelProperty(value = "类型(1: 跳转页面，2：关联问答)")
    private Integer type;

    @ApiModelProperty(value = "关联问答或者跳转地址")
    private String content;


}
