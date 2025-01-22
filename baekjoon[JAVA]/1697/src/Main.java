import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n, m;
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        int answer = dp(n, m);
        System.out.println(answer);
    }

    private static int bfs(int start, int end) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        int prev_pos = start;
        int cnt = 0;
        q.add(new int[]{prev_pos, cnt});

        if(start >= end) {
            return start - end;
        }

        while (true) {
            int[] tmp = q.poll();
            prev_pos = tmp[0];
            visited[prev_pos] = true;

            cnt = tmp[1] + 1;
            int cur_pos;

            int[] move = {prev_pos, 1, -1};
            for (int i = 0; i < 3; i++) {
                cur_pos = prev_pos + move[i];

                // 가지치기
                if (cur_pos > 100000 || cur_pos < 0 || visited[cur_pos]) {
                    continue;
                }

                q.add(new int[]{cur_pos, cnt});

                if(cur_pos == end) {
                    return cnt;
                }
            }
        }
    }

    private static int dp(int start, int end) {
        if(start >= end) {
            return start - end;
        }

        int[] dp = new int[end+2];

        int cnt = 0;
        for (int i = start; i >= 0; i--) {
            dp[i] = cnt++;
        }

        cnt=0;
        for (int i = start; i <= end + 1; i++) {
            dp[i] = cnt++;
        }

        for (int i = start + 1; i <= end; i++) {
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            } else {
                dp[i] = Math.min(dp[i], dp[(i + 1) / 2] + 2);
            }

            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }
        return dp[end];
    }
}