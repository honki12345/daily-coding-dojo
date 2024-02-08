import java.util.Arrays;
import java.util.Scanner;

public class Prob0806 {
  static int n;
  static int m;
  static int[] numbers;
  static boolean[] check;
  static int[] arr;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    numbers = new int[n];
    check = new boolean[n];
    arr = new int[m];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = sc.nextInt();
    }

    dfs(0);

  }

  public static void dfs(int level) {
    if (level == m) {
      System.out.println(Arrays.toString(arr));
      return;
    }

    for (int i = 0; i < numbers.length; i++) {
      if (!check[i]) {
        check[i] = true;
        arr[level] = numbers[i];
        dfs(level + 1);
        check[i] = false;
      }
    }
  }

}
