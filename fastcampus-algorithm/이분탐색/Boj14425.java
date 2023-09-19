import java.util.Arrays;
import java.util.Scanner;

public class Boj14425 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        String[] S = new String[N];

        for (int i = 0; i < N; i++) {
            S[i] = sc.nextLine();
        }
        Arrays.sort(S);
        int sum = 0;
        for (int i = 0; i < M; i++) {
            String input = sc.nextLine();
            int result = Arrays.binarySearch(S, input);
            if (result >= 0) {
                sum++;
            }
        }
        System.out.println(sum);

        sc.close();
    }
}
