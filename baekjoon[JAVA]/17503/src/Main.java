import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int[][] beers = new int[K][2]; // [k][0] : 선호도, [k][1] : 도수 레벨

        for (int i = 0; i < K; i++) {
            stk = new StringTokenizer(br.readLine());
            beers[i][0] = Integer.parseInt(stk.nextToken());
            beers[i][1] = Integer.parseInt(stk.nextToken());
        }

        /**
         * 1. 도수가 낮은 맥주부터 마신다.
         * 2. 도수가 같다면, 선호도가 높은 것부터 마신다.
         * 3. N개의 맥주를 마셨음에도 선호도를 만족하지 못했다면, 선호도가 가장 낮은 맥주를 제외한다.
         * 3-1. 선호도가 동일하다면, 그중에서 도수가 가장 높은 맥주를 제외한다.
         * 4. 1,2 규칙을 따라 다음 맥주를 마신다.
         * 5. 3 규칙에 따라 맥주를 제외한다.
         */

        Arrays.sort(beers, (o1, o2) -> {
            if(o1[1] == o2[1]) return o2[0] - o1[0]; // 도수 레벨이 같다면, 선호도 내림차 순
            return o1[1] - o2[1]; // 도수 레벨 오름차순
        });

        PriorityQueue<int[]> minPreferHeap = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0]) return o2[1] - o1[1]; // 도수가 높은 맥주가 우선
            return o1[0] - o2[0]; // 선호도가 낮은 맥주가 우선
        });

        long preferSum = 0;
        int answer = -1;
        for (int i = 0; i < K; i++) {
            minPreferHeap.add(beers[i]);
            preferSum += beers[i][0];

            // 만약 PQ 크기가 N보다 커지면, 선호도가 가장 낮은 맥주 제거
            if(minPreferHeap.size() > N) {
                preferSum -= minPreferHeap.poll()[0];
            }

            // 정확히 N개의 맥주를 선택한 상태에서 선호도 합이 M 이상이면 조건 만족
            if(minPreferHeap.size() == N && preferSum >= M) {
                answer = beers[i][1]; // 현재 맥주의 도수 레벨이 최소 간 레벨
                break;
            }
        }

        System.out.println(answer);
    }
}

/* backtracking - 시간초과 Fail
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N; // 축제 기간
    static int M; // 최소 선호도 합
    static int K; // 맥주 수

    static  int[][] beers;
    private static boolean[] visited;
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        beers = new int[K][2]; // [k][0] : 선호도, [k][1] : 도수 레벨

        for (int i = 0; i < K; i++) {
            stk = new StringTokenizer(br.readLine());
            beers[i][0] = Integer.parseInt(stk.nextToken());
            beers[i][1] = Integer.parseInt(stk.nextToken());
        }

         Arrays.sort(beers, (o1, o2) -> {
             if(o1[1] == o2[1]) return o2[0] - o1[0]; // 도수 레벨이 같다면, 선호도 내림차 순
             return o1[1] - o2[1]; // 도수 레벨 오름차순
         });

        visited = new boolean[K];
        backtracking(0,0L, -1);
        System.out.println(answer);
    }

    private static void backtracking(int depth, Long preferences, int liverLevel) {
//        System.out.println("depth = " + depth + ", preferences = " + preferences + ", liverLevel = " + liverLevel);
//        if (answer != -1) return;

        if (M <= preferences && depth == N) {
            answer = liverLevel;
            return;
        }

        if (depth > N) return;

        for (int i = 0; i < K; i++) {
            if (answer != -1) return;
            if (visited[i]) continue;

            visited[i] = true;
            backtracking(depth + 1, preferences + beers[i][0], beers[i][1]);
            visited[i] = false;
        }
    }
}*/
