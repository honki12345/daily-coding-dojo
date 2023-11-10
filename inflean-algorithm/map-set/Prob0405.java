import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prob0405 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int j2 = j + 1; j2 < arr.length; j2++) {
                    int sum = arr[i] + arr[j] + arr[j2];
                    set.add(sum);
                    if (set.size() > K) {
                        int min = set.stream().min(Integer::compareTo).get();
                        set.remove(Integer.valueOf(min));
                    }
                }
            }
        }

        int answer;
        if (set.size() < K)
            answer = -1;
        else
            answer = set.stream().sorted(Collections.reverseOrder()).skip(K - 1).findFirst().get();
        System.out.println(answer);
    }

}
