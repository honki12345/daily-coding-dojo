import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Boj15654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        boolean[] check = new boolean[N];

        Stack<Integer> stack = new Stack<>();

        recursive(0, M, check, arr, stack);

    }

    public static void recursive(int depth, int M, boolean[] check, int[] arr, Stack<Integer> stack) {
        if (depth == M) {
            for (Integer integer : stack) {
                System.out.print(integer + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!check[i]) {
                check[i] = true;
                stack.add(arr[i]);
                recursive(depth + 1, M, check, arr, stack);
                check[i] = false;
                stack.pop();
            }
        }
    }
}
