import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prob0404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] S = sc.nextLine().toCharArray();
        char[] T = sc.nextLine().toCharArray();
        Map<Character, Integer> answer = new HashMap<>();
        for (char c : T) {
            answer.put(c, answer.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> tmp = new HashMap<>();
        for (int i = 0; i < T.length; i++) {
            tmp.put(S[i], tmp.getOrDefault(S[i], 0) + 1);
        }
        int count = 0;
        if (tmp.equals(answer))
            count++;
        int lt = 0, rt = T.length;

        while (rt < S.length) {
            tmp.put(S[rt], tmp.getOrDefault(S[rt], 0) + 1);
            tmp.put(S[lt], tmp.getOrDefault(S[lt], 0) - 1);
            if (tmp.get(S[lt]) <= 0) {
                tmp.remove(S[lt]);
            }
            if (tmp.equals(answer))
                count++;
            rt++;
            lt++;
        }
        System.out.println(count);
    }
}
