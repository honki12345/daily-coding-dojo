import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Prob0805 {
  static int n, m, answer = Integer.MAX_VALUE;

  public static void dfs(int level, int sum, int[] arr) {
    if (sum > m)
      return;
    if (level >= answer)
      return;
    if (sum == m) {
      answer = Math.min(answer, level);
    } else {
      for (int i = 0; i < n; i++) {
        dfs(level + 1, sum + arr[i]);
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    m = sc.nextInt();
    dfs(0, 0, arr);
    System.out.println(answer);
  }
}