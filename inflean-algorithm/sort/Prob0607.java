import java.util.Arrays;
import java.util.Scanner;

public class Prob0607 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Coordinate[] arr = new Coordinate[N];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = new Coordinate(x, y);
        }
        Arrays.sort(arr);
        for (Coordinate coordinate : arr) {
            System.out.println(coordinate);
        }

    }

    static class Coordinate implements Comparable<Coordinate> {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
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

        @Override
        public int compareTo(Prob0607.Coordinate o) {
            int xValue = this.x - o.x;
            if (xValue > 0) {
                return 1;
            } else if (xValue == 0) {
                return this.y - o.y;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

    }

}
