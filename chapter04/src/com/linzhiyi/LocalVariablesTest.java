package com.linzhiyi;

import java.util.Date;

public class LocalVariablesTest {

    private int count = 0;

    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        int num = 10;
        test.test1();
        //因为this变量不存在于当前方法的局部变量表中！！！所以会报错
        //System.out.println(this.count);
    }

    public void test1(){
        Date date = new Date();
        String name1 = "张三";
        String info = test2(date,name1);
        System.out.println(date+name1);
    }

    public String test2(Date datep,String name2){
        datep = null;
        name2 = "李四";
        double weight = 130.5;
        char gender = '男';
        return datep + name2;
    }

    public void test3(){
        count++;
    }

    public void test4(){
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        //变量c使用的是之前已经销毁的变量b所占据的slot的位置
        int c = a + 1;
    }

    /**
     * 变量的分类：按照数据类型分：1.基本数据类型 2.引用数据类型
     *           按照在类中声明的位置分：1.成员变量：在使用前，都经历过默认初始化赋值
     *                                  类变量(静态变量)：linking的prepare阶段：给类变量默认赋值
     *                                                  -->initial阶段：给类变量显示赋值以及静态代码块赋值
     *                                  实例变量：随着对象的创建，会在堆空间中分配实例变量空间，并进行默认赋值
     *                               2.局部变量：在使用前，必须要进行显示赋值，否则编译不通过
     */
}
