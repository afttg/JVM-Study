package com.linzhiyi;
/**
 * 软引用测试
 * 设置堆大小为10m
 * */
import java.lang.ref.SoftReference;

public class SoftReferenceTest {

    public static class User{

        public User(int id,String name){
            this.id = id;
            this.name = name;
        }

        public int id;
        public String name;

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        //创建对象，建立软引用
        SoftReference<User> userSoftReference = new SoftReference<User>(new User(1,"linzhiyi"));

        //从软引用中重新获得强引用对象
        System.out.println(userSoftReference.get());

        System.gc();
        System.out.println("GC 结束");

        //从软引用中重新获得强引用对象
        System.out.println(userSoftReference.get()); //由于堆空间内存足够，所以不会回收软引用的可达对象

        try{
            //让系统认为资源紧张、不足
            byte[] b = new byte[1024 * 1024 * 7];
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            //再次从软引用中获取数据
            System.out.println(userSoftReference.get()); //在报OOM之前，垃圾回收器会回收软引用的可达对象。
        }
    }

}
