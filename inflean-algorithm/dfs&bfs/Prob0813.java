import java.util.Scanner;

public class Prob0813 {
  static int answer = 0, n;
  static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
  static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

  public static void dfs(int x, int y, int[][] board) {
    board[x][y] = 0;
    for (int i = 0; i < 8; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && nx <= n - 1 && ny >= 0 && ny <= n - 1 && board[nx][ny] == 1) {
        dfs(nx, ny, board);
      }
    }
  }

  public static void solution(int[][] board) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 1) {
          answer++;
          dfs(i, j, board);
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    solution(arr);
    System.out.println(answer);

  }

}
