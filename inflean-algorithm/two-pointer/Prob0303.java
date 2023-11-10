import java.util.Scanner;

public class Prob0303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int result = 0;
        int sum = 0;
        for (int i = 0; i < arr.length - K; i++) {
            if (i == 0) {
                for (int j = i; j < K; j++) {
                    sum += arr[j];
                }
            } else {
                sum -= arr[i - 1];
                sum += arr[i + K - 1];
            }

            result = Math.max(sum, result);
        }

        System.out.println(result);
    }

}
