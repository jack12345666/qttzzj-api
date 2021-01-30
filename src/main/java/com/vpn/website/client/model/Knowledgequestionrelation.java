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
 * @author tao
 * @since 2021-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_knowledgequestionrelation")
@ApiModel(value="Knowledgequestionrelation对象", description="知识问答关联问题表")
public class Knowledgequestionrelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "问题id")
    @TableField("questionId")
    private Integer questionId;

    @ApiModelProperty(value = "关联问题id")
    @TableField("relationId")
    private Integer relationId;

    @ApiModelProperty(value = "答案id")
    @TableField("answerId")
    private Integer answerId;


}
