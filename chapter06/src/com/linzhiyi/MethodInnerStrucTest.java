package com.linzhiyi;

import java.io.Serializable;

public class MethodInnerStrucTest extends Object implements Comparable, Serializable {

    //属性
    public int num = 10;
    private static String string = "测试方法的内部数据";
    //构造器
    //方法
    public void test1(){
        int count = 20;
        System.out.println("count=" + count);
    }

    public static int test2(int cal){
        int result = 0;
        try{
            int value = 30;
            result = value / cal;
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
