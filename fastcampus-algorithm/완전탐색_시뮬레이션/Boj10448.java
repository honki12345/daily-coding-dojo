import java.util.Scanner;

public class Boj10448 {
    public static void main(String[] args) {
        int sum = 0;
        int[] triNum = new int[45];
        for (int i = 1; i <= 44; i++) {
            sum += i;
            triNum[i] = sum;
        }

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        start: for (int i = 0; i < count; i++) {
            int K = sc.nextInt();

            for (int j = 1; j <= 44; j++) {
                for (int k = 1; k <= 44; k++) {
                    for (int l = 1; l <= 44; l++) {
                        int tmp = triNum[j] + triNum[k] + triNum[l];
                        if (tmp == K) {
                            System.out.println(1);
                            continue start;
                        }
                    }
                }
            }
            System.out.println(0);
        }
    }

}
