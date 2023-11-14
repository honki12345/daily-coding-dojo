import java.util.Scanner;

public class Prob0603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    arr[j + 1] = tmp;
                    break;
                }
                if (j == 0) {
                    arr[j] = tmp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
