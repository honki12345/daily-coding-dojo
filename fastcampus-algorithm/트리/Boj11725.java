/*
 * 문제의 조건에 의해 1번 노드가 루트노드로 지정되었으므로
 * 1번 노드부터 연결된 노드를 탐색하며 부모를 매핑하자
 * 단, 이미 탐색했던 노드를 재방문해서 사이클이 발생하지 않도록 한다
 *   - check[]를 활용해 특정 노드의 방문 여부를 기록한다
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Boj11725 {
    public static ArrayList<Integer>[] tree;
    public static boolean[] check;
    public static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new ArrayList[N + 1];
        check = new boolean[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i < N; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (tree[n] == null) {
                tree[n] = new ArrayList<>();
            }

            if (tree[m] == null) {
                tree[m] = new ArrayList<>();
            }
            tree[n].add(m);
            tree[m].add(n);
        }

        find(1);

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void find(int node) {
        check[node] = true;

        for (int i = 0; i < tree[node].size(); i++) {
            int child = tree[node].get(i);
            if (check[child]) {
                continue;
            }
            parent[child] = node;
            find(child);
        }
    }
}
