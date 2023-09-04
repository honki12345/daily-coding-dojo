# 과일구매

## 필요한 개념

- 그리디 알고리즘
- 정렬

## 분석

- 과일을 나눠서 살 수 있다는 내용을 제외하고 이 문제는 배낭문제(K-napsack)입니다. 배낭문제는 무게와 가치가 다른 물건들이 있고, 제한된 배낭에 물건을 담았을 때, 배낭에 담은 물건들의 가치가 최대가 되도록 물건을 담는 방법을 구하는 문제입니다.  
  하지만, 이 문제는 동일하지만, **과일을 나눠서 살 수 있다는 점**이 다릅니다. 때문에 일반적인 배낭 문제가 아니라, 현재 선택해서 최고의 선택을 하는 그리디 알고리즘이 필요합니다.

## 문제풀이

- 문제를 풀기 위해서는 언제 최대의 포만감이 생길지 고민해야 합니다. 고민을 해결하면 문제를 해결할 수 있거든요  
  과일들의 가격이 모두 동일한 가격이라고 가정했을 때, 최대의 포만감을 얻기 위해서는 당연히 포만감이 큰 과일부터 구매하면 됩니다
  이 당연한 사실이 이 문제에서 적용됩니다
  가격이 Pi이고 포만감이 Ci인 과일은 P조각으로 나눈다고 생각하면, 조각 과일의 가격은 1이고 포만감은 Ci/Pi입니다.
  즉 위의 특수한 상황과 동일합니다. 모든 조각 과일의 비용은 동일하지만, 포만감은 다르기 때문에 포만감이 높은 과일부터 구매하면 됩니다.

## 묶어서 해결하기

- 위의 풀이를 그대로 구현해봅시다

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int MAX = 1004;
        int[] P = new int[MAX];
        int[] C = new int[MAX];

        List<String> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }

        int idx = 0;
        String[] firstLine = input.get(idx++).split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);
        int ans = 0;

        for (int i = 1; i <= N; ++i) {
            String[] values = input.get(idx++).split(" ");
            P[i] = Integer.parseInt(values[0]);
            C[i] = Integer.parseInt(values[1]);
        }

        List<Integer> ord = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int n = 0; n < P[i]; n++) {
                ord.add((int) Math.floor(C[i] / P[i]));
            }
        }

        Collections.sort(ord, (a, b) -> b - a);

        for (int i = 0; i < K; ++i) {
            ans += ord.get(i);
        }

        System.out.println(ans);
    }
}
```

- 이렇게 구현할 경우 절반 정도의 테스트 케이스에서 런타임 에러를 받게 됩니다. 아래 테스트 케이스와 같이 **조각의 개수가 매우 많아지는 경우**가 문제가 될 수 있습니다. 특히 N개의 과일이 모두 아래와 같은 P와 C 값을 갖는 경우 조각의 개수는 O(NP)개가 되기 때문에 이런 방식으로는 문제를 푸는 것이 불가능합니다.

```java
Input
1 1
100000000   100000000
Output
1
```

문제를 해결하기 위해선, **같은 포만감 수치를 가진 조각을 묶어서** 처리해야 한다는 아이디어가 필요합니다

- 다시 과일 단위로 구매하기  
  같은 과일에서 나온 조각은 모두 **포만감 수치가 동일**합니다. 따라서 조각 당 포만감 수치가 가장 높은 과일부터 사되, 현재 가진 돈이 부족해서 과일을 온전히 구매하지 못할 때만 조각 단위로 구매한다고 생각할 수 있습니다.

  ```java
  List<double[]> cost = new ArrayList<>();
  for (int i = 1; i <=N; i++) {
    cost.add(new double[]{(double) C[i] / P[i], (double) P[i]});
    // 정렬 조건 설정
    Collections.sort(cost, (a, b) -> Double.compare(b[0], a[0] != 0 ? Double.compare(b[0], a[0]) : Double.compare(b[1], a[1])));

    for (int i = 0; i < N; i++) {
        double[] pair = cost.get(i);
        double value = pair[0];
        double amount = pair[1];
        double buy = Math.min(amount, K);
        K -= buy;
        ans += value * buy;
    }
  }
  ```

## 답안지

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lines = new ArrayList<>();
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] P = new int[N+1];
        int[] C = new int[N+1];
        long ans = 0;

        for (int i = 1; i <= N; i++) {
            P[i] = scanner.nextInt();
            C[i] = scanner.nextInt();
        }

        List<double[]> cost = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            cost.add(new double[]{(double) C[i] / P[i], (double P[i])});
        }
        Collections.sort(cost, (a, b) -> Double.compare(b[0], a[0]) != 0? Double.compare(b[0], a[0]) : Double.compare(b[1], a[1]));

        for (int i = 0; i < N; i++) {
            double[] pair = cost.get(i);
            double value = pair[0];
            double amount = pair[1];
            double buy = Math.min(amount, K);
            K -= buy;
            ans += value * buy;
        }
        System.out.println((long) Math.floor(ans));
    }
}
```
