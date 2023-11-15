import java.util.Scanner;

public class Prob0704 {
    public static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        memo = new int[N + 1];
        memo[1] = 1;
        memo[2] = 1;
        recursive(N);

        for (int i = 1; i <= N; i++) {
            System.out.print(memo[i] + " ");
        }
    }

    public static int recursive(int n) {
        /*
         * if (memo[n] != 0) return memo[n];
         * if (n == 1 || n == 2) return memo[n] = 1;
         * else return memo[n] = recursive(n - 1) + recursive(n - 2);
         */
        if (memo[n] == 0) {
            return memo[n] = recursive(n - 1) + recursive(n - 2);
        } else {
            return memo[n];
        }
    }

}
