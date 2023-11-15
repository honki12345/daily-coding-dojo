import java.util.Scanner;

public class Prob0702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        recursive(N);
    }

    public static void recursive(int n) {
        if (n == 0)
            return;
        recursive(n / 2);
        System.out.print(n % 2);
    }
}
