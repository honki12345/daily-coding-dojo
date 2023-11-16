import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj11724 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] graph = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int src = sc.nextInt();
            int dst = sc.nextInt();
            graph[src][dst] = 1;
            graph[dst][src] = 1;
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            if (!visited[i]) {
                answer++;
                queue.add(i);
                visited[i] = true;
            }

            while (!queue.isEmpty()) {
                int out = queue.poll();
                for (int j = 1; j <= N; j++) {
                    if (graph[out][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
        }
        System.out.println(answer);
    }

}
