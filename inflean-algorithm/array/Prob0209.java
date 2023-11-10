import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob0209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] horizontal = new int[N];
        int[] vertical = new int[N];
        int[] diagonal = new int[2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int input = sc.nextInt();
                horizontal[i] += input;
                vertical[j] += input;
                if (i == j)
                    diagonal[0] += input;
                if ((N - 1 - i) == j)
                    diagonal[1] += input;
            }
        }

        IntStream intStream = IntStream.concat(IntStream.of(vertical), IntStream.of(horizontal));
        IntStream result = IntStream.concat(intStream, IntStream.of(diagonal));
        System.out.println(result.max().getAsInt());

    }

}
