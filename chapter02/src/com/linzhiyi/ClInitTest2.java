package com.linzhiyi;

public class ClInitTest2 {

    static class Father{

        public static int a = 1;

        static {
            a = 2;
        }

    }

    static class Son extends Father{
        public static int b = a;
    }

    public static void main(String[] args) {
        System.out.println(Son.b); //2
    }

}
