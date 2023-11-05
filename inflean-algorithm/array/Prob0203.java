import java.util.Scanner;

public class Prob0203 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arrayA = new int[N];
        int[] arrayB = new int[N];

        for (int i = 0; i < N; i++) {
            arrayA[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            arrayB[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            calcul(arrayA[i], arrayB[i]);
        }

    }

    public static void calcul(int a, int b) {
        if (a == b) {
            System.out.println("D");
        }
        if (a == 1) {
            if (b == 2)
                System.out.println("B");
            if (b == 3)
                System.out.println("A");
        }
        if (a == 2) {
            if (b == 1)
                System.out.println("A");
            if (b == 3)
                System.out.println("B");
        }
        if (a == 3) {
            if (b == 2)
                System.out.println("A");
            if (b == 1)
                System.out.println("B");
        }
    }
}
