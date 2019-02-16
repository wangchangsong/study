package com.wcs.study.demo.desgin.delegate;

/**
 * 静态代理工厂类
 *
 * @author pro
 */
public class SubjectStaticFactory {

    public static Subject getInstance() {
        return  new ProxySubject(new RealSubject());
    }

}
