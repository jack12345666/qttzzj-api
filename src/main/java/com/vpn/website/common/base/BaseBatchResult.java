package com.vpn.website.common.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @author wzh
 * @date 2020/5/17 23:45
 * 批量操作封装
 */
@Data
public class BaseBatchResult {
    private int successNum = 0;
    private int failNum = 0;
    private JSONArray errors =new JSONArray();

    /**
     * 成功操作
     */
    public void doSuccess(){
        this.successNum++;
    }
    /**
     * 成功操作
     */
    public void doFail(Object obj,String errMsg){
        JSONObject jsonObj = (JSONObject) JSON.toJSON(obj);
        jsonObj.put("errMsg",errMsg);
        errors.add(jsonObj);
        this.failNum++;
    }
}
