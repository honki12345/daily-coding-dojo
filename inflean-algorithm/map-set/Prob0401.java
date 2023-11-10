import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Prob0401 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        /*
         * 처음에 Map의 Key를 String으로 하여서
         * char 를 다시 String.valueOf(char)를 이용하여 cast 해주어야했는데
         * 처음부터 Map의 Key를 Character로 잡았다면
         * char -> Character 로 jvm 에서 wrapper로 잡아주기 때문에
         * 코드 가독성이 향상된다
         */
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = sc.next().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        /*
         * Map의 entrySet 말고도 entryKey를 활용할 수 있다.
         */
        Entry<Character, Integer> max = map.entrySet().stream()
                .max((entry1, entry2) -> entry1.getValue() - entry2.getValue()).get();
        System.out.println(max.getKey());

    }

}
