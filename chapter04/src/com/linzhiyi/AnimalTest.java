package com.linzhiyi;

/**
 * 说明早期绑定和晚期绑定的例子
 **/

class Animal{
    public void eat(){
        System.out.println("动物进食");
    }
}

interface Huntable{
    void hunt();
}

class Cat extends Animal implements Huntable {

    public Cat() {
        super();
    }

    public Cat(String name) {
        this();//表现为：早期绑定
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("猫吃鱼儿");
    }

    @Override
    public void hunt() {
        System.out.println("捕食耗子，天经地义");
    }
}

class Dog extends Animal implements Huntable{

    @Override
    public void eat(){
        System.out.println("狗吃骨头");
    }

    @Override
    public void hunt() {
        System.out.println("捕食耗子，多管闲事");
    }
}

public class AnimalTest {

    public void showAnimal(Animal animal){
        animal.eat();//表现为：晚期绑定
    }

    public void showHunt(Huntable huntable){
        huntable.hunt();//表现为：晚期绑定
    }

}
