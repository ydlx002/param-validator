package io.github.ydlx.constant;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package io.github.ydlx.constant
 * @Author lizhenhua
 * @Date 2018/6/21 15:19
 */
public class ResultCode {

    private static final Map<String, String> dataMap = new ConcurrentHashMap<String, String>();

    public static final String RESULT_CODE_0000 = "0000";
    public static final String RESULT_DESC_0000 = "success";

    public static final String RESULT_CODE_9999 = "9999";
    public static final String RESULT_DESC_9999 = "fail";

    public static final String RESULT_CODE_0001 = "0001";
    public static final String RESULT_DESC_0001 = "不能为空";

    public static final String RESULT_CODE_0002 = "0002";
    public static final String RESULT_DESC_0002 = "类型不支持";

    public static final String RESULT_CODE_0003 = "0003";
    public static final String RESULT_DESC_0003 = "长度必须介于%s 和%s之间";

    public static final String RESULT_CODE_0004 = "0004";
    public static final String RESULT_DESC_0004 = "格式不正确";

    static {
        Field[] fields = ResultCode.class.getDeclaredFields();
        try {
            Class clazz = Class.forName("io.github.ydlx.constant.ResultCode");
            for(int i = 0 , len = fields.length; i < len; i++) {
                // 对于每个属性，获取属性名
                String name = fields[i].getName();
                String value = fields[i].get(clazz).toString();
                if(name.startsWith("RESULT_")){
                    dataMap.put(name, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDesc(String resultCode){
        return dataMap.get("RESULT_DESC_"+resultCode);
    }
}
