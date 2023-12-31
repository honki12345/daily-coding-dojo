import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Queue 자료구조를 사용하면 쉽게 풀 수 있는 문제인데
 * queue 자료구조를 떠올리지 못했다
 */
public class Prob0506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        int count = 1;
        int index = 0;
        while (list.size() > 1) {
            if (count % K == 0) {
                index = index % list.size();
                list.remove(index % list.size());
                count = 1;
            } else {
                index++;
                count++;
            }
        }
        System.out.println(list.get(0));
    }

}
