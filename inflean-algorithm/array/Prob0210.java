import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob0210 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N + 2][N + 2];
        boolean[][] isMinor = new boolean[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (isMinor[i][j])
                    continue;
                int value = map[i][j];
                int up = map[i - 1][j];
                int down = map[i + 1][j];
                int left = map[i][j - 1];
                int right = map[i][j + 1];
                boolean isNotMax = IntStream.of(up, down, left, right).anyMatch(n -> n >= value);
                if (!isNotMax) {
                    isMinor[i - 1][j] = true;
                    isMinor[i + 1][j] = true;
                    isMinor[i][j - 1] = true;
                    isMinor[i][j + 1] = true;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

}
