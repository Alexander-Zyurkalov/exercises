package json;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MyClass {
    public int okF(int a) {
        return a * a;
    }

    public static void goTO(List<String> myList2) {
        myList2.add("7777");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("The default locale is: " + Locale.getDefault());
        Locale[] locales = Locale.getAvailableLocales();
        System.out.printf("No. of other available locales is: %d, and they are: %n",
                locales.length);
        Arrays.stream(locales).forEach(
                locale -> System.out.printf("Locale code: %s and it stands for %s %n",
                        locale, locale.getDisplayName()));

    }
}
