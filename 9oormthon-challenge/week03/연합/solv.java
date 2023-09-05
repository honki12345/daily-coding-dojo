import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class solv {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int i = 0; i < M; i++) {
			int s = scanner.nextInt();
			int e = scanner.nextInt();

			graph.putIfAbsent(s, new ArrayList<>());
			graph.get(s).add(e);
		}

		int[] visited = new int[N + 1];
		int count = 1;

		for (int i = 1; i <= N; i++) {
			if (visited[i] == 0) {
				Queue<Integer> q = new LinkedList<>();
				q.add(i);

				while (!q.isEmpty()) {
					int currentNode = q.poll();
					visited[currentNode] = 1;
					if (graph.containsKey(currentNode)) {
						List list = graph.get(currentNode);
						for (int nextNode : list) {
							if (graph.containsKey(nextNode)) {
								if (graph.get(nextNode).contains(currentNode) && visited[nextNode] == 0) {
									q.add(nextNode);
								}
							}
						}
					}
				}
				count++;
			}
		}
		System.out.println(count - 1);
	}
}
