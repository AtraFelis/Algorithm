import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] dp;

        for (int i = 0; i < n; i++) {
            dp = new int[26];

            String str = br.readLine();
            boolean flag = true;

            char preChar = '-';
            for (char c :
                    str.toCharArray()) {
                int idx = c - 'a';
                if(dp[idx] == 0) dp[idx] += 1;
                else if (preChar != c && dp[idx] != 0) {
                    flag = false;
                    break;
                }
                preChar = c;
            }

            if(flag)
                answer++;
        }

        System.out.println(answer);
    }
}