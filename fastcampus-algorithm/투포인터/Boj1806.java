/*
 * Two Pointer
 * l1 < l2 의 가장 짧은 구간 [l1:r1], [l2:r2]에서
 * 항상 r1 <= r2 이다. 따라서 left index를 차례로 순회하며
 * 대응하는 right index를 증가하는 방향으로 유지하며
 * 투포인터를 사용할 수 있다
 */

import java.util.Scanner;

public class Boj1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int ansLength = N + 1;
        int rightIndex = 0;
        int currentSum = arr[0];

        for (int i = 0; i < N; i++) {
            while (currentSum < S && rightIndex < N - 1) {
                currentSum += arr[++rightIndex];
            }

            if (currentSum >= S) {
                ansLength = Math.min(ansLength, rightIndex - i + 1);
            }
            currentSum -= arr[i];
        }

        if (ansLength > N)
            ansLength = 0;
        System.out.println(ansLength);
    }

}
