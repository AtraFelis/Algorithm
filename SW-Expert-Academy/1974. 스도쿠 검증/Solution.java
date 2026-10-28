import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int[][] board = new int[10][10];
            for (int i = 1; i <= 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= 9; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = 1;
            boolean[] check = new boolean[10];
            // 가로
            for (int i = 1; i <= 9; i++) {
                if (ans == 0)
                    break;

                Arrays.fill(check, false);
                for (int j = 1; j <= 9; j++) {
                    check[board[i][j]] = true;
                }
                for (int j = 1; j <= 9; j++) {
                    if (!check[j]) {
                        ans = 0;
                    }
                }
            }

            // 세로
            for (int i = 1; i <= 9; i++) {
                if (ans == 0)
                    break;

                Arrays.fill(check, false);
                for (int j = 1; j <= 9; j++) {
                    check[board[j][i]] = true;
                }
                for (int j = 1; j <= 9; j++) {
                    if (!check[j]) {
                        ans = 0;
                    }
                }
            }

            // 격자
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Arrays.fill(check, false);
                    for (int x = 1; x <= 3; x++) {
                        for (int y = 1; y <= 3; y++) {
                            check[board[x + i * 3][y + i * 3]] = true;
                        }
                    }
                    for (int j2 = 1; j2 <= 9; j2++) {
                        if (!check[j2]) {
                            ans = 0;
                        }
                    }
                }
            }

            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.println(sb);
    }
}
