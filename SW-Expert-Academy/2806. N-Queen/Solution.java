/**
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static int[][] board;
    private static int n;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 정답이 성립하려면 각 행당 반드시 1개의 퀸이 들어가야함
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            sb.append('#').append(tc).append(' ');

            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            ans = 0;

            dfs(0);

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (canAttack(depth, i))
                continue;

            board[depth][i] = 1;
            dfs(depth + 1);
            board[depth][i] = 0;
        }
    }

    private static final int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 행
    private static final int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 }; // 열

    private static boolean canAttack(int r, int c) {
        if (board[r][c] == 1)
            return true;

        for (int i = 0; i < 8; i++) {
            for (int k = 1; k <= n; k++) {
                int nr = r + dr[i] * k;
                int nc = c + dc[i] * k;

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                    break;
                }

                if (board[nr][nc] == 1)
                    return true;

            }
        }
        return false;
    }
}
