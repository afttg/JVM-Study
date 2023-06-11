package com.linzhiyi;
/**
*方法的结束分为两种：
 * 1.正常结束，以return为代表
 * 2.方法执行中出现未捕获处理的异常，以抛出异常的方式
**/

public class StackFrameTest {

    public static void main(String[] args) {
        StackFrameTest stackFrameTest = new StackFrameTest();
        try {
            stackFrameTest.method1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main方法正常结束");
    }

    public void method1(){
        System.out.println("方法1开始执行");
        method2();
        System.out.println("方法1执行结束");
        System.out.println(10/0);  //故意写错,看看main是否能正常结束：不能！
                                   //加了try/catch后就可以正常结束。
    }

    public void method2() {
        System.out.println("方法2开始执行");
        method3();
        System.out.println("方法2执行结束");
    }

    public void method3() {
        System.out.println("方法3开始执行");
        System.out.println("方法3执行结束");
    }
}
