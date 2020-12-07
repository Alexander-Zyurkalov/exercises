package json;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MyClass {
    public int okF(int a) {
        return a * a;
    }

    public static void goTO(List<String> myList2) {
        myList2.add("7777");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<String> myList = new ArrayList<>();
        myList.add("111");
        myList.add("12222");
        myList.add("3333");
        myList.add("4444");
        myList.add("5555");
        if (myList.size() < 5)
            myList.remove("3333");
        goTO(myList);
        myList.add("666");

    }
}
