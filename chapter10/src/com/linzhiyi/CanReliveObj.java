package com.linzhiyi;

/**
 * 测试Object类中finalize()方法：即对象的finalization机制。
 * */

public class CanReliveObj {

    public static CanReliveObj obj; //类变量，属于 GC Roots

    //重写finalize方法，使得对象obj可以复活。此方法只会被调用一次。
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("调用当前类重写的finalize()方法");
        obj = this; //当前带回收的对象在finalize()方法中与引用链上的任何一个对象建立联系。
    }

    public static void main(String[] args) {
        try{
            obj = new CanReliveObj();
            //对象第一次拯救自己
            obj = null;
            System.gc(); //调用垃圾回收器
            System.out.println("第1次 GC");
            //因为finalizer线程优先级很低，暂停2秒，以等待它
            Thread.sleep(2000);
            if(obj == null){
                System.out.println("obj is dead");
            }else {
                System.out.println("obj is still alive");
            }
            System.out.println("第2次 GC");
            //下面这段代码和上面的完全相同，但这次自救却失败了
            obj = null;
            System.gc(); //调用垃圾回收器
            //因为finalizer线程优先级很低，暂停2秒，以等待它
            Thread.sleep(2000);
            if(obj == null){
                System.out.println("obj is dead");
            }else {
                System.out.println("obj is still alive");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
