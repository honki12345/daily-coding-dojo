import java.util.Scanner;

public class Prob0305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int length = N / 2 + 1;
        int answer = 0;
        int sum = 1;
        int i = 1;
        for (int j = 2; j <= length; j++) {
            sum += j;
            if (sum == N) {
                answer++;

            }
            while (sum > N) {
                sum -= i++;
                if (sum == N)
                    answer++;
            }
        }
        System.out.println(answer);
    }

}
