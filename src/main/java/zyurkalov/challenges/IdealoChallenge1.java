package zyurkalov.challenges;

import java.util.HashMap;
import java.util.Map;

// find the shortest unique sequence

public class IdealoChallenge1 {

    public int solution(String S) {
        Map<String, Integer> counter = new HashMap<>();
        for (int len = 1; len < S.length() + 1; len++) {
            for (int i = 0; i < S.length() - len + 1; i++) {
                String substring = S.substring(i, i + len);
                counter.merge(substring, 1, (oldValue, newValue) -> oldValue + 1);
            }

            for (String key:counter.keySet()) {
                if (counter.get(key) == 1)
                    return key.length();
            }
        }
        return 1;

    }

    public static void main(String[] args) {
        IdealoChallenge1 idealoChallenge1 = new IdealoChallenge1();
        System.out.println(idealoChallenge1.solution("abaaba"));
    }
}
/*

abaaba


 */
