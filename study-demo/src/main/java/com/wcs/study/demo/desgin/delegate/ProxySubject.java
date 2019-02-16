package com.wcs.study.demo.desgin.delegate;

/**
 * 代理类，实现了代理接口
 *
 * @author pro
 */
public class ProxySubject implements Subject {

    // 代理类持有一个委托类的对象引用
    private Subject delegate;

    public ProxySubject(Subject delegate) {
        this.delegate = delegate;
    }

    @Override
    public void dealTask(String taskName) {
        long time = System.currentTimeMillis();
        delegate.dealTask(taskName);
        long endTime = System.currentTimeMillis();
        System.out.println("task spend " + (endTime - time) + " ms");
    }
}
