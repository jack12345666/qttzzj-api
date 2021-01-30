package com.vpn.website.common.base;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@ApiModel("返回结果")
public class BaseResult {
    /**
     * 未授权状态
     */
    public static final int CODE_NOAUTH = 99;
    //状态码 - 成功
    public static final int CODE_SUCCESS = 0;
    //状态码 - 失败
    public static final int CODE_FAIL = -1;

    @ApiModelProperty(value = "返回码 0 成功 非0即失败",dataType = "int")
    private int code;   //返回码 非0即失败
    @ApiModelProperty(value = "消息提示，一般为成功提示或者失败时的具体原因",dataType = "String")
    private String msg; //消息提示
    @ApiModelProperty(value = "数据")
    private Map<String, Object> data = new HashMap<>(); //返回的数据

    public BaseResult(){};

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResult(int code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResult(int code, Object obj) {
        this.code = code;
        this.data.put("data",obj);
    }

    public BaseResult(int code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.data.put("data",obj);
    }

    /**
     * 构建BaseResult
     * @return
     */
    public static BaseResult initResult(int code,String msg){
        return new BaseResult(code,msg);
    }

    /**
     * 构建一个成功的返回
     * @return
     */
    public static BaseResult initSuccessResult(){
        return new BaseResult(CODE_SUCCESS,null);
    }

    /**
     * 构建一个成功的返回
     * @param msg 返回消息
     * @return
     */
    public static BaseResult initSuccessResult(String msg){
        return new BaseResult(CODE_SUCCESS,msg);
    }

    /**
     * 构建一个带数据的成功返回
     * @param msg
     * @param obj
     * @return
     */
    public static BaseResult initSuccessResult(String msg ,Object obj){
        return new BaseResult(CODE_SUCCESS,msg,obj);
    }

    /**
     * 构建一个成功的返回
     * @return
     */
    public static BaseResult initSuccessResult(Object obj){
        return new BaseResult(CODE_SUCCESS,obj);
    }

    /**
     * 构建一个失败的返回
     * @return
     */
    public static BaseResult initFailResult(){
        return new BaseResult(CODE_FAIL,null);
    }

    /**
     * 构建一个失败的返回
     * @param msg 返回消息
     * @return
     */
    public static BaseResult initFailResult(String msg){
        return new BaseResult(CODE_FAIL,msg);
    }

    public static String success() {
        return success(new HashMap<>(0));
    }
    public static String success(Map<String, Object> data) {
        return JSON.toJSONString(new BaseResult(0, "解析成功", data));
    }

    public static String failed() {
        return failed("解析失败");
    }
    public static String failed(String msg) {
        return failed(-1, msg);
    }
    public static String failed(int code, String msg) {
        return JSON.toJSONString(new BaseResult(code, msg, new HashMap<>(0)));
    }

    /**
     * 向返回数据添加数据键值对
     * @param key
     * @param val
     */
    public void put(String key,Object val){
        this.data.put(key,val);
    }
}
