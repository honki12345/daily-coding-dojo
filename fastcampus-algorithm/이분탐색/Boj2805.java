import java.util.Arrays;
import java.util.Scanner;

public class Boj2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M = sc.nextLong();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // int start = Arrays.stream(arr).min().getAsInt();
        int start = 0;
        int end = Arrays.stream(arr).max().getAsInt();
        long answer = 0L;

        while (start <= end) {
            int mid = (start + end) / 2;
            long result = getHeightOfTree(arr, mid);
            if (result >= M) {
                answer = mid > answer ? mid : answer;
                start = mid + 1;

            } else if (result < M) {
                end = mid - 1;
            }

        }

        System.out.println(answer);

    }

    public static long getHeightOfTree(int[] arr, int mid) {
        long sum = 0;

        for (int n : arr) {
            if (n > mid)
                sum += n - mid;
        }

        return sum;
    }
}
