import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] sticker = new int[2][n];
            int[][] dp = new int[3][n];

            for (int j = 0; j < 2; j++) {
                stk = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++)
                    sticker[j][k] = Integer.parseInt(stk.nextToken());
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            dp[2][0] = 0;

            for (int j = 1; j < n; j++) {
                dp[0][j] = sticker[0][j] + Math.max(dp[1][j-1], dp[2][j-1]);
                dp[1][j] = sticker[1][j] + Math.max(dp[0][j-1], dp[2][j-1]);
                dp[2][j] = Math.max(dp[0][j-1], Math.max(dp[1][j-1], dp[2][j-1]));
            }

            int answer = Math.max(dp[0][n-1], Math.max(dp[1][n-1], dp[2][n-1]));
            System.out.println(answer);
        }
    }
}