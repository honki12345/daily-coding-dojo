import java.util.Arrays;
import java.util.Scanner;

public class Prob0809 {
    static int[] combi;
    static int n, m;

    public static void dfs(int l, int s) {
        if (l == m) {
            System.out.println(Arrays.toString(combi));
            return;
        }
        for (int i = s; i <= n; i++) {
            combi[l] = i;
            dfs(l + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];
        dfs(0, 1);
    }
}
