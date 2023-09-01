# 발전기(2)

## 필요한 개념

- Stack(스택)
- Queue(큐)
- DFS(깊이우선탐색)

## 분석

- 발전기 문제와 비슷하지만 몇몇 부분이 다른 문제입니다. 인접한 집 그룹을 단지라는 개념으로 파악하기 위해서, 건물의 유형을 파악해야 합니다  
  발전기는 하나의 유형의 건물에 전기를 공급하기 때문에, 어떤 유형의 건물이 가장 많은 단지를 보유하고 있는지 찾으면 됩니다

## 문제풀이

- 문제의 내용을 정리하면 아래와 같습니다
  1. 어떤 건물에서 인접한 건물의 유형이 같은 유형을 찾은 후 단지가 형성될 수 있는지 확인한다
  2. 어떤 건물의 유형이 가장 많은 단지를 보유하고 있는지 확인한다  
     즉, 이 문제는 실제로 건물 유형 별로 단지의 개수를 구하는 문제입니다. 이 문제도 BFS로 해결할 수 있지만 DFS 개념을 배우면 해결할 수 있습니다

## DFS(깊이우선탐색)

- Depth-First-Search, 줄여서 DFS라고 부릅니다. DFS는 현재 위치를 기준으로, 방문을 시작한 위치와 방향으로 탐색이 불가능할 때까지 탐색한 이후에 돌아옵니다.  
  보통 BFS나 DFS 같은 탐색 방법은 그래프에서 사용된다고 생각할 수 있지만, 행렬 문제도 다양한 탐색 방법을 적용할 수 있습니다  
  각각의 칸을 하나의 위치로 생각하고, 현재 위치에서 갈 수 있는 위치부터 먼저 탐색한다는 의미입니다. 보통은 상하좌우이며, 문제에 따라서는 대각선도 나올 수 있습니다.  
  완전탐색과 다른 점은 갈 수 있는 위치만 탐색한다는 점입니다. 결론적으로는 못 가거나, 갈 수 없는 위치는 굳이 탐색할 필요가 없어지니 완전 탐색보다는 효율적입니다

## 탐색을 위한 구조 만들기

- 문제의 요구사항을 다시 살펴보고, 해결방법을 고민하면 아래와 같은 흐름을 가져갈 수 있습니다.

  1. 어떤 건물의 상하좌우 인접한 건물이 현재 건물과 동일한 유형인지 확인한다  
     -> 즉 어떤 건물이 원래의 건물과 같은 유형이라면, 해당 건물을 기준으로 주변에 또 다른 새로운 같은 유형의 건물을 찾아야한다
  2. 하나의 단지를 찾은 뒤, 또 다른 곳에 다른 단지가 있는지 탐색해야 합니다
     이제 문제 해결을 위해서 필요한 틀을 그려보면 됩니다

  ```java
  import java.util.*;

  public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 데이터 입력
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] matrix = new int[N][N];

        // 탐색을 위한 Data
        boolean[][] visited = new boolean[N][N];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        // M(R, C)의 최대값이 30이기 때문에, 길이가 30 이상인 score 배열 선언
        int[] score = new int[32];
        // matrix 할당
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }
  }
  ```

## 탐색하기

- 이제부터는 본격적으로 탐색을 해보려고 합니다

  1. `visited[x][y]`의 값이 `0`인 `(x, y)`를 우선 찾습니다. 그 위치의 `matrix[x][y]`의 값이 `target`입니다
  2. 해당 위치를 기준으로 상하좌우에 또 다른 집이 있는지 확인합니다  
     -> 만약에 그 집의 `matrix[x][y]`의 값이 `target`이면서 `visited[x][y]`의 값이 `0`이라면, 다음번 탐색 후보에 추가합니다.
     -> 탐색에 성공한다면 `size++`합니다.
  3. 탐색후보가 모두 없어질때까지 탐색을 계속 진행합니다.
     위의 과정을 처리하면, 건물 유형별로 단지가 몇개 나오는지 알 수 있습니다. 사실 자바에서 `BFS`와 `DFS`의 차이는 탐색 후보에서 뒤에서 후보를 가져오는지 앞에서 후보를 가져오는지의 차이입니다.

  ```java
  import java.util.*;

  public class Main {
    public static void main(String[] args) {
        ...
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] != 0 && visited[i][j] == false) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visitied[i][j] = true;
                }

                // 단지의 크기와 단지 건물의 유형
                int size = 1;
                int target = matrix[i][j];

                // 탐색 후보가 없을 때까지 탐색합니다
                while (!q.isEmpty()) {
                    int[] current = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nextR = current[0] + dx[k];
                        int nextC = current[1] + dy[k];

                        // 마을의 범위 확인
                        if (0 <= nextR && nextR < N && 0 <= nextC && nextC < N) {
                            // 방문한적 없음 && matrix[x][y] 의 값이 target일 때 탐색
                            if (visited[nextR][nextC] == false && matrix[nextR][nextC] == target) {
                                visited[nextR][nextC] = true;
                                q.add(new int[]{nextR, nextC});

                                // 단지의 크기 키우기
                                size++;
                            }
                        }
                    }
                }

                if (size >= K) {
                    score[target]++;
                }
            }
        }
    }

    // 건물의 종류가 가장 많은 단지를 찾음
    // 건물의 유형이 더 큰 것을 찾기 때문에 뒤에서부터 탐색한다
    int maxIndex = 0;
    for (int i = 31; i > -1; i--) {
        if (score[i] > score[maxIndex]) {
            maxIndex = i;
        }
    }

    System.out.println(maxIndex);
  }
  ```
