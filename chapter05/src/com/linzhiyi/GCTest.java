package com.linzhiyi;

import java.util.ArrayList;
import java.util.List;
/**
 * 测试Minor GC、Major GC、Full GC
 * -Xms9m -Xmx9m -XX:+PrintGCDetails
 * **/
public class GCTest {
    public static void main(String[] args) {
        int i = 0;
        try{
            List<String> list = new ArrayList<>();
            String a = "张三";
            while (true){
                list.add(a);
                a = a + a;
                i++;
            }
        }catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("遍历次数为："+i);
        }
    }
}
