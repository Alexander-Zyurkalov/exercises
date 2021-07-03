package zyurkalov;

class Animal{}
class Cat extends Animal{
}
class BengalCat extends Cat{}

public class MySuperClass {
    public void method(Cat cat) {

    }

    public static void main(String[] args) {

    }
}

class MyClass extends MySuperClass {

    @Override
    public void method(Cat cat) {
        super.method(cat);
    }
}
