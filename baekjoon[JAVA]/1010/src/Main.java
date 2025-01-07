import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // Top-Down
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 30; i++) {
            dp[i][i] = dp[i][0] = 1;
            dp[i][1] = i;
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            sb.append(combination(m, n)).append('\n');
        }

        System.out.println(sb);
    }


    private static int combination(int m, int n) {
        // 탐색 종료
        if(dp[m][n] != 0)
            return dp[m][n];

        return dp[m][n] = combination(m-1, n) + combination(m-1,n - 1);
    }

    // Bottom-Up
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[30][30];

        for (int i = 0; i < 30; i++) {
            dp[i][i] = dp[i][0] = 1;
            dp[i][1] = i;
        }

        for (int j = 2; j < 30; j++) {
            for (int k = 1; k <= j; k++) {
                dp[j][k] = dp[j - 1][k] + dp[j - 1][k - 1];
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            sb.append(dp[m][n]).append("\n");
        }

        System.out.println(sb);
    }*/
}