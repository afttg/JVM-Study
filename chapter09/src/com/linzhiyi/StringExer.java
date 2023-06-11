package com.linzhiyi;

public class StringExer {

    String s1 = new String("good");
    char[] ch = {'t','e','s','t'};

    public void change(String s1,char ch[]){
        s1 = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {

        StringExer stringExer = new StringExer();
        stringExer.change(stringExer.s1, stringExer.ch);
        System.out.println(stringExer.s1);
        System.out.println(stringExer.ch);

    }
}
