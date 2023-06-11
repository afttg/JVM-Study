package com.linzhiyi;
/**
 * 导出GC日志文件：-Xloggc:./logs/gc.log
 * 修改后
 * */
import java.util.ArrayList;

public class GCLogsTest {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();

        for (int i =0; i < 500; i++){
            byte[] arr = new byte[1024 * 100];
            list.add(arr);
            try {
                Thread.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
