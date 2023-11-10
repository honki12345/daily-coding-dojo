import java.util.Scanner;

public class Prob0304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        int sum = arr[0];
        int i = 0, j = 0;
        while (true) {
            if (sum > M) {
                if (i == j) {
                    if (++j >= N)
                        break;
                    sum -= arr[i++];
                    sum += arr[j];
                } else {
                    sum -= arr[i++];
                }
            } else if (sum == M) {
                count++;
                if (++j >= N)
                    break;
                sum -= arr[i++];
                sum += arr[j];
            } else {
                if (++j >= N)
                    break;
                sum += arr[j];
            }
        }
        System.out.println(count);
    }

}
