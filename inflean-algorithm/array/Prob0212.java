import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob0212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] scores = new int[M][N];
        List<Integer>[] scoresCheck = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            scoresCheck[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                scores[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int value = scores[i][j];
                List<Integer> arrayList = new ArrayList<>();
                for (int k = j + 1; k < N; k++) {
                    arrayList.add(scores[i][k]);
                }

                if (i == 0)
                    scoresCheck[value] = arrayList;
                else
                    scoresCheck[value].retainAll(arrayList);
            }
        }

        int answer = 0;
        for (List<Integer> list : scoresCheck) {
            answer += list.size();
        }

        System.out.println(answer);
    }

}
