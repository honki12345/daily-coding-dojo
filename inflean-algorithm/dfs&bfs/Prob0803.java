import java.util.Scanner;

public class Prob0803 {
    static int answer = Integer.MIN_VALUE, n, m;
    static boolean flag = false;

    public static void dfs(int L, int sum, int time, int[] ps, int[] pt) {
        if (time > m)
            return;
        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(L + 1, sum + ps[L], time + pt[L], ps, pt);
            dfs(L + 1, sum, time, ps, pt);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] problemScore = new int[n]; // 점수
        int[] problemTime = new int[n]; // 걸리는 시간
        for (int i = 0; i < n; i++) {
            problemScore[i] = sc.nextInt();
            problemTime[i] = sc.nextInt();
        }
        dfs(0, 0, 0, problemScore, problemTime);
        System.out.println(answer);

    }

}
