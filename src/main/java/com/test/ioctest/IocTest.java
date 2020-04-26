package com.test.ioctest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author cuijixu
 */
public class IocTest {
    private MyTest myTest;

    public MyTest getMyTest() {
        return myTest;
    }

    @Autowired
    public void setMyTest(MyTest myTest) {
        this.myTest = myTest;
    }
}

@Component
class MyTest{
    @Value("张三")
    private String name;

    @Override
    public String toString() {
        return "MyTest{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Test{
    public static void main(String[] args) {
        IocTest iocTest = new IocTest();
        iocTest.getMyTest().toString();
    }
}