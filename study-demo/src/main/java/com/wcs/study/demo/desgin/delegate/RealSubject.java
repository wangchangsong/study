package com.wcs.study.demo.desgin.delegate;

/**
 * 真正执行任务的类，实现了代理接口
 *
 * @author pro
 */
public class RealSubject implements Subject {

    @Override
    public void dealTask(String taskName) {
        System.out.println("real subject task is running");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
