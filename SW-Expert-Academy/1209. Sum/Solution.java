import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[101][101];
            for (int i = 1; i <= 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] prefix = new int[101][101];
            for (int i = 1; i <= 100; i++) {
                for (int j = 1; j <= 100; j++) {
                    prefix[i][j] = arr[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
                }
            }

            int ans = 0;
            for (int i = 1; i <= 100; i++) {
                ans = Math.max(prefix[100][i] - prefix[100][i - 1], ans);
                ans = Math.max(prefix[i][100] - prefix[i - 1][100], ans);
            }

            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += arr[i][i];
            }
            ans = Math.max(sum, ans);

            sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += arr[101 - i][i];
            }
            ans = Math.max(sum, ans);

            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.println(sb);
    }
}
