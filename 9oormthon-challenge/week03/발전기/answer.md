# 발전기

## 필요한 개념

- Stack(스택)
- Queue(큐)
- BFS(너비 우선 탐색)

## 분석

- 주어진 행렬에서 요구하는 값을 찾는 문제입니다. 행렬에서 효율적으로 이동을 하면서 값을 빠르게 찾아내는 것이 중요합니다. 그러기 위해서는 완전 탐색이 아닌, 다른 탐색 방법이 필요합니다.

## 문제풀이

- 문제의 내용을 정리하면 아래와 같습니다.
- 1. 행렬은 `0`과 `1`로 이루어지며, `1`이면 집이 있는 칸이다
- 2. 어떤 집에 발전기를 설치해 전력을 공급할 수 있다
- 3. 어떤 집에 상하좌우로 인접한 집 중 하나가 전력을 공급받고 있으면, 그 집 또한 전력을 공급받는다
- 4. 문제에서 묻는 것은 설치해야 하는 발전기의 최소 개수이다
- 이 문제를 해결하기 위해서 결국, 어떤 집에 발전기를 설치했을 때 전기를 공급 받을 수 있는 집을 알아야합니다. 공급 받은 집에는 발전기를 설치하지 않아도 되기 때문입니다.  
  즉, 아 문제는 실제로 `인접한 집의 집합`의 개수를 구하는 문제입니다. 이를 효율적으로 찾기 위해서 `BFS`가 필요합니다. 탐색을 위해서 2개의 기본적인 자료형을 알아보고 탐색을 알려드리겠습니다.

## Stack(스택)

- 스택은 `First-In-Last-Out`이라고 설명할 수 있는 자료구조입니다. `먼저 들어간 것이 나중에 나온다`는 의미인데요. 자바에서는 `Array`자료형으로 간단하게 스택을 구현할 수 있습니다

  ```java
  import java.util.Stack;

  class main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // push를 이용해 스택에 원소를 채워 넣어요
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // 스택의 맨 꼭대기에 있는 원소를 조회할 땐 peek() 메서드를 사용해요
        System.out.println(stack.peek());   // 3

        // 스택에서 값을 제거할 때에는 pop()을 사용합니다
        stack.pop();    // 스택의 끝에 있는 3을 단순히 제거만 했어요
        int value = stack.pop();    // 스택의 끝의 2를 바로 할당할 수 있어요
        System.out.println(value);  // 2
    }
  }
  ```

## Queue(큐)

- 큐는 `First-In-First-Out`이라고 설명할 수 있는 자료구조입니다. 스택과는 반대로 `먼저 들어간 것이 먼저 나옵니다`  
  사람들이 쭉 늘어서 있는 대기열을 큐의 예시라고 할 수 있습니다. 먼저 서있던 사람이 먼저 나갈테니까요. `queue`는 `LinkedList`로 만들어요

  ```java
  import java.util.LinkedList;
  import java.util.Queue;

  class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // enqueue를 이용해 큐에 원소를 채워넣어요
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // 큐의 맨 앞에 있는 원소를 조회할 땐 peek() 메서드를 사용해요
        System.out.println(queue.peek());   // 1

        // 큐에서 값을 제거할 때에는 poll()을 사용합니다
        queue.poll();   // 큐의 앞에 있는 1을 단순히 제거만 했어요
        int value = queue.poll();   // 큐의 앞의 2를 바로 할당할 수 있어요
        System.out.println(value);  // 2
    }
  }

  ```

## BFS(너비우선탐색)

- Breadth-First-Search 줄여서 BFS라고 부릅니다. BFS는 현재 위치를 기준으로, 방문이 가능한 모든 위치를 탐색합니다. 그 다음 단계에서는 `이전 단계에서 구한 위치`들을 기준으로 다시 방문이 가능한 모든 위치를 탐색합니다
  보통 BFS나 DFS같은 탐색방법은 `그래프`에서 사용된다고 생각할 수 있지만, 행렬 문제도 다양한 탐색 방법을 적용할 수 있습니다
  일정의 각각의 칸을 하나의 위치로 생각하고, 현재 위치에서 **갈 수 있는 위치부터** 먼저 탐색한다는 의미입니다. 보통은 상하좌우이며, 문제에 따라서는 대각선도 나올 수 있습니다
  `완전탐색`과 다른 점은 `갈 수 있는 위치`만 탐색한다는 점입니다. 결론적으로 못 가거나, 갈 수 없는 위치는 굳이 탐색할 필요가 없어지니 완전 탐색보다는 효율적입니다.
  사실, 이미 지난 문제들에서 이 문제를 풀기위한 방법들은 배웠습니다. 다만 이 방법으로 항상 `완전 탐색`으로만 구현했고, 이번에는 `Queue`를 사용해서 BFS로 이 문제를 풀어보겠습니다

## 탐색을 위한 구조 만들기

- 문제의 요구사항을 다시 살펴보고, 해결 방법을 고민하면 아래와 같은 흐름을 가져갈 수 있습니다

  1. 하나의 발전기를 통해서, 어떤 집에 전기가 공급된다면 `상하좌우`인접한 집에 전기를 공급할 수 있습니다
     -> 즉 어떤 집에 공급되고 있다면 해당 집을 기준으로 전기를 공급할 수 있는 `새로운 집을 찾아야`합니다
  2. 하나의 발전기로 `전기가 공급되는 집`을 탐색한 뒤, 다시 전기가 필요한 집을 탐색해야합니다.

- 이제 문제 해결을 위해서 필요한 틀을 그려보면 됩니다. 우선 상하좌우 이동을 위해서

  - `dx/dy 기법`을 사용하여 상하좌우 이동을 구현합니다
  - `matrix` 변수를 사용하여 현재 마을의 상태를 저장합니다
    `matrix` 할당은 반복문을 사용합니다
  - `boolean[][] visited = new boolean[N][N];` `visited` 변수를 활용해서 전기가 공급되고 있는 집을 기록합니다.

  ```java
  import java.util.LinkedList;
  import java.util.Queue;
  import java.util.Scanner;

  public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 데이터 처리
        int N = scanner.nextInt();
        int[][] matrix = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        // dx/dy 기법
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
  }
  ```

## 탐색하기

- 이제부터 본격적으로 탐색을 해보려고 합니다
  1. `matrix[x][y]`의 값이 `1`이면서, `visited[x][y]`의 값이 `0`인 `(x, y)`를 우선 찾습니다
  2. 해당 위치를 기준으로, 상하좌우에 또 다른 집이 있는지 확인합니다
     -> 만약에 그 집의 `matrix[x][y]`의 값이 `1`이면서, `visited[x][y]`의 값이 `0`이라면, 다음 번 **탐색 후보**에 추가합니다.
  3. **탐색후보**가 모두 없어질 때까지 탐색을 계속 진행합니다
- 위의 과정을 처리하면 하나의 발전기가 전기를 공급할 수 있는 모든 집을 알 수 있습니다. 이 때 **탐색 후보**라는 말이 나옵니다. 바로 탐색 후보의 자료구조 형태가 `큐` 또는 `스택`입니다.  
  BFS는 `큐`로 구현을 하고, 모든 탐색후보는 `큐`를 통해서 관리합니다. 탐색에 대해서 자세하게 설명하는 것보다는 코드를 보면서 이해하는 편이 쉽습니다

  ```java
  import java.util.*;

  public class Main {
    public static void main(String[] args) {
        ...
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 탐색의 조건 (i, j) 위치에 1이 있으면, 방문한적이 없을 때,
                if (matrix[i][j] == 1 && visited[i][j] == false) {
                    // q는 탐색 후보를 관리할 큐입니다
                    // 첫번째 탐색 후보를 추가합니다
                    // visited 변수를 갱신합니다
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j}); // offer를 사용해도 문제는 없습니다
                    visited[i][j] = true;

                    // 탐색 후보가 없을 때까지 탐색합니다
                    while (!q.isEmpty()) {
                        // 탐색 후보를 꺼내옵니다
                        int[] current = q.poll();

                        // 현재 탐색 위치에서 상하좌우를 탐색합니다
                        for (int k = 0; k < 4; k++) {
                            int nextX = current[0] + dx[k];
                            int nextY = current[1] + dy[k];
                            // 마을 안의 좌표인지 확인
                            if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
                                // 집이 있으면서, 전기가 공급되고 있는지 확인
                                if (matrix[nextX][nextY] == 1 && visited[nextX][nextY] == false) {
                                    // 모든 조건을 만족하면 새롭게 전기가 공급되는 집이기 때문에 탐색 후보에 추가한다
                                    q.add(new int[]{nextX, nextY});
                                    visited[nextX][nextY] = true;
                                }
                            }


                        }
                    }
                }
            }
        }
            System.out.println(count);
    }
  }
  ```

- 즉 하나의 발전기를 세울 때마다 위의 BFS 코드가 실행됩니다. 다시 말해서 BFS코드가 실행될 때마다 발전기를 하나 세웠다는 뜻과 동일합니다. 이를 `count`변수로 관리하고 출력하면 됩니다

  ```java
  import java.util.*;

  public class Main {
    public static void main(String[] args) {
        ...
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1 && visited[i][j] == false) {
                    ...
                    // 탐색 후보가 없을 때까지 탐색합니다
                    while (!q.isEmpty()) {
                        ...
                    }

                    // 탐색을 시도할 때마다 발전기의 개수 +1
                    count++;
                }
            }
        }
        System.out.println(count);
    }
  }
  ```

## 정해코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;
        int[][] matrix = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        int[] dy = {1,-1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1 && visited[i][j] == false) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[i]{i, j});
                    visited[i][j] = true;
                }

                while (!q.isEmpty()) {
                    int[] current = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nextX = current[0] + dx[k];
                        int nextY = current[1] + dy[k];
                        // 마을 안의 좌표인지 확인
                        if (i <= nextX && nextX < N && 0 <= nextY && nextY < N) {
                            if (matrix[nextX][nextY] == 1 && visited[nextX][nextY] == false) {
                                q.add(new int[]{nextX, nextY});
                                visited[nextX][nextY] = true;
                            }
                        }
                    }
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
```
