import java.util.Scanner;

public class 통증2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int B = scanner.nextInt();
        int A = scanner.nextInt();
        int answer = 0;

        if (N % A == 0) {
            answer = N / A;
        } else if (N % A % B == 0) {
            answer += N / A;
            answer += N % A / B;
        } else if ((N % A + A) % B == 0) {
            answer += N / A;
            answer--;
            answer += (N % A + A) / B;

        } else if (N % B == 0) {
            answer = N / B;
        } else {
            answer = -1;
        }

        System.out.println(answer);
    }
}