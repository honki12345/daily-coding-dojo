# 연합

## 문제

- 바다 위에 N 개의 섬이 있다. 섬은 1번부터 N번까지 차례대로 번호가 붙어있다. 서로 다른 두 섬 사이를 연결하는 M 개의 다리도 있다. 모든 다리는 단방향으로만 이동 가능하고, 어떤 두 섬을 잇는 다리는 정방향 하나, 역방향 하나씩 해서 최대 두개이다  
  어느날 섬들 사이에 분쟁이 일어났다. 모든 섬들은 세력을 키우기 위해 다른 섬과 연합을 결성하려고 한다. 임의의 두 섬 a와 b에 대해 a번 섬에서 b번 섬으로 직접 이동할 수 있는 다리와 b번 섬에서 a번 섬으로 직접 이동할 수 있는 다리가 있으면 두 섬은 연합을 결성한다
  이때 a와 b가 연합을 결성하고 b와 c가 연합을 결성했다면 a와 c 역시 위 조건을 만족하지 않더라도 같은 연합에 속해있는 것으로 본다
  다른 섬과 연합을 결성하지 않은 섬들도 각각 하나의 연합에 속해 있는것으로 볼 때 N개의 섬 사이에 존재하는 연합의 개수를 구해보자

## 예제설명

- 첫번째 예제에서는 정의에 따라 1번 섬과 4번 섬이 연합을 결성한다. 이외에 연합을 결성하는 다른 섬 쌍은 존재하지 않는다. 따라서 [1, 4], [2], [3] 세 개의 연합이 존재하므로 3을 출력해야한다.
  두 번째 예제에서는 정의에 따라 1번 섬과 2번 섬, 1번 섬과 3번 섬, 2번 섬과 3번 섬이 연합을 결성한다
  따라서 [1, 2, 3] 한 개의 연합이 존재하므로 1을 출력해야한다

## 입력

- 첫번째 줄에 섬의 개수 N과 다리의 개수 M이 공백을 두고 주어진다  
  다음 M개의 줄에는 si, e1가 공백을 두고 주어진다. si번 섬에서 ei번 섬으로 가는 다리가 있다는 의미이다
  - 2<= N <= 2000
  - 1<= M <= 200_000
  - 1<= si, ei <= N; s != e
  - 주어지는 모든 수는 정수이다

## 출력

- N개의 섬 사이에 존재하는 연합의 개수를 출력한다
