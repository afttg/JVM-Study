package com.linzhiyi;

public class ClInitTest {

    //任何一个类声明后，内部至少存在一个类的构造器

    private int a = 1;

    private static int c = 3;

    public static void main(String[] args) {
        int b = 2;
    }

    public ClInitTest(){
        a = 10;
        int b = 20;
    }

}
