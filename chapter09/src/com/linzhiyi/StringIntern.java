package com.linzhiyi;

/**
 * 如何保证变量s指向的是字符串常量池中的数据呢？
 * 两种方式：
 *  方式一：String s = "hello"; //字面量的方式
 *  方式二：String s = new String("hello").intern();
 *         String s = new StringBuilder("hello").toString.intern(); //调用intern方法
 *
 * */
public class StringIntern {
    public static void main(String[] args) {

        String s1 = new String("1");
        s1.intern(); //调用此方法之前，字符串常量池中已经存在"1"。
        String s2 = "1";
        System.out.println(s1 == s2); //JDK6:false  JDK7/8:false

        String s3 = new String("1") + new String("1"); //s3变量记录的地址为：new String("11")
        //执行完上一行代码后，字符串常量池中，是否存在"11"呢？ 不存在！！！
        s3.intern(); //在字符串常量池中生成"11"。
        //在JDK6中调用intern方法，会创建一个新的对象"11"，也就有了新的地址。
        //在JDK7以后，由于字符串常量池放到了堆空间中，为了节省空间，此时常量中并没有创建"11"对象，而是创建一个指向堆空间new String("11")的地址
                   //字符串常量池中"11"对象的地址，就是堆中new String("11")的地址！！
        String s4 = "11"; //使用的是上一行代码执行时，在字符串常量池中生成的"11"的地址。
        System.out.println(s3 == s4); //JDK6:false  JDK7/8:true
    }
}
