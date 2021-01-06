package json;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyClass {
    public int okF(int a) {
        return a * a;
    }

    public static void goTO(List<String> myList2) {
        myList2.add("7777");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Locale currentLocale = Locale.getDefault();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("names", currentLocale);
        System.out.println(resourceBundle.getString("myName"));

    }
}
