import java.util.Scanner;

public class Prob0703 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(recursive(N));
    }

    public static int recursive(int n) {
        if (n == 0)
            return 1;
        return n * recursive(n - 1);
    }

}
