package json.another_dependent_package;

import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Main {

    public static Optional<String> findTag(String str) {
        int opening = str.indexOf('<');
        if (opening < 0) {
            return Optional.empty();
        }
        int closing = str.indexOf('>', opening + 1);
        if (closing < 0) {
            return Optional.empty();
        }
        return Optional.of(str.substring(opening+1, closing));
    }

    public static String HTMLElements(String str) {
        // code goes here
        return str;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(HTMLElements(s.nextLine()));
    }

}
