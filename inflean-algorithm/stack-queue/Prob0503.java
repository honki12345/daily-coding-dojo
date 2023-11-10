import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Prob0503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        LinkedList<Integer>[] lists = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            lists[i] = new LinkedList<>();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int tmp = sc.nextInt();
                if (tmp != 0) {
                    lists[j].addFirst(tmp);
                }
            }
        }

        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int tmp = sc.nextInt() - 1;
            if (lists[tmp].size() > 0) {
                int out = lists[tmp].pollLast();
                if (stack.empty()) {
                    stack.add(out);
                } else if (stack.peek() == out) {
                    answer += 2;
                    stack.pop();
                } else {
                    stack.add(out);
                }

            }
        }
        System.out.println(answer);
    }

}
