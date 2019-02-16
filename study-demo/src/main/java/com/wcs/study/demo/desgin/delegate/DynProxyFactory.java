package com.wcs.study.demo.desgin.delegate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 生成动态代理对象的工厂
 *
 * @author pro
 */
public class DynProxyFactory {

    public static Subject getInstance() {
        Subject delegate = new RealSubject();
        InvocationHandler handler = new SubjectInvocationHandler(delegate);
        delegate.getClass().getClassLoader();
        Subject proxy = null;
        proxy = (Subject) Proxy.newProxyInstance(delegate.getClass().getClassLoader(),
                delegate.getClass().getInterfaces(),
                handler);
        return proxy;
    }

}
