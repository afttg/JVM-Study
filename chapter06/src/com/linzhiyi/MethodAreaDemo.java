package com.linzhiyi;
/**
 * 测试方法区大小参数的设置
 * jdk8及以后：
 * 通过-XX:MetaspaceSize=100M -XX:MaxMetaspaceSize=100M设置参数
 * **/
public class MethodAreaDemo {
    public static void main(String[] args) {
        System.out.println("start");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
