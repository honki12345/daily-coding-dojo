# 연합

## 분석

- 연합 문제는 그래프에서 조건에 맞는 연합을 찾고, 연합의 개수를 세는 문제입니다. BFS의 개념을 잘 이해하고 있다면, 어렵지 않게 문제를 해결할 수 있습니다.

## 문제풀이

- 문제를 해결하기 위해서는 DFS와 BFS 어떤 방법으로도 해결할 수 있지만, 결과적으로 모든 섬을 방문해야 하기 때문에 BFS로 문제를 해결할 수 있습니다
  연합의 조건은 다음과 같습니다
  - A섬과 B섬이 있을 때 서로 이동할 수 있으면 연합이 될 수 있다
  - 연합 안에서 어떤 섬에서 출발해도, 연합의 모든 섬에 방문할 수 있어야한다
  - 모든 섬은 하나의 연합에 속해있다
    위의 조건으로 만들어진 연합에 어떤 섬이 포함되어 있는지 알 수 있다면, 가장 마지막에 만들어진 연합의 번호가 곧 연합의 개수가 됩니다

## 그래프 구현

- 그래프 기초 문제에서 자바로 그래프를 구현하는 방법을 배웠습니다. 자바에서 그래프는 `HashMap`을 이용해서 구현합니다

  - `graph.putIfAbsent(s, new ArrayList<>());`
    만약에 graph에 `s`라는 키가 없으면 `graph[s]`에 `new ArrayList<>()`를 할당합니다.

  ```java
  import java.util.*;

  public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, M;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        String[] firstLine = scanner.nextLine().split(" ");
        N = scanner.nextInt();
        M = scanner.nextInt();
        for (int i = 0; i < M; i++) {
            String[] edge = scanner.nextLine().split(" ");
            int s = Integer.parseInt(edge[0]);
            int e = Integer.parseInt(edge[1]);
            graph.putIfAbsent(s, new ArrayList<>());
            graph.get(s).add(e);
        }
        System.out.println(graph);
    }
  }
  ```

## 연합의 개수

- 연합의 개수를 세기 위해서 `visited` 변수를 활용할 수 있습니다. `visited`는 섬의 방문 여부와 함께 어떤 연합에 속해져있는지 확인할 수 있습니다. 아래와 같이 연합을 관리합니다

  - `int[] visited = new int[N + 1];` `visited` 변수를 선언한다
    1. `visited[Node]`의 값이 `0`이면 그 섬은 어떤 연합에도 포함되지 않는 섬이다
    2. 연합에 속하지 않는 섬에서, 새로운 연합을 만들었을 때 이를 i번 연합이라고 한다
    3. i번 연합에 속한 섬들을 `visited[Node] = i`로 갱신한다
  - `count`는 소속 연합의 번호를 관리한다
  - `if (graph.get(nextNode).contains(currentNode) && visited[nextNode] == 0)`  
    graph의 한 노드에는 `ArrayList`가 포함되어 있습니다. 내가 방문할 노드에 currentNode가 포함되어 있는지 확인해야합니다.

  ```java
  // count = 연합의 번호
  // visited = 방문기록 & 연합기록확인
  int[] visited = new int[N + 1];
  int count = 1;

  for (int i = 1; i <= N; i++) {
    if (visited[i] == 0) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        // 탐색 후보가 비워질 때까지 탐색합니다
        while (!q.isEmpty) {
            // BFS로 구현합니다
            int currentNode = q.poll();
            // 현재 방문한 노드의 연합번호를 할당합니다
            visited[currentNode] = count;
            // Java의 경우에는 graph에 탐색하려는 key 값이 있는지 확인해야합니다
            if (graph.containsKey(currentNode)) {
                for (int nextNode : graph.get(currentNode)) {
                    if (graph.containsKey(nextNode)) {
                        // nextNode 에서 currentNode 로 올 수 있는지도 확인 && 연합 소속여부확인
                        if (graph.get(nextNode).contains(currentNode) && visited[nextNode] == 0) {
                            q.add(nextNode);
                        }
                    }
                }
            }
        }
        // 한 노드에서 갈 수 있는 모든 연합을 구하면, 연합의 번호를 올립니다.
        count++;
    }
  }
  ```

  위와 같은 논리로 작성하게 되면 Timeout이 발생합니다. 논리적으로 틀리즈 않았지만 최적화해야합니다.

## Timeout 해결하기

- `graph.get(nextNode).contains(currentNode)`는 `graph[nextNode]`에서 `currentNode`의 존재 여부를 찾는 시간은 항상 `graph.get(nextNode)`의 길이만큼 시간이 걸립니다. 이 탐색시간이 오래걸리기 때문에 몇몇 케이스에서 Timeout이 발생합니다
  그래프의 개념을 설명했을 때 인접행렬과 인접리스트의 개념을 배웠습니다. 이 둘의 차이는 a, b 두 개의 선의 간선의 존재 여부를 찾을 때 걸리는 시간입니다. 그리고 이를 해결해주기 위해서 인접 행렬 리스트를 선언하여 해결할 수 있습니다
  바로 이 시간이 오래 걸리기 때문에 몇 개의 저격 케이스에서 오답이 발생하고 있는 겁니다
  이 시간을 줄이는 방법은 상당히 간단합니다. 인접 행렬 그래프도 같이 선언하면 됩니다. 처음 그래프의 간선을 만들어 줄때 `check` 행렬을 만들고, `check[s][e]`를 `1`로 바꿔줄 겁니다.
  중요한 부분은 `nextNode`에서 `currentNode`로 오는 간선의 존재 여부를 파악할 때, `check[nextNode][currentNode]`가 `1`인지 확인하는 코드를 추가하면, 간선의 존재 여부를 확인하는 시간을 획기적으로 줄일 수 있습니다

  ```java
  import java.util.*;

  public class Main {
    public static void main(String[] agrs) {
        ...code
        int[][] check = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            graph.putIfAbsent(s, new ArrayList<>());
            graph.get(s).add(e);
            // s -> e로 가는 간선의 존재를 갱신
            check[s][e] = 1;
        }

        int[] visited = new int[N+1];
        int count = 1;

        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int currentNode = q.poll();
                    visited[currentNode] = count;
                    if (graph.containsKey(currentNode)) {
                        for (int nextNode : graph.get(currentNode)) {
                            if (graph.containsKey(nextNode)) {
                                // check 매트릭스에서 간선의 존재 여부를 확인합니다
                                if (check[nextNode][currentNode] == 1 && visited[nextNode] == 0) {
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
  ```

## Timeout code

```java
import java.util.*;

public class Main {
    public static void main(String[] agrs) {
        int N, M;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        for (int i = 0; i < M; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            graph.putIfAbsent(s, new ArrayList<>());
            graph.get(s).add(e);
        }
        int[] visited = new int[N+1];
        int count = 1;

        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int currentNode = q.poll();
                    visited[currentNode] = count;
                    if (graph.containsKey(currentNode)) {
                        for (int nextNode : graph.get(currentNode)) {
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
```

## 정해코드
