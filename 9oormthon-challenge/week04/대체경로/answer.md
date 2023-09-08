# 대체경로

## 필요한 개념

- 그래프
- BFS/DFS

## 분석

- 최단 경로를 찾는 문제입니다. 최단 경로를 찾는 문제는 BFS나 DFS 어떤 알고리즘을 채택해도 상관없지만 BFS가 약간 더 효율적입니다  
  이 문제는 최단 경로를 찾을 때, 아래 조건을 확인하면서 경로를 확인하면 됩니다
  - i일에는 i번 도시를 경유할 수 없다

## BFS

- 기존에 배운 방법 그대로 노드와 간선 정보를 처리합니다. 그래프는 객체로 구현할 때 더 효율적이라는 점을 상기하면 됩니다. 우선은 그래프를 아래와 같이 입력을 받습니다

  ```java
  import java.util.*;

  public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, M, S, E;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        String[] firstLine = scanner.nextLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);
        S = Integer.parseInt(firstLine[2]);
        E = Integer.parseInt(firstLine[3]);
        for (int i = 0; i < M; i++) {
            String[] edge = scanner.nextLine().split(" ");
            int s = Integer.parseInt(edge[0]);
            int e = Integer.parseInt(edge[1]);
            graph.putIfAbsent(s, new ArrayList<>());
            graph.putIfAbsent(e, new ArrayList<>());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        System.out.println(graph);
    }
  }
  ```

- 탐색을 구현하기 전에, 고려할 부분은 i일 뒤에 i번 도시로 이동하지 못하는 부분입니다. 이는 단순하고 반복문으로 구현할 수 있습니다

  ```java
  for (int off = 1; off <= N; off++) {
    // S부터 E까지의 최단경로를 탐색
  }
  ```

- 해당 반복문 안에 필요한 탐색을 구현하면 됩니다

  ```java
  for (int off = 1; off <= N; off++) {
    // S부터 E까지의 최단 경로를 탐색
  }
  ```

- 해당 반복문 안에 필요한 탐색을 구현하면 됩니다

  ```java
  for (int off = 1; off <= N; off++) {
    if (off == S || off == E) {
        System.out.println(-1);
    } else {
        int[] visited = new int[N+1];
        // 최단거리를 저장할 배열, 초기값은 큰 수로 설정
        Arrays.fill(visited, (int) 1e8);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        visited[S] = 1;
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            // 범위 오류 확인을 위한 간선이 있는지 확인
            if (graph.containsKey(curNode)) {
                for (int nextNode : graph.get(curNode)) {
                    // nextNode가 off인지 확인
                    if (nextNode != off) {
                        // off가 아니라면 최단 거리인지 확인
                        if (visited[nextNode] > visited[curNode] + 1) {
                            visited[nextNode] = visited[curNode] + 1;
                            queue.add(nextNode);    // 최단거리라면 탐색 후보에 추가
                        }
                        if (nextNode == E) break;
                    }
                }
            }
        }
        //  방문한 적 없으면 -1을 출력, 방문한 적 있다면 최단거리를 출력
        System.out.println(visited[E] == (int) 1e8 ? -1 : visited[E]);
    }
  }
  ```

## Tip

- 해설지를 작성할 때, 조건을 일일이 분리해놓은 이유는 주석을 달아놓기 위함입니다  
  조건을 합쳐도되고, 합친다면 더 간결하고 깔끔합니다

## 정해코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, M, S, E;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        String[] firtLine = scanner.nextLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);
        S = Integer.parseInt(firstLine[2]);
        E = Integer.parseInt(firstLine[3]);
        for (int i = 0; i < M; i++) {
            String[] edge = scanner.nextLine().split(" ");
            int s = Integer.parseInt(edge[0]);
            int e = Integer.parseInt(edge[1]);
            graph.putIfAbsent(s, new ArrayList<>());
            graph.putIfAbsent(e, new ArrayList<>());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        // System.out.println(graph);
        for (int off = 1; off <= N; off++) {
            if (off == S || off == E) {
                System.out.println(-1);
            } else {
                int[] visited = new int[N+1];
                Arrays.fill(visited, (int)1e8);
                Queue<Integer> queue = new LinkedList<>();
                queue.add(S);
                visited[S] = 1;
                while (!queue.isEmpty()) {
                    int curNode = queue.poll();
                    if (graph.containsKey(curNode)) {
                        for (int nextNode : graph.get(curNode)) {
                            if (nextNode != off) {
                                if (visited[nextNode] > visited[curNode] + 1) {
                                    visited[nextNode] = visited[curNode] + 1;
                                    queue.add(nextNode);
                                }
                                if (nextNode == E) break;
                            }
                        }
                    }
                }
                System.out.println(visited[E] == (int) 1e8 ? -1 : visited[E]);
            }
        }
    }
}
```
