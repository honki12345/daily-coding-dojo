import java.util.Arrays;
import java.util.Scanner;

public class Prob0606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] sorted = new int[N];
        for (int i = 0; i < arr.length; i++) {
            int input = sc.nextInt();
            arr[i] = input;
            sorted[i] = input;
        }
        Arrays.sort(sorted);
        for (int i = 0; i < sorted.length; i++) {
            if (arr[i] != sorted[i])
                System.out.print(i + 1 + " ");
        }
    }

}
