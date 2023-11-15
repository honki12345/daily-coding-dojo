import java.util.LinkedList;
import java.util.Scanner;

public class Prob0604 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int N = sc.nextInt();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (queue.contains(input)) {
                queue.remove(Integer.valueOf(input));
                queue.addFirst(input);
            } else {
                if (queue.size() > S - 1) {
                    queue.pollLast();
                }
                queue.addFirst(input);
            }
        }
        for (Integer integer : queue) {
            System.out.print(integer + " ");
        }
    }

}
