package com.wcs.study.dubbo.spi.impl;

import com.wcs.study.dubbo.spi.DemoService;

/**
 * TODO 类描述
 *
 * @author pro
 */
public class EnglishDemoService implements DemoService {

    @Override
    public String sayHello(String msg) {
        return "hello" + msg;
    }
}
