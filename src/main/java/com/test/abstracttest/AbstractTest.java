package com.test.abstracttest;

/**
 * 抽象类测试
 * @author cuijixu
 */
public abstract class AbstractTest {
    public void service(){
        System.out.println("进行权限判断");
        this.doService();
    }

    /**
     * 抽象方法
     */
    protected abstract void doService();
}
