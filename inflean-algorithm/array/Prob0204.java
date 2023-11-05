import java.util.Scanner;

public class Prob0204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dy = new int[N + 1];
        dy[1] = 1;
        print(dy[1]);
        dy[2] = 1;
        print(dy[2]);

        for (int i = 3; i <= N; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
            print(dy[i]);
        }
    }

    public static void print(int n) {
        System.out.print(n + " ");
    }
}
