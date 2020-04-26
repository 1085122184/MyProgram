package com.test.abstracttest;

/**
 * @author cuijixu
 */
public class AbstractTestImpl extends AbstractTest{
    @Override
    protected void doService() {
        System.out.println("权限判断后做。。。。");
    }

    public static void main(String[] args) {
        AbstractTest abstractTest = new AbstractTestImpl();
        abstractTest.service();
    }
}
