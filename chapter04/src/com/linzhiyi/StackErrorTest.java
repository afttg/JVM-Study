package com.linzhiyi;

/*
* 设置栈的大小：-Xss256k：count：2465
*/

public class StackErrorTest {

    private static int count = 1;

    //演示栈中的异常
    public static void main(String[] args) {
        System.out.println(count);  //默认情况下，count : 11415
        count++;
        //StackOverflowError
        main(args);
    }

}
