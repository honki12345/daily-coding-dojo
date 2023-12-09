import java.util.Scanner;

public class Prob0802 {
    static int N;
    static int C;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        N = sc.nextInt();
        max = -1;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0, 0, arr);
        System.out.println(max);
    }

    public static void dfs(int level, int sum, int[] arr) {
        if (sum >= C) {
            return;
        }
        if (level == N) {
            max = (sum > max) ? sum : max;
            return;
        } else {
            dfs(level + 1, sum + arr[level], arr);
            dfs(level + 1, sum, arr);
        }
    }

}
