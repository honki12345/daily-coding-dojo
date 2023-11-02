import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Boj14267 {
    public static Map<Integer, ArrayList<Integer>> compliments;
    public static List<Integer>[] tree;
    public static boolean[] visited;
    public static int[] results;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        results = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int boss = sc.nextInt();
            if (boss != -1) {
                if (tree[i] == null) {
                    tree[i] = new ArrayList<>();
                }

                if (tree[boss] == null) {
                    tree[boss] = new ArrayList<>();
                }
                tree[i].add(boss);
                tree[boss].add(i);
            }
        }

        compliments = new HashMap<>();
        for (int j = 0; j < m; j++) {
            int i = sc.nextInt();
            int w = sc.nextInt();
            compliments.computeIfPresent(i, (k, v) -> {
                v.add(w);
                return v;
            });
            compliments.computeIfAbsent(i, k -> {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(w);
                return arrayList;
            });
        }

        recursive(1, 0);

        results[0] = 0;
        for (int i = 1; i < results.length; i++) {
            System.out.print(results[i] + " ");
        }
        sc.close();
    }

    public static void recursive(int node, int compliementValue) {
        visited[node] = true;
        if (compliments.containsKey(node)) {
            for (int value : compliments.get(node)) {
                compliementValue += value;
            }
        }

        for (int childNode : tree[node]) {
            if (!visited[childNode]) {
                recursive(childNode, compliementValue);
            }
        }
        results[node] = compliementValue;
    }

}
