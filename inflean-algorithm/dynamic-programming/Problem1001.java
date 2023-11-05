import java.util.Scanner;

public class Problem1001 {
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        recursive(N);
        System.out.println(count);
    }

    public static void recursive(int stairs) {
        if (stairs < 0)
            return;
        if (stairs == 0)
            count++;

        recursive(stairs - 1);
        recursive(stairs - 2);
    }
}
