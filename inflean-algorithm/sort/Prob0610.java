import java.util.Arrays;
import java.util.Scanner;

public class Prob0610 {
    public static int C;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        C = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int answer = Integer.MIN_VALUE;
        int lt = 1;
        int rt = arr[arr.length - 1] - arr[0];
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (verify(mid)) {
                answer = Math.max(answer, mid);
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean verify(int value) {
        /*
         * int 변수 index와, sum을 사용한 것을 간략하게
         * int cnt = 1;
         * int ep = arr[0];
         * for (int i = 1; i < arr.length; i++) {
         * if (arr[i] - ep >= dist) {
         * cnt++;
         * ep = arr[i];
         * }
         * }
         */
        int index = 0;
        int count = 1;
        int sum = 0;
        while (count < C && index + 1 < arr.length) {
            sum += arr[index + 1] - arr[index];
            if (sum >= value) {
                count++;
                sum = 0;
                index++;
            } else {
                index++;
            }
        }

        if (count < C) {
            return false;
        } else
            return true;
    }

}
