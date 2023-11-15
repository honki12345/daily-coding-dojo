import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class Prob0507 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] essential = sc.nextLine().toCharArray();
        char[] plan = sc.nextLine().toCharArray();
        LinkedList<Character> essentialQueue = new LinkedList<>();
        for (char ch : essential) {
            essentialQueue.add(ch);
        }
        LinkedList<Character> planQueue = new LinkedList<>();
        for (char ch : plan) {
            planQueue.add(ch);
        }
        /*
         * 풀이에서는 plan 의 각 글자가 essential의 값인데
         * 그 값이 poll() 되지 않으면 이란 조건을 적극 활용했다
         * 즉 문제사항에서 특수 규칙을 찾아 적용한 것
         */
        Character out = essentialQueue.poll();
        for (Character character : planQueue) {
            if (character.equals(out)) {
                if (essentialQueue.size() > 0) {
                    out = essentialQueue.poll();
                } else {
                    out = null;
                }
            }
        }
        if (Objects.isNull(out)) {
        } else {
            System.out.println("NO");
        }
    }

}
