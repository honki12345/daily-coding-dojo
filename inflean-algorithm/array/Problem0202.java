import java.util.Scanner;

public class Problem0202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = -1;
        int count = 0;

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (input > max) {
                count++;
                max = input;
            }
        }
        System.out.println(count);
    }
}
