package com.linzhiyi;

/***
 * 证明：Java使用的不是引用计数算法。
 *
 */

public class RefCountGC {
    //这个成员变量唯一的作用就是占用一点内存
    private byte[] bigSize = new byte[5 * 1024 * 1024]; //5MB

    Object reference = null;

    public static void main(String[] args) {
        RefCountGC obj1 = new RefCountGC();
        RefCountGC obj2 = new RefCountGC();

        //使两个对象互相引用。
        obj1.reference = obj2;
        obj2.reference = obj1;

        obj1 = null;
        obj2 = null;
        //显式的执行垃圾回收行为
        //这里发生GC，obj1和obj2能否被回收？
        System.gc();

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
