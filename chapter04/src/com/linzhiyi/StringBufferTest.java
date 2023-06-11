package com.linzhiyi;

public class StringBufferTest {
    //是线程不安全的
    int num = 10;

    //s1的声明方式是线程安全的-->s1只在方法内部用
    public static void method1(){
        //StringBuffer：线程不安全的
        StringBuffer s1 = new StringBuffer();
        s1.append("a");
        s1.append("b");
    }

    //stringBuffer的操作过程：是线程不安全的-->形参，有可能被其他线程调用
    public static void method2(StringBuffer stringBuffer){
        stringBuffer.append("a");
        stringBuffer.append("b");
    }

    //s3的声明方式是线程不安全的-->有返回值，该返回值可能被多个线程操作
    public static StringBuffer method3(){
        //StringBuffer：线程不安全的
        StringBuffer s3 = new StringBuffer();
        s3.append("a");
        s3.append("b");
        return s3;
    }

    //s4的操作：是线程安全的
    public static String method4(){
        StringBuffer s4 = new StringBuffer();
        s4.append("a");
        s4.append("b");
        return s4.toString();
    }
}
