import java.util.Arrays;
import java.util.Scanner;

public class Prob0608 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        int answer = -1;
        while (start <= end) {
            int pos = (start + end) / 2;
            int value = arr[pos];
            if (value > M) {
                end = pos - 1;
            } else if (value == M) {
                answer = pos + 1;
                break;
            } else {
                start = pos + 1;
            }
        }
        System.out.println(answer);
    }

}
