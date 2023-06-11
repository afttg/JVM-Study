package com.linzhiyi;

public class DeadThreadTest {

    public static void main(String[] args) {
        Runnable r = () ->{
            System.out.println(Thread.currentThread().getName() + "开始");
            DeadThread dead = new DeadThread();  //不能继续执行
            System.out.println(Thread.currentThread().getName() + "结束");

        };

        Thread thread1 = new Thread(r,"线程1");
        Thread thread2 = new Thread(r,"线程2");

        thread1.start();
        thread2.start();
    }
}

//线程1和线程2谁先进来，谁就对DeadThread初始化，但是停在了初始化阶段，不能继续执行。
//当不能继续执行时，下一个线程不能进入到DeadThread中进行初始化，这就是同步加锁。
class DeadThread{
    static {
        if (true){
            System.out.println(Thread.currentThread().getName() + "初始化当前类");
            while (true){

            }
        }
    }
}
