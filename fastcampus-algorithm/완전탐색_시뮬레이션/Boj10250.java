import java.util.Scanner;

public class Boj10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int h = N % H == 0 ? H : N % H;
            // int w = N / H + 1;
            int w = N % H == 0 ? N / H : N / H + 1;
            String result = String.format("%d%02d", h, w);
            System.out.println(result);

        }
    }
}
