import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            /*
             * DP : 0/1 배낭 문제
             */
            int[][] dp = new int[n + 1][l + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int kcal = Integer.parseInt(st.nextToken());

                for (int j = 0; j < kcal; j++) {
                    dp[i][j] = dp[i - 1][j];
                }
                for (int j = kcal; j <= l; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - kcal] + score);
                }
            }

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                ans = Math.max(ans, dp[i][l]);
            }
            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.println(sb);
    }
}
