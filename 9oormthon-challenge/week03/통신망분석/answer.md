# 통신망 분석

## 필요한 개념

- 그래프
- BFS / DFS

## 분석

- 이번 문제는 그래프 탐색을 통해 다양한 정보를 얻어서 처리해야하는 문제입니다. 어려운 테크닉이 필요하지는 않지만 요구사항이 복잡하기 때문에 조건을 꼼꼼히 따져보고 다양한 예제를 통해 검증하는 능력이 필요합니다

## 문제풀이

- 문제의 요구 조건을 만족하는 컴포넌트를 찾기 위해서는 다음 세 가지를 찾아야 합니다
  - 1. 컴포넌트에 속한 컴퓨터의 수
  - 2. 컴포넌트에 속한 통신 회선의 수
  - 3. 컴포넌트에서 가장 작은 컴퓨터의 번호
       세 정보 모두 한 번의 그래프 탐색을 통해 얻을 수 있습니다. 이 정보를 잘 이용해 조건에 맞는 컴포넌트를 출력해주면 됩니다

## 컴포넌트란?

- 그래프 이론에서 컴포넌트는 보통 연결된 부분 그래프를 의미합니다. 그 중에서 연결 컴포넌트의 개념이 있습니다. 그래프는 여러 개의 연결 컴포넌트로 나누어질 수 있으며, 하나의 연결 컴포넌트는 그 그래프 내의 모든 정점들이 경로를 통해 서로 연결될 수 있는 정점의 집합입니다. 그래프의 각 연결 컴포넌트는 다른 연결 컴포넌트의 정점과는 직접적인 경로가 없습니다  
  간략하게 설명하자면 연결 컴포넌트는 그래프 내에서 서로 연결된 정점들의 집합을 말합니다

## 그래프 탐색으로 필요한 정보 얻기

- 그래프를 탐색할 때 얻어야 하는 정보는 위에서 정리했습니다. 이제 이 정보들을 얻기 위한 BFS를 구현해볼게요

```java
...code 데이터 입력코드
public static Pair bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);

    Set<Integer> component = new HashSet<>();

    while (!q.isEmpty()) {
        int now = q.poll();

        if (visited[now]) {
            continue;
        }

        visited[now] = true;
        component.add(now);

        for (int to : graph[now]) {
            if (!visited[to]) {
                q.add(to);
            }
        }
    }
}
```

- 여기까지 진행했다면, `component` 집합에 `start`에서 시작해 도달한 컴퓨터들이 모두 저장되어 있습니다.  
  필요한 정보 3가지 중에서, 컴퓨터의 수는 `len(component)`로 구하고, 가장 작은 컴퓨터의 번호는 `component`를 리스트로 변환하고 정렬해 첫번째 값입니다
  마지막으로 컴포넌트 내부에 통신 회선이 몇개가 있는지만 찾으면 됩니다

  ```java
  // 간선의 수를 저장할 변수를 선언합니다
  int edge = 0;
  // 컴포넌트에 속한 모든 컴퓨터에 대해서 순회합니다
  for (int i : component) {
    // 범위 오류 방지를 위해서 간선이 존재하는 노드인지 확인해요
    for (int to : graph[i]) {
        // 도달 가능한 컴퓨터 중에서,
        // 해당 컴포넌트에 속한다면 컴포넌트 내부의 통신 회선입니다
        if (component.contains(to)) {
            edge++;
        }
    }
  }
  ```

- 위에서 `component`를 집합으로 선언했던 이유는 바로 이 부분 때문입니다. 간선의 존재 여부를 확인하기 위해서, 집합은 상수시간이 걸립니다  
  마지막으로 문제에서 출력해야하는 값은 `조건을 만족하는 컴포넌트에 포함된 컴퓨터의 번호들`이므로, `component` 배열이 필요합니다. 추가로 컴포넌트끼리 비교할 때 `밀도`가 필요합니다

  ```java
  List<Integer> sortedList = new ArrayList<>(component);
  Collections.sort(sortedList);
  return new Pair(sortedList, (double) edge / component.size());
  ```

  또 이 찾아낸 컴포넌트와 밀도 데이터를 하나의 데이터인 `Pair`로 관리하려고 해서, `Pair` 클래스의 선언도 필요합니다

  ```java
  static class Pair {
    List<Integer> list;
    double value;

    Pair(List<Integer> list, double value) {
        this.list = list;
        this.value = value;
    }
  }
  ```

## 요구조건판별

- 먼저 정답을 저장할 변수들을 선언해 두겠습니다  
  그 다음, 위에서 작성한 탐색을 사용하여 탐색을 진행하며 이 값들을 업데이트 해주면 됩니다

  ```java
  List<Integer> result = new ArrayList<>();
  double density = 0;
  for (int i = 1; i <= N; i++) {
    // 방문하지 않은 컴퓨터인 경우만 탐색합니다
    if (!visited[i]) {
        ..code
    }
  }
  ```

  이제 우리는 `result, density`와 `temp, tempDensity`를 비교하며 답을 구해가면 됩니다. 주어진 조건들을 이용해서 비교해보도록 할게요  
  조건을 순서대로 사용하면 좋겠지만, 그렇게 하면 우리가 작성한 코드에서는 문제가 생길 수 있어요.
  바로 `실수값 오차` 문제인데요. BFS 함수에서 반환하는 `edge / len(component)`의 값이 실수 값이기 때문에 발생할 수 있는 문제에요.
  따라서 대소 비교를 하기 전에 `density와 tempDensity가 같은 값인지` 확인하겠습니다

  ```java
  if (Math.abs(tempDensity - density) < 1e-8) {
    // 만약에 밀도가 같으면, 2번 조건을 확인합니다.
    // 만약 현재 컴포넌트 배열이 더 크면 result 값을 확인합니다.
    // 만약에 배열의 크기가 같으면 첫번째 값을 비교하면 됩니다
    if (result.size() > temp.size()) {
        result = temp;
        density = tempDensity;
    }
    else if (result.size() == temp.size()) {
        if (temp.get(0) < result.get()) {
            result = temp;
            density = tempDensity;
        }
    }
  }
  // 밀도가 다른 경우 1번 조건을 고려합니다.
  else if (tempDensity > density) {
    result = temp;
    density = tempDensity;
  }
  ```

  이와 같이 조건을 꼼꼼하게 따져 비교하면 답을 구할 수 있습니다. 이제 답을 출력하면 되겠네요. 조건을 만족하는 컴포넌트를 오름차순으로 출력하면 됩니다. 정렬하면 확실하게 정답을 찾을 수 있습니다

  ```java
  for (int node : result) {
    System.out.println(node + " ");
  }
  ```
