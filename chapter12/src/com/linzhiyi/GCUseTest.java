package com.linzhiyi;
/**
 *   -XX:+PrintCommandLineFlags
 *
 *  使用 -XX:+UseSerialGC 参数可以指定年轻代和老年代都使用串行收集器
 *  等价于新生代使用Serial GC，且老年代使用Serial Old GC。
 *
 * -XX:+UseParNewGC手动指定使用ParNew GC
 * -XX:ParallelGCThreads 限制线程数量，默认开启和CPU数据相同的线程数。
 *
 * -XX:+UseParallelGC 手动指定年轻代使用parallel GC
 * -XX:UseParallelOldGC 手动指定老年代使用ParallelOld GC
 *  说明：二者可以相互激活
 *
 *  -XX:UseConcMarkSweepGC 手动指定老年代使用CMS GC，同时，年轻代会触发对ParNew的使用
 * */
import java.util.ArrayList;

public class GCUseTest {

    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();

        while (true){
            byte[] arr = new byte[100];
            list.add(arr);
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
