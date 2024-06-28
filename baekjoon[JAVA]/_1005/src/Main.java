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