import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Prob0211 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] students = new int[N + 1][6];
        boolean[][] result = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 5; j++) {
                students[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = j + 1; k <= N; k++) {
                    if (students[j][i] == students[k][i]) {
                        result[j][k] = true;
                        result[k][j] = true;
                    }
                }
            }
        }

        List<Integer> collect = Arrays.stream(result).map(booleans -> {
            Integer count = 0;
            for (boolean b : booleans) {
                if (b)
                    count++;
            }
            return count;
        }).collect(Collectors.toList());

        Integer max = collect.stream().max(Integer::compareTo).get();
        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i) == max) {
                System.out.println(i);
                break;
            }
        }
        for (Integer integer : collect) {
            System.out.println(integer);
        }

    }
}
