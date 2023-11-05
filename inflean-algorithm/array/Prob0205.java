import java.util.Scanner;

public class Prob0205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] store = new boolean[N + 1];
        store[0] = true;
        store[1] = true;

        for (int i = 2; i <= N; i++) {
            if (store[i])
                continue;

            for (int j = i + i; j <= N; j = j + i) {
                if (store[j])
                    continue;
                if (j % i == 0)
                    store[j] = true;
            }
        }

        int result = 0;
        for (boolean b : store) {
            if (!b)
                result++;
        }
        System.out.println(result);
    }
}
