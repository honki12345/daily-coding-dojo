import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Boj7785 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String name = input.split(" ")[0];
            String command = input.split(" ")[1];
            if (!map.containsKey(name)) {
                map.put(name, null);
            } else {
                if (command.equals("leave")) {
                    map.remove(name);
                }
            }
        }

        List<String> list = new LinkedList<>();
        map.keySet().stream().forEach(name -> list.add(name));
        list.sort(Collections.reverseOrder());
        for (String str : list) {
            System.out.println(str);
        }
    }

}
