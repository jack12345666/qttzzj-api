package com.vpn.website.common.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vpn.website.common.annotation.MyQuery;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author wang
 * @Date 2020/5/15 16:24
 * @Desc 基础查询
 */
public abstract class BaseQuery<T> {
    private static final Logger logger = LoggerFactory.getLogger(BaseQuery.class);

    public static final String eq = "eq";
    public static final String ne = "ne";
    public static final String in = "in";
    public static final String like = "like";
    public static final String leftlike = "leftlike";
    public static final String rightlike = "rightlike";
    public static final String notlike = "notlike";
    public static final String gt = "gt";
    public static final String lt = "lt";
    public static final String ge = "ge";
    public static final String le = "le";
    public static final String between = "between";
    public static final String orderDesc = "orderDesc";
    public static final String orderAsc = "orderAsc";

    /**
     * 查询类
     */
    @ApiModelProperty(hidden = true)
    private QueryWrapper<T> queryWrapper = new QueryWrapper<>();
    public final QueryWrapper<T> build(){
        return this.queryWrapper;
    }


    /**
     * 生成最终的查询，兼容旧版本，可重写该方法，实现自定义查询 QueryWrapper
     * @return
     */
    public QueryWrapper<T> buildQuery(){
        return annoQuery();
    }

    /**
     * 通过注解的方式注入参数
     * @return
     */
    public final QueryWrapper<T> annoQuery(){
        Class<? extends BaseQuery> cls = this.getClass();
        Field[] fields = cls.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            MyQuery mq = field.getAnnotation(MyQuery.class);
            if(mq!=null){
                field.setAccessible(true);
                // 获取属性的对应的值
                try {
                    Object val = field.get(BaseQuery.this);
                    this.addCondition(mq.value(),mq.column(),val);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        return build();
    }


    /**
     * 添加条件,值为空时会拦截
     * @param type  条件类型
     * @param column  列
     * @param val  值
     */
    public final BaseQuery<T> addCondition(String type, String column, Object val){
        return addCondition(type,column,val,true);
    }

    /**
     * 添加条件
     * @param type  条件类型
     * @param column  列
     * @param val  值
     * @param checkValNull  是否对值验证空，默认验证空
     */
    public final BaseQuery<T> addCondition(String type, String column, Object val, boolean checkValNull){
        if(checkValNull && (val==null || ((val instanceof String) && StringUtils.isEmpty((String)val)))){
            return this;
        }
        switch (type){
            case in: {
                queryWrapper.in(column,((String)val).split(","));
                break;
            }
            case eq: queryWrapper.eq(column,val);break;
            case ne: queryWrapper.ne(column,val);break;
            case like: queryWrapper.like(column,val);break;
            case leftlike: queryWrapper.likeLeft(column,val);break;
            case rightlike: queryWrapper.likeRight(column,val);break;
            case notlike: queryWrapper.notLike(column,val);break;
            case gt: queryWrapper.gt(column,val);break;
            case lt: queryWrapper.lt(column,val);break;
            case ge: queryWrapper.ge(column,val);break;
            case le: queryWrapper.le(column,val);break;
            case between: queryWrapper.between(column,((String)val).substring(0, ((String) val).indexOf("-")),((String)val).substring(((String)val).substring(0, ((String) val).indexOf("-")).length()+1));break;
            case orderDesc: queryWrapper.orderByDesc(column);break;
            case orderAsc: queryWrapper.orderByAsc(column);break;
        }
        return this;
    }

}
