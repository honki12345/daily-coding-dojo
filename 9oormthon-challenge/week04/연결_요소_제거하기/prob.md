# 연결 요소 제거하기

## 문제

- NXN 크기의 2차원 배열이 있다. 2차원 배열의 i행 j열에 해당하는 칸은 (i, j)로 나타낸다. 처음에 이 배열의 각 칸에는 알파벳 대문자 또는 `.` 문자가 하나 적혀 있다  
  상하좌우로 인접한 두 칸에 같은 문자가 적혀있는 경우, 두 칸은 **연결**되어있다고 한다. 서로 연결된 칸들의 집합을 연결 요소라고 하고, 이 연결요소의 크기는 그 연결 요소에 포함된 칸들의 개수와 같다
  구름이는 아래 작업을 Q번 수행하려고 한다
  1. (yi, xi)칸을 고른 뒤, 그 칸에 알파벳 대문자 di를 쓴다. 구름이가 고른 칸은 `.`문자가 적힌 칸임이 보장된다
  2. 배열에 존재하는 모든 연결 요소의 크기를 계산한다. 만약 크기가 K 이상인 연결 요소가 존재한다면 그 연결요소에 포함된 모든 칸에 적힌 문자를 지운다
  모든 작업을 수행한 뒤에, 배열에 적혀있는 문자를 구해보자

## 입력

- 첫째 줄에 배열의 크기 N, 연결요소를 지울 기준 K, 그리고 구름이가 문자를 적을 횟수 Q가 공백을 두고 주어진다
  다음 N개의 줄에는 N개의 문자가 주어진다. 주어지는 문자는 `.` 또는 알파벳 대문자 중 하나이며, `.` 문자는 처음에 배열의 칸이 비어있음을 의미한다. r번째 줄에서 c번째로 주어지는 문자는 (r, c)칸에 대한 정보이다
  다음 Q개의 줄에는 두 정수 yi, xi와 알파벳 대문자 di가 공백을 두고 주어진다
  구름이가 (yi, xi)칸에 di문자를 적었음을 의미한다
  - 3<=N<=50
  - 2<=K<=50
  - 1<=Q<=1000
  - 1<=xi, yi<=N
  - 처음에는 크기가 K 이상인 연결요소가 존재하지 않는다
  - 구름이가 문자를 적을 칸은 비어있음이 보장된다
  - di는 알파벳 대문자이다

## 출력

- 구름이가 Q개의 작업을 모두 수행한 뒤, 마지막에 배열에 적혀있는 문자를 N개의 줄에 걸쳐 출력한다. 아무 문자도 적혀있지 않은 칸은 `.`문자를 대신 출력한다
