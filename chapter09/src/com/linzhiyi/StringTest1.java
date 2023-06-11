package com.linzhiyi;
/**
 * String的基本使用：体现String的不可变性。
 *
 * **/
public class StringTest1 {

    //test1
//    public static void main(String[] args) {
//        String s1 = "abc"; //字面量定义的方式，"abc"存储在字符串常量池。
//        String s2 = "abc";
//        s1 = "hello";
//
//        System.out.println(s1==s2); //判断地址：true  修改s1 = "hello"  再判断：false
//
//        System.out.println(s1); //hello
//        System.out.println(s2); //abc
//    }

    //test2
//    public static void main(String[] args) {
         /**
//         s1 和 s2 指向堆中的同一个"abc"。
//         当s2被修改，s1指向的"abc"不会被修改。
//         而被修改的s2，会有一个新的指针指向"abcdef"，这就体现了不可变性。
         **/
//        String s1 = "abc";
//        String s2 = "abc";
//        s2 += "def";
//        System.out.println(s2);//abcdef
//        System.out.println(s1);//abc
//    }

    //test3
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = s1.replace('a','m');
        System.out.println(s1); //abc
        System.out.println(s2); //abm
        System.out.println(s1==s2); //false
    }


}
