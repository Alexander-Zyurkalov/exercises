package zyurkalov;

public class Main {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();
        OuterClass.NonStaticInnerClass nonStaticInnerClass = outerClass.new NonStaticInnerClass();
    }
}
