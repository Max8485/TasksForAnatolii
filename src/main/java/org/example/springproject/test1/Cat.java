package org.example.springproject.test1;

public class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("Cat eating");
    }

    public void meow() {
        System.out.println("Cat is meow");
    }
}
