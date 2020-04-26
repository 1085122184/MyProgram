package com.conf;





/**
 * @author cuijixu
 */
public class MyTest {

    int id;
    static int ids = 0;
   public MyTest(){
       ids=ids+1;
       id = id+1;
        System.out.println(id);System.out.println(ids);

    }

    public static void main(String[] args) {
        MyTest t = new MyTest();
        MyTest t1 = new MyTest();
        MyTest t2 = new MyTest();
    }
}
