package com.linzhiyi;

/**
 * 标量替换测试
 * -Xmx100m -Xms100m -XX:+DoEscapeAnalysis -XX:+PrintGCDetails -XX:EliminateAllocations
 * */

public class ScalarReplace {

    public static class User{
        public int id;
        public String name;
    }

    public static void alloc(){
        User user = new User();  //未发生逃逸
        user.id = 5;
        user.name = "张三";
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000000; i++){
            alloc();
        }

        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start) + "ms");
    }
}
