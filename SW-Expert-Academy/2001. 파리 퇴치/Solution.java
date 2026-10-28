import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] area = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    area[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append('#').append(tc).append(' ').append(solution(area, m)).append('\n');
        }

        System.out.println(sb);
    }

    private static int solution(int[][] area, int m) {
        int n = area.length;
        int[][] prefix = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = area[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        int ans = 0;
        for (int i = m; i <= n; i++) {
            for (int j = m; j <= n; j++) {
                ans = Math.max(ans, prefix[i][j] - prefix[i - m][j] - prefix[i][j - m] + prefix[i - m][j - m]);
            }
        }

        return ans;
    }

    // public static void main(String[] args) throws IOException {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st;
    // StringBuilder sb = new StringBuilder();

    // int T = Integer.parseInt(br.readLine());
    // for (int tc = 1; tc <= T; tc++) {
    // st = new StringTokenizer(br.readLine());
    // int n = Integer.parseInt(st.nextToken());
    // int m = Integer.parseInt(st.nextToken());

    // int[][] area = new int[n][n];
    // for (int i = 0; i < n; i++) {
    // st = new StringTokenizer(br.readLine());
    // for (int j = 0; j < n; j++) {
    // area[i][j] = Integer.parseInt(st.nextToken());
    // }
    // }

    // sb.append('#').append(tc).append(' ').append(solution(area, m)).append('\n');
    // }

    // System.out.println(sb);
    // }

    // private static int solution(int[][] area, int m) {
    // int ans = 0;
    // for (int i = 0; i < area.length - m + 1; i++) {
    // for (int j = 0; j < area.length - m + 1; j++) {
    // int sum = 0;
    // for (int x = i; x < i + m; x++) {
    // for (int y = j; y < j + m; y++) {
    // sum += area[x][y];
    // }
    // }
    // ans = Math.max(ans, sum);
    // }
    // }

    // return ans;
    // }
}
