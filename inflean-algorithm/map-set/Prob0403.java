import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prob0403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(sc.nextInt());
            if (i >= K - 1) {
                System.out.print(set.size() + " ");
            }
        }
    }

}
