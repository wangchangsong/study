package com.wcs.study.demo.demo;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Cglib测试类
 *
 * @author cuiran
 * @version 1.0
 */
public class CglibTest {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {

        // 设置类成员属性
        HashMap propertyMap = new HashMap();

        propertyMap.put("id", Class.forName("java.lang.Integer"));

        propertyMap.put("name", Class.forName("java.lang.String"));

        propertyMap.put("address", Class.forName("java.lang.String"));

        propertyMap.put("address1", Class.forName("java.lang.String"));

        propertyMap.put("2018-07", Class.forName("java.lang.String"));

        // 生成动态 Bean
        CglibBean bean = new CglibBean(propertyMap);

        // 给 Bean 设置值
        bean.setValue("id", new Integer(123));

        bean.setValue("name", "454");

        bean.setValue("address", "789");

        bean.setValue("address1", "789");

        // 从 Bean 中获取值，当然了获得值的类型是 Object

        System.out.println("  >> id      = " + bean.getValue("id"));

        System.out.println("  >> name    = " + bean.getValue("name"));

        System.out.println("  >> address = " + bean.getValue("address"));

        // 获得bean的实体
        Object object = bean.getObject();


        User user = JSON.parseObject(JSON.toJSONString(object), User.class);
        System.out.println(" user "+ user.getAddress());

        Set<String> set = new LinkedHashSet<>();
        set.add("hell");
        set.add("jk");
        set.add("skdjf");

        for (String str : set) {
            System.out.println(str);
        }

        // 通过反射查看所有方法名
        Class clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().startsWith("get")) {
                String key = StringUtils.uncapitalize(StringUtils.substring(methods[i].getName(), 3));
//                System.out.println(bean.getValue(key));
//                System.out.println(methods[i].getName());
            }
        }
    }
}