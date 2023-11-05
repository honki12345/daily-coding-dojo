import java.util.Arrays;
import java.util.Scanner;

public class Prob0206 {
    public static boolean[] isPrime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            String tmp = sc.next();
            tmp = new StringBuffer(tmp).reverse().toString();
            arr[i] = Integer.parseInt(tmp);
        }
        int max = Arrays.stream(arr).max().getAsInt();
        isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        getPrimeNumber(max);

        for (int i : arr) {
            if (isPrime[i])
                System.out.print(i + " ");
        }

    }

    public static void getPrimeNumber(int max) {
        for (int i = 2; i <= max; i++) {
            if (!isPrime[i])
                continue;

            for (int j = i + i; j <= max; j = j + i) {
                if (!isPrime[j])
                    continue;
                isPrime[j] = false;
            }

        }
    }
}
