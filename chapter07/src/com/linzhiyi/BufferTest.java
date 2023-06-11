package com.linzhiyi;

import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * 查看直接内存的占用和释放
 * */
public class BufferTest {
    private static final int BUFFER = 1024 * 1024 * 1024; //1GB

    public static void main(String[] args) {
        //allocateDirect方法里面new了一个DirectByteBuffer对象来操作本地内存
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
        System.out.println("直接内存分配完毕，请指示！");

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("直接内存开始释放");
        byteBuffer = null;
        System.gc();
        scanner.next();
    }
}
