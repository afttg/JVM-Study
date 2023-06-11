package com.linzhiyi;

/**
 * 1.设置堆空间大小的参数
    “-Xms”：用于设置堆区(年轻代+老年代)的起始内存，等价于-XX:InitialHeapSpace
        -X 是JVM的允许参数
        ms 是memory start
    “-Xmx”：用于设置堆区(年轻代+老年代)的最大内存，等价于-XX:MaxHeapSpace

 * 2.默认堆空间的大小
 *     初始内存大小：物理电脑内存 / 64
 *     最大内存大小：物理电脑内存 / 4
 *
 * 3.手动设置：-Xms600m -Xmx600m
 *
 * 4.查看设置的参数：方式一：jps + jstat -gc 进程id
 *                方式二： -XX:+PrintGCDetails
 **/

public class HeapSpaceInitial {
    public static void main(String[] args) {
        //返回Java虚拟机中的堆内存容量
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        //返回Java虚拟机试图使用的最大堆内存存量
        long MaxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms："+initialMemory+"M");
        System.out.println("-Xmx："+MaxMemory+"M");

//        System.out.println("系统的内存大小为："+initialMemory * 64.0 / 1024+"G");
//        System.out.println("系统的内存大小为："+MaxMemory * 4.0 / 1024+"G");

//        try {
//            Thread.sleep(1000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
