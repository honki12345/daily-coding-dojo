import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class 폭탄_구현하기_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        Location[][] square = new Location[N][N];
        int[] width = new int[]{0, 0, 1, -1, 0};
        int[] length = new int[]{1, -1, 0, 0, 0};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String status = scanner.next();
                square[i][j] = Location.of(status);
            }
        }

        for (int i = 0; i < K; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            Location current = square[x][y];

            if (0<= x && x < N && 0 <= y && y < N) {
                for (int j = 0; j < width.length; j++) {
                    int addX = x + width[j];
                    int addY = y + length[j];

                    if (addX < 0 || addX >= N || addY < 0 || addY >= N) {
                        continue;
                    }
                    Location target = square[addX][addY];
                    String targetStatus = target.getStatus();
                    
                    if (targetStatus.equals("0")) {
                        target.increaseCountOne();
                    } else if (targetStatus.equals("@")) {
                        target.increaseCountTwo();
                    }
                }
                
            }
        }

        Location answer = Arrays.stream(square).flatMap(Arrays::stream).max(new Comparator<Location>() {

            @Override
            public int compare(폭탄_구현하기_2.Location o1, 폭탄_구현하기_2.Location o2) {
                int count1 = o1.getCount();
                int count2 = o2.getCount();
                return count1 - count2;
            }
            
        }).get();

        System.out.println(answer.getCount());

        scanner.close();
    }
    
    static class Location {
        private String status;
        private int count;

        private Location(String status) {
            this.status = status;
            this.count = 0;
        }

        public static Location of(String status) {
            return new Location(status);
        }

        public String getStatus() {
            return status;
        }

        

        public void setCount(int count) {
            this.count = count;
        }

        public void increaseCountOne() {
            this.count++;
        }

        public void increaseCountTwo() {
            this.count += 2;
        }

        public int getCount() {
            return count;
        }
    }

}
