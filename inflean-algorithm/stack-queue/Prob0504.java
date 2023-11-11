import java.util.Scanner;
import java.util.Stack;

public class Prob0504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            if ('1' <= c && c <= '9')
                stack.add(c);
            else {
                int n2 = stack.pop() - '0';
                int n1 = stack.pop() - '0';
                if (c == '+') {
                    stack.add((char) (n1 + n2 + '0'));
                } else if (c == '-') {
                    stack.add((char) (n1 - n2 + '0'));
                } else if (c == '*') {
                    stack.add((char) (n1 * n2 + '0'));
                } else if (c == '/') {
                    stack.add((char) (n1 / n2 + '0'));
                }
            }
        }
        System.out.println(stack.pop() - '0');
    }

}
