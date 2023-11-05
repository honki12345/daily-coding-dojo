import java.util.Scanner;

public class Prob0207 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (input == 1) {
                count++;
            } else {
                count = 0;
            }
            result += count;
        }
        System.out.println(result);
    }

}
