import java.io.*;
import java.util.*;

public class GameJam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        CountAndCommand[][] map = new CountAndCommand[N][N];

        int goormX = scanner.nextInt() - 1;
        int goormY = scanner.nextInt() - 1;
        Player goorm = new Player("goorm", goormX, goormY, N);
        
        int playerX = scanner.nextInt() - 1;
        int playerY = scanner.nextInt() - 1;
        Player player = new Player("player", playerX, playerY, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String input = scanner.next();
                int count = Integer.parseInt(input.substring(0, input.length() - 1));
                String command = input.substring(input.length() - 1);
                map[i][j] = new CountAndCommand(count, command);
            }
        }

        gameStart(map, player);
        gameStart(map, goorm);
        
        Player winner = goorm.getSum() > player.getSum() ? goorm : player;
        System.out.println(winner.getName() + " " + winner.getSum());
        
    }

    public static void gameStart(CountAndCommand[][] map, Player player) {
        while (!player.isPassed()) {
            player.setChecked();
            // 플레이어가 왔던 장소인가?
            // false -> 반복이동 
            // (sum += count), (위치 이동)
            int x = player.getX();
            int y = player.getY();
            CountAndCommand cac = map[x][y];
            player.move(cac.getCommand(), cac.getCount());
            if (!player.isPassed()) {
                player.increaseSum(cac.getCount());
            } else {
                player.increaseSum(cac.getCount() - 1);
            }
        }

    }
}

class Player {
    private int x;
    private int y;
    private int[][] square;
    private int size;
    private String name;
    private int sum;

    public Player(String name, int x, int y, int size) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.size = size;
        this.square = new int[size][size];
        this.sum = 1;
    }

    public void pass(int x, int y) {
        square[x][y] = 1;
    }

    public boolean isPassed() {
        if (this.square[this.x][this.y] == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void move(String command, int count) {
        if (command.equals("U")) {
            int tmp = this.x - count;
            tmp += 2 * this.size;
            tmp %= size;
            this.x = tmp;
        } else if (command.equals("D")) {
            int tmp = this.x + count;
            tmp %= size;
            this.x = tmp;
        } else if (command.equals("R")) {
            int tmp = this.y + count;
            tmp %= size;
            this.y = tmp;
        } else if (command.equals("L")) {
            int tmp = this.y - count;
            tmp += 2 * this.size;
            tmp %= size;
            this.y = tmp;
        }
    }

    public void setChecked() {
        this.square[this.x][this.y] = 1;
    }

    public void increaseSum(int dsum) {
        this.sum += dsum;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }
}

class CountAndCommand {
    private int count;
    private String command;

    public CountAndCommand(int count, String command) {
        this.count = count;
        this.command = command;
    }

    public int getCount() {
        return count;
    }

    public String getCommand() {
        return command;
    }
}