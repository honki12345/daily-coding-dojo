import java.util.Scanner;

public class Prob0306 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int lt = 0, rt = 0;
        int count = K;
        int max = -1;
        int length = 1;

        while (rt < N) {
            while (count >= 0 && rt < N) {
                if (arr[rt] == 1) {
                    rt++;
                } else {
                    if (count == 0) {
                        System.out.println("rt " + rt);
                        break;
                    }
                    rt++;
                    count--;
                }
            }
            length = rt - lt;
            max = Math.max(max, length);
            while (count <= K - 1 && lt < N) {
                if (arr[lt] == 1) {
                    lt++;
                } else {
                    if (count == K - 1) {
                        lt++;
                        count++;
                        System.out.println("lt " + lt);
                        break;
                    } else {
                        lt++;
                        count++;
                    }
                }

            }
            length = rt - lt + 1;
        }

        System.out.println(max);
    }

}
