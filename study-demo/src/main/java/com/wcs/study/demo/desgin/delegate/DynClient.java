package com.wcs.study.demo.desgin.delegate;

/**
 * 动态代理客户端类
 *
 * @author pro
 */
public class DynClient {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject proxy = DynProxyFactory.getInstance();
        proxy.dealTask("task");
    }

}
