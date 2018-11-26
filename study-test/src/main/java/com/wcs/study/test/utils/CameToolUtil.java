package com.wcs.study.test.utils;

import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 驼峰转为下滑线
 *
 * @author pro
 */
public class CameToolUtil {

    public static final char UNDERLINE = '_';

    public static void convert(Object json) {
        if (json instanceof JSONArray) {
            JSONArray arr = (JSONArray) json;
            for (Object obj : arr) {
                convert(obj);
            }
        } else if (json instanceof JSONObject) {
            JSONObject jo = (JSONObject) json;
            Set<String> keys = jo.keySet();
            String[] array = keys.toArray(new String[keys.size()]);
            for (String key : array) {
                Object value = jo.get(key);
                StringBuilder sb = new StringBuilder(key.length());
                if (jo.get(key) instanceof JSONArray || jo.get(key) instanceof JSONObject) {
                    convert(jo.get(key));
                }
                for (int i = 0; i < key.length(); i++) {
                    char c = key.charAt(i);
                    if (Character.isUpperCase(c)) {
                        sb.append(UNDERLINE);
                        sb.append(Character.toLowerCase(c));
                    } else {
                        sb.append(c);
                    }
                }
                jo.remove(key);
                jo.put(sb.toString(), value);
            }
        }
    }

    public static Object convert(String json) {
        Object obj = JSON.parse(json);
        convert(obj);

        return obj;
    }
}
