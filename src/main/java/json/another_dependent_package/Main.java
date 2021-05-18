package json.another_dependent_package;

import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

    public static List<String> findTag(String str) {
        int start_pos = 0;
        List<String> list = new ArrayList<>();
        while(start_pos>=0 && start_pos < str.length()) {
            int opening = str.indexOf('<', start_pos);
            if (opening < 0) {
                return list;
            }
            int closing = str.indexOf('>', opening + 1);
            if (closing < 0) {
                return list;
            }
            list.add(str.substring(opening+1, closing));
            start_pos = closing + 1;
        }
        return  list;
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
