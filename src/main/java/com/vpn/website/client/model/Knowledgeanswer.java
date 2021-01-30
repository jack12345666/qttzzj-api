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
import java.util.Date;

/**
 * <p>
 * 知识问答答案表
 * </p>
 *
 * @author tao
 * @since 2021-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_knowledgeanswer")
@ApiModel(value="Knowledgeanswer对象", description="知识问答答案表")
public class Knowledgeanswer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "图片地址")
    @TableField("imgUrl")
    private String imgUrl;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "问题答案")
    private String content;

    @ApiModelProperty(value = "答案格式(1: 图文样式, 2: 卡片样式)")
    private Integer type;

    @ApiModelProperty(value = "状态(0：失效，1：正常，10：草稿)")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updateTime")
    private Date updateTime;


}
