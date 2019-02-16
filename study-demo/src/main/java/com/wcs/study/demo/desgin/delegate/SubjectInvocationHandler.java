package com.wcs.study.demo.desgin.delegate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类对应的调用处理程序类
 *
 * @author pro
 */
public class SubjectInvocationHandler implements InvocationHandler {

    private Object delegate;

    public SubjectInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long time = System.currentTimeMillis();
        method.invoke(delegate, args);
        long endTime = System.currentTimeMillis();
        System.out.println("Dyn task spend " + (endTime - time) + " ms");
        return null;
    }
}
