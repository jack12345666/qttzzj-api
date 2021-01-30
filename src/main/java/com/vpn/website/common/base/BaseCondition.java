package com.vpn.website.common.base;

import lombok.Data;

import java.io.Serializable;

/**
 * 查询条件
 */
@Data
public class BaseCondition implements Serializable {
    /**
     * 数据库字段名
     */
    private String column;
    /**
     * 字段值
     */
    private String value;
    /**
     * 连接类型，如llike,equals,gt,ge,lt,le
     */
    private String type;
}
