package com.linzhiyi;

public class ClassInitTest {

    private static int num = 1;

    static {
        num = 2;
        number = 20;
        System.out.println(num);
        //System.out.println(number); //报错：非法的前向引用。
    }

    private static int number = 10;  //在链接的准备阶段：num2 = 0 -->
                                    // 初始化阶段：重新覆盖 --> 20 -->10

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num); //2
        System.out.println(ClassInitTest.number); //10
    }
}
