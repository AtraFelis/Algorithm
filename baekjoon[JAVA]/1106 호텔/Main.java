import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        int C = Integer.parseInt(stk.nextToken());
        int N = Integer.parseInt(stk.nextToken());

        int[] cost = new int[N];
        int[] customer = new int[N];

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());

            cost[i] = Integer.parseInt(stk.nextToken());
            customer[i] = Integer.parseInt(stk.nextToken());
        }

        int[] dp = new int[C+101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i <= C; i++) {
            if(dp[i] == Integer.MAX_VALUE) continue;
                        
            for (int j = 0; j < N; j++) {
                dp[i + customer[j]] = Math.min(dp[i] + cost[j], dp[i + customer[j]]);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = C; i < C + 101; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);
    }
}