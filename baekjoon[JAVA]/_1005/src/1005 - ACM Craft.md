![](https://i.imgur.com/7AGjdiU.png)

## 문제

서기 2012년! 드디어 2년간 수많은 국민들을 기다리게 한 게임 ACM Craft (Association of Construction Manager Craft)가 발매되었다.

이 게임은 지금까지 나온 게임들과는 다르게 ACM크래프트는 다이나믹한 게임 진행을 위해 건물을 짓는 순서가 정해져 있지 않다. 즉, 첫 번째 게임과 두 번째 게임이 건물을 짓는 순서가 다를 수도 있다. 매 게임시작 시 건물을 짓는 순서가 주어진다. 또한 모든 건물은 각각 건설을 시작하여 완성이 될 때까지 Delay가 존재한다.

![](https://www.acmicpc.net/upload/201003/star.JPG)

위의 예시를 보자.

이번 게임에서는 다음과 같이 건설 순서 규칙이 주어졌다. 1번 건물의 건설이 완료된다면 2번과 3번의 건설을 시작할수 있다. (동시에 진행이 가능하다) 그리고 4번 건물을 짓기 위해서는 2번과 3번 건물이 모두 건설 완료되어야지만 4번건물의 건설을 시작할수 있다.

따라서 4번건물의 건설을 완료하기 위해서는 우선 처음 1번 건물을 건설하는데 10초가 소요된다. 그리고 2번 건물과 3번 건물을 동시에 건설하기 시작하면 2번은 1초뒤에 건설이 완료되지만 아직 3번 건물이 완료되지 않았으므로 4번 건물을 건설할 수 없다. 3번 건물이 완성되고 나면 그때 4번 건물을 지을수 있으므로 4번 건물이 완성되기까지는 총 120초가 소요된다.

프로게이머 최백준은 애인과의 데이트 비용을 마련하기 위해 서강대학교배 ACM크래프트 대회에 참가했다! 최백준은 화려한 컨트롤 실력을 가지고 있기 때문에 모든 경기에서 특정 건물만 짓는다면 무조건 게임에서 이길 수 있다. 그러나 매 게임마다 특정건물을 짓기 위한 순서가 달라지므로 최백준은 좌절하고 있었다. 백준이를 위해 특정건물을 가장 빨리 지을 때까지 걸리는 최소시간을 알아내는 프로그램을 작성해주자.

## 입력

첫째 줄에는 테스트케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 주어진다. 첫째 줄에 건물의 개수 N과 건물간의 건설순서 규칙의 총 개수 K이 주어진다. (건물의 번호는 1번부터 N번까지 존재한다) 

둘째 줄에는 각 건물당 건설에 걸리는 시간 D1, D2, ..., DN이 공백을 사이로 주어진다. 셋째 줄부터 K+2줄까지 건설순서 X Y가 주어진다. (이는 건물 X를 지은 다음에 건물 Y를 짓는 것이 가능하다는 의미이다) 

마지막 줄에는 백준이가 승리하기 위해 건설해야 할 건물의 번호 W가 주어진다.

## 출력

건물 W를 건설완료 하는데 드는 최소 시간을 출력한다. 편의상 건물을 짓는 명령을 내리는 데는 시간이 소요되지 않는다고 가정한다.

건설순서는 모든 건물이 건설 가능하도록 주어진다.

## 풀이

- 알고리즘 : `DP`, `위상정렬`

이론으로만 배웠던 위상정렬을 사용해야 했던 문제였다. `위상정렬`을 사용해야 하므로 가장 중요한 것은 자신을 가리키는 다른 노드가 없는 노드를 어떻게 찾을 것이냐, 였다. 즉, `위상정렬`의 시작점을 알아내는 것이었는데, 나는 이 부분에서 조금 헤매었다.

그래프를 순회하면서 찾자니 시간적으로 많은 손해를 볼 것이 분명했으니까.

고민하다가 떠올린 방법은, 그래프를 입력 받을 때 애초부터 **노드 별로 자신을 가리키는 노드의 수를 배열로 저장**을 해두면 된다는 것이었다. (의외로 간단한 방법이 떠올리기 제일 어렵더라.)

이후로는 `DP`와 `큐`를 이용해 해를 구하면 된다

```java
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.LinkedList;  
import java.util.Queue;  
import java.util.StringTokenizer;  
  
public class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer stk;  
        StringBuilder sb = new StringBuilder();  
  
        int T = Integer.parseInt(br.readLine());  
  
        for (int i = 0; i < T; i++) {  
            stk = new StringTokenizer(br.readLine());  
            int N = Integer.parseInt(stk.nextToken());  
            int K = Integer.parseInt(stk.nextToken());  
  
            int[] D = new int[N+1];  
            stk = new StringTokenizer(br.readLine());  
            for (int j = 1; j <= N; j++)  
                D[j] = Integer.parseInt(stk.nextToken());  
  
            boolean[][] graph = new boolean[N+1][N+1];  
            int[] nodes = new int[N+1];  
            for (int j = 0; j < K; j++) {  
                stk = new StringTokenizer(br.readLine());  
  
                int X = Integer.parseInt(stk.nextToken());  
                int Y = Integer.parseInt(stk.nextToken());  
  
                graph[X][Y] = true;  
                nodes[Y]++;  
            }  
  
            int W = Integer.parseInt(br.readLine());  
  
            int[] dp = new int[N + 1];  
            Queue<Integer> q = new LinkedList<>();
  
            for (int j = 1; j < N+1; j++) {  
                if(nodes[j] == 0) {  
                    q.add(j);  
                    dp[j] = D[j];  
                }  
            }  
  
            while(!q.isEmpty()) {  
                int cur = q.remove();  
  
                for (int j = 1; j < N+1; j++) {  
                    if(graph[cur][j]) {  
                        dp[j] = Integer.max(dp[cur] + D[j], dp[j]);  
  
                        if(--nodes[j] == 0)  
                            q.add(j);
                    }  
                }  
            }  
  
            sb.append(dp[W]).append("\n");  
        }  
  
        System.out.println(sb);  
    }  
}
```