package com.linzhiyi;

/**
 * 使用intern()测试执行效率：空间上的使用
 * 结论：对于程序中大量存在的字符串，尤其是intern()可以节省内存空间。
 *
 * */
public class StringIntern3 {

    static final int MAX_COUNT = 1000 * 10000;
    static final String[] arr = new String[MAX_COUNT];

    public static void main(String[] args) {
        Integer[] data = new Integer[]{1,2,3,4,5,6,7,8,9,10};

        long start = System.currentTimeMillis();

        for (int i = 0; i < MAX_COUNT; i++){
            //3297ms
            //arr[i] = new String(String.valueOf(data[i % data.length]));
            //1004ms
            arr[i] = new String(String.valueOf(data[i % data.length])).intern();
        }

        long end = System.currentTimeMillis();

        System.out.println("花费的时间为：" + (end - start) + "ms");

        //不让程序结束。
        //打开jvisualvm-->抽样器-->内存，查看String的情况。
        try{
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();

    }

}
