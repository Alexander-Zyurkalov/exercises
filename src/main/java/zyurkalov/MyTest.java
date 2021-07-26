package zyurkalov;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyTest {


    public static void main(String[] args) {
        List<String> illnesses = Arrays.asList("p1, mel", "p2,gli", "p3,   ggg");
        Map<String, String> illnessMap =illnesses.stream()
                .map(str -> str.split(", *"))
                .peek(pair -> System.out.println(Arrays.toString(pair)))
                .collect(
                        Collectors.toMap(pair -> pair[0], pair -> pair[1], (val, newVal) -> val));

    }
}
