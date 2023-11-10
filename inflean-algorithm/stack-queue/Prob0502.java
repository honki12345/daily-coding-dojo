import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob0502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        boolean isOpen = false;
        int count = 0;
        List<Character> list = new ArrayList<>();
        List<Character> tmp = new ArrayList<>();

        for (char c : arr) {
            if (c == '(') {
                isOpen = true;
                count++;
            } else if (c == ')') {
                if (count > 0)
                    count--;
                if (count == 0) {
                    isOpen = false;
                    tmp.clear();
                }
            } else {
                if (isOpen) {
                    tmp.add(c);
                } else {
                    list.add(c);
                }
            }
        }
        list.addAll(tmp);
        StringBuilder answer = new StringBuilder();
        list.forEach(answer::append);
        System.out.println(answer.toString());
    }

}
