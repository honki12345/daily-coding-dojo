import java.util.Scanner;

public class Prob0501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        int count = 0;
        String answer = "YES";
        for (char c : arr) {
            if (c == '(')
                count++;
            else if (c == ')')
                count--;
            if (count < 0) {
                answer = "NO";
                break;
            }
        }
        if (count > 0)
            answer = "NO";
        System.out.println(answer);
    }

}
