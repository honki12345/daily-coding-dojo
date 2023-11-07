import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prob0402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        char[] word1 = sc.nextLine().toCharArray();
        /*
         * flag로 true/false를 이용하는게 아니라
         * String answer = "YES" 로 대입해놓고
         * 결과에 따라 answer 변수 value를 변경하는 식으로
         * 좀더 코드를 간편화할 수 있다
         */
        // boolean isAnagram = true;
        String isAnagram = "YES";
        for (char c : word1) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char[] word2 = sc.nextLine().toCharArray();
        for (char c : word2) {
            if (!map.containsKey(c) || map.get(c) <= 0) {
                isAnagram = "NO";
                break;
            }
            map.put(c, map.get(c) - 1);
        }

        System.out.println(isAnagram);

    }
}
