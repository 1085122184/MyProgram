package com.test.inner;


/**
 * 内部类测试
 * @author cuijixu
 */
public class InnerClass {
    public class InnerOne{
        public InnerOne(){
            System.out.println("my name is one");
        }
    }
    public void test(){
        class InnerTwo{
            public InnerTwo(){
                System.out.println("my name is two");
            }
        }
    }

    public int intTest(){
        int i = 1;
        try {
            return i;
        }finally {
            i++;
           return i;
        }
    }
    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        InnerClass.InnerOne one = innerClass.new InnerOne();

        System.out.println(innerClass.intTest());

    }
}
