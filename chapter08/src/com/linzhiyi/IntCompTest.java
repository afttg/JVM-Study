package com.linzhiyi;

/**
 * -Xint:5615ms 只采用解释器模式
 * -Xcomp:759ms 只采用编译器模式
 * -Xmixed:733ms 解释器+编译器的混合模式
 *
 * **/
public class IntCompTest {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        testPrimeNumber(1000000);

        long end = System.currentTimeMillis();

        System.out.println("花费的时间为：" + (end - start) + "ms");
    }

    public static void testPrimeNumber(int count){
        for (int i = 0; i < count; i++){
            //计算100以内的质数
            label:for (int j = 2; j <= 100; j++){
            for (int k = 2; k <=Math.sqrt(j); k++){
                if (j % k == 0){
                    continue label;
                }
            }
                //System.out.println(j);
            }
        }
    }
}
