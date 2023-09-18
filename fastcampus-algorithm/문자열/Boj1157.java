import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Boj1157 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String inputUpperCase = input.toUpperCase();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < inputUpperCase.length(); i++) {
            char ch = inputUpperCase.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        scanner.close();
    }
}
