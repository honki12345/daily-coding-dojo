import java.util.Arrays;
import java.util.Scanner;

public class 구름_찾기_깃발 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int flagForFind = scanner.nextInt();
        int[][] square = new int[N][N];
        int[] width = new int[]{-1, 0, 1};
        int[] length = new int[]{-1, 0, 1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int input = scanner.nextInt();
                if (input == 1) {
                    square[i][j] = -1;
                } else {
                    square[i][j] = input;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (square[i][j] == -1) {
                    for (int j2 = 0; j2 < 3; j2++) {
                        for (int k = 0; k < 3; k++) {
                            if (width[j2] == 0 && length[k] ==0) {
                                continue;
                            }

                            int addI = i + width[j2];
                            int addJ = j + length[k];
                            if (0 <= addI && addI < N
                                && 0 <= addJ && addJ < N
                            ) {
                                if (square[addI][addJ] != -1) {
                                    square[addI][addJ]++;
                                }
                            }
                        }
                    }

                }
            }
            
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (square[i][j] == flagForFind) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
    
}
