package com.linzhiyi;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {

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
        //构造弱引用
        WeakReference<User> userWeakReference = new WeakReference<User>(new User(1,"linzhiyi"));
        //从弱引用中获取对象
        System.out.println(userWeakReference.get());

        System.gc();
        //不管内存是否充足，都会回收
        System.out.println("GC 结束");
        //重新从弱引用中获取对象
        System.out.println(userWeakReference.get());

    }
}
