import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연결_요소_제거하기 {
    public static void main(String[] args) {
        /*
         * 1. 대문자 di를 배치시킨다
         * 2. 배치시킨 위치를 기준으로 BFS를 통해 연결요소 크기가 K개 이상인지 확인한다
         * 3. K개 이상이면 . 으로 모두 수정한다
         */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[][] square = new String[N + 1][N + 1];
        int K = scanner.nextInt();
        int Q = scanner.nextInt();
        int[] directionX = { 0, 0, 1, -1 };
        int[] directionY = { 1, -1, 0, 0 };

        for (int i = 1; i <= N; i++) {
            String input = scanner.next();
            for (int j = 1; j <= N; j++) {
                square[i][j] = input.substring(j - 1, j);
            }
        }

        scanner.nextLine();

        Queue<Location> store = new LinkedList<>();
        for (int k = 0; k < Q; k++) {
            String input = scanner.nextLine();
            String[] inputSplitByWhitespace = input.split(" ");
            int x = Integer.parseInt(inputSplitByWhitespace[0]);
            int y = Integer.parseInt(inputSplitByWhitespace[1]);
            String ch = inputSplitByWhitespace[2];
            boolean[][] visited = new boolean[N + 1][N + 1];

            square[x][y] = ch;
            Location location = new Location(x, y);
            visited[x][y] = true;
            Queue<Location> q = new LinkedList<>();
            q.add(location);
            store.add(location);
            int count = 1;

            while (!q.isEmpty()) {
                Location current = q.poll();

                for (int i = 0; i < 4; i++) {
                    int dx = current.getX() + directionX[i];
                    int dy = current.getY() + directionY[i];
                    if (1 <= dx && dx <= N && 1 <= dy && dy <= N
                            && square[dx][dy].equals(ch) && !visited[dx][dy]) {
                        count++;
                        Location next = new Location(dx, dy);
                        q.add(next);
                        store.add(next);
                        visited[dx][dy] = true;
                    }
                }
            }

            if (count >= K) {
                while (!store.isEmpty()) {
                    Location getOne = store.poll();
                    int xOfGetOne = getOne.getX();
                    int yOfGetOne = getOne.getY();
                    square[xOfGetOne][yOfGetOne] = ".";
                }

            }

            store.clear();
        }

        for (int m = 1; m <= N; m++) {
            for (int n = 1; n <= N; n++) {
                System.out.print(square[m][n]);
            }
            System.out.println();
        }

        scanner.close();
    }
}

class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}