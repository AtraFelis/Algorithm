import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<List<Integer>> network = new ArrayList<>();
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < N+1; i++) {
            network.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(stk.nextToken());
            int node2 = Integer.parseInt(stk.nextToken());

            network.get(node2).add(node1); // 단반향 그래프
        }

        int[] hackingCnt = new int[N + 1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            cnt = 0;

            visited[i] = true;
            dfs(i);

            max = Math.max(max, cnt);
            hackingCnt[i] = cnt;
        }

        for (int i = 1; i < N + 1; i++) {
            if(hackingCnt[i] == max)
                sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    private static void dfs(int node) {
        for (Integer i : network.get(node)) {
            if(!visited[i]) {
                visited[i] = true;
                cnt++;
                dfs(i);
            }
        }
    }
}