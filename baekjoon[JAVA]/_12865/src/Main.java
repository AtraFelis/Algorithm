import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[][] items = new int[n][2];
        int[][] dp = new int[n+1][k+1];

        for (int i = 0;  i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(stk.nextToken());
            items[i][1] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 1; i < n+1; i++) {
            for (int w = 1; w < k+1; w++) {
                if(w >= items[i-1][0]) {
                    dp[i][w] = Integer.max(dp[i-1][w], items[i-1][1] + dp[i-1][w-items[i-1][0]]);
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}