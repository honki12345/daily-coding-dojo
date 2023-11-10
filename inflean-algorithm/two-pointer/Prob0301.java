import java.util.Scanner;

public class Prob0301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arrN = new int[N];
        for (int i = 0; i < N; i++) {
            arrN[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] arrM = new int[M];
        for (int i = 0; i < M; i++) {
            arrM[i] = sc.nextInt();
        }

        int i = 0, j = 0, k = 0;
        int valueN = 0, valueM = 0;
        int[] result = new int[N + M];

        while (i < N || j < M) {
            if (i < N) {
                valueN = arrN[i];
            } else {
                valueN = Integer.MAX_VALUE;
            }
            if (j < M) {
                valueM = arrM[j];
            } else {
                valueN = Integer.MAX_VALUE;
            }
            if (valueN > valueM) {
                result[k++] = valueM;
                j++;
            } else {
                result[k++] = valueN;
                i++;
            }
        }

        for (int l : result) {
            System.out.print(l + " ");
        }
    }

}
