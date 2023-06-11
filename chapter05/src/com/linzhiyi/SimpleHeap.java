package com.linzhiyi;

public class SimpleHeap {
    private int id;

    public SimpleHeap(int id) {
        this.id = id;
    }

    public void show(){
        System.out.println("我的id是"+id);
    }

    public static void main(String[] args) {
        SimpleHeap simpleHeap1 = new SimpleHeap(1);
        SimpleHeap simpleHeap2 = new SimpleHeap(2);

        int[] arr = new int[10];

        Object[] arr2 = new Object[10];
    }
}
