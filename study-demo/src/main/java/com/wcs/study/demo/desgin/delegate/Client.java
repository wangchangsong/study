package com.wcs.study.demo.desgin.delegate;

/**
 * 客户类
 *
 * @author pro
 */
public class Client {

    public static void main(String[] args) {
        Subject proxy = SubjectStaticFactory.getInstance();
        proxy.dealTask("task");
    }
}
