package com.vpn.website.client.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.vpn.website.exception.BaseException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author bitwang
 * @Date 2020/4/16 16:20
 * @Desc
 */
public class AppUtil {
    public static SimpleDateFormat FMT_DAY = new SimpleDateFormat("yyyyMMdd");
    public static long LAST_FLOOW_NUM = 1;
    public static String LAST_FLLOW_DAY = null;

    /**
     * 判断对象是否为空，是则抛出全局异常
     * @param obj
     * @param tipMessage
     */
    public static void checkObjNull(Object obj,String tipMessage){
        if(obj==null){
            throw new BaseException(tipMessage);
        }
    }

    /**
     * 验证字符串长度
     * @param str
     * @param minLen
     * @param maxLen
     * @param tipMessage
     */
    public static void checkStringLen(String str,int minLen,int maxLen,String tipMessage){
        if(StringUtils.isEmpty(str)){
            return;
        }
        if(str.length()<minLen || str.length()>maxLen){
            throw new BaseException(tipMessage);
        }
    }

    /**
     * 数量是否大于0，是则抛出全局异常
     * @param count
     * @param tipMessage
     */
    public static void checkNumLG0(int count,String tipMessage){
        if(count>0){
            throw new BaseException(tipMessage);
        }
    }

    /**
     * 数量是否小于等于0，是则抛出全局异常
     * @param count
     * @param tipMessage
     */
    public static void checkNumLT0(int count,String tipMessage){
        if(count<=0){
            throw new BaseException(tipMessage);
        }
    }

    /**
     * 判断对象是否不为空，不为空则抛出全局异常
     * @param obj
     * @param tipMessage
     */
    public static void checkObjNotNull(Object obj,String tipMessage){
        if(obj!=null){
            throw new BaseException(tipMessage);
        }
    }

    /**
     * 订单号生成
     * @return
     */
    public static synchronized String generateTradeNo() {
        String day = FMT_DAY.format(new Date());
        if (!day.equals(LAST_FLLOW_DAY)) {
            LAST_FLLOW_DAY = day;
            LAST_FLOOW_NUM = 1;
        }else{
            LAST_FLOOW_NUM++;
        }
        return System.currentTimeMillis() +""+ (10000 + LAST_FLOOW_NUM);
    }

    /**
     * 获取一个当前时间字符
     * @return
     */
    public static String getCurrentTimeStr(){
        return  DateFormatUtils.format(new Date(),"yyyyMMdd_HHmmss");
    }

    /**
     * 将导入数据转换成对象数据
     * @param list  数据
     * @return
     */
    public static <T> List<T> convertMapToDatas(List<Map<String, String>> list, Class<T> cls) {
        List<T> datas = new ArrayList();
        for(Map<String, String> yd:list){
            //将Map转为对象
            T data = JSONObject.parseObject(JSON.toJSONString(yd), cls);
            datas.add(data);
        }
        return datas;
    }

    /**
     * 获取一个附件保存路径
     *
     * @param rootPath  附件根目录
     * @param modelName 模块名，附件按模块存储
     * @return
     */
    public static String getFileSavepath(String rootPath, String modelName) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        String year = String.valueOf(cal.get(Calendar.YEAR));
        String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
        String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        if (month.length() == 1) {
            month = "0" + month;
        }
        if (day.length() == 1) {
            day = "0" + day;
        }
        String filePath;
        if(null == modelName) {
            filePath =  "/" + year + "/" + month + "/" + day + "/";
        }else  {
            filePath = "/" + modelName + "/" + year + "/" + month + "/" + day + "/";
        }
        File f = new File(rootPath + filePath);
        if (!f.exists()) {
            f.mkdirs();
        }
        return filePath;
    }

    /**
     * 获取文件名后缀
     * @param fileName
     * @return
     */
    public static String getFileExt(String fileName) {
        if(StringUtils.isEmpty(fileName)){
            return null;
        }
        int idx = fileName.lastIndexOf(".");
        if(idx>0){return fileName.substring(idx+1);}
        return null;
    }

    public static String getFileName(String filePath) {
        if(StringUtils.isEmpty(filePath)) {
            return null;
        }
        File tmpFile = new File(filePath);
        return tmpFile.getName();
    }
}
