package zyurkalov;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;


class Result {

    /*
     * Complete the 'solution' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY illnesses
     *  2. STRING_ARRAY drugs
     *  3. STRING_ARRAY cohorts
     */

    public static List<String> solution(List<String> illnesses, List<String> drugs, List<String> cohorts) {
        Map<String, Set<String>> illnessToUsersMap = toHashMap(illnesses);
        Map<String, Set<String>> drugToUsersMap = toHashMap(drugs);
        List<String> allPatients = getAllPatients(illnessToUsersMap, drugToUsersMap);
        ArrayList<String> result = new ArrayList<>();
        for (String cohortList : cohorts) {
            String[] cohortElements = cohortList.split(", *");
            Set<String> patients = new HashSet<>(allPatients);
            for (String cohortElement : cohortElements) {
                patients.removeIf(
                        patient ->
                                !illnessToUsersMap.get(cohortElement).contains(patient) &&
                                !drugToUsersMap.get(cohortElement).contains(patient));
            }
            result.add(String.join(",", patients));
        }
        return result;
    }

    private static List<String> getAllPatients(Map<String, Set<String>> illnessToUsersMap, Map<String, Set<String>> drugToUsersMap) {
        return Stream.concat(
                illnessToUsersMap.values().stream(),
                drugToUsersMap.values().stream()
        ).flatMap(Collection::stream)
        .distinct().collect(toList());
    }


    private static Map<String, Set<String>> toHashMap(List<String> illnesses) {
        var result = new HashMap<String, Set<String>>();
        for (String illness : illnesses) {
            String[] keyValue = illness.split(". *");
            String key = keyValue[0];
            String value = keyValue[1];
            result.putIfAbsent(key, new HashSet<>());
            result.get(key).add(value);
        }
        return result;
    }

}
public class CohortSelection {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int illnessesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> illnesses = IntStream.range(0, illnessesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int drugsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> drugs = IntStream.range(0, drugsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int cohortsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> cohorts = IntStream.range(0, cohortsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.solution(illnesses, drugs, cohorts);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
