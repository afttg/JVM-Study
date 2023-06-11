package com.linzhiyi;
/**
 * 扩展：原题是StringIntern中的代码。
 * 将 String s4 = "11";和 s3.intern();这两行代码互换位置，解释结果为什么变成false？
 * */
public class StringIntern2 {
    public static void main(String[] args) {
        String s3 = new String("1") + new String("1");  //new String("11")-->在堆中
        //执行完上一行代码以后，字符串常量池中，是否存在"11"呢？ 不存在！！！
        String s4 = "11";  //对象"11"-->在堆中的字符串常量池中
        s3.intern(); //去常量池找是否有常量"11"，已经有了，但不影响s3和s4的地址，实际上没有进行任何操作。
        String s5 = s3.intern(); //用s5去接受 s3.intern();的值，该地址就是s4的地址。
        System.out.println(s3 == s4);//false
        System.out.println(s4 == s5);//true
    }
}
