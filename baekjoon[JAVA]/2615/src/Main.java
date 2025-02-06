import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        board = new int[21][21];

        for (int i = 0; i < 21; i++) {
            board[0][i] = board[20][i] = board[i][0] = board[i][20] = 0;
        }

        for (int i = 1; i < 20; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                if (board[i][j] == 1 || board[i][j] == 2) {
                    search(i, j);
                }
            }
        }

        if(sb.isEmpty())
            System.out.println(0);
        else
            System.out.println(sb);
    }

    private static void search(int startX, int startY) {
        int[] dx = {0, 1, 1, 1};
        int[] dy = {1, 1, 0, -1};
        int currentColor = board[startX][startY];

        int cnt;
        boolean flag = true;

        for (int i = 0; i < 4; i++) {
            flag = true;
            cnt = 1;

            // 육목 체크
            if (board[startX + dx[i] * -1][startY + dy[i] * -1] == currentColor) {
                continue;
            }

            int nx = startX + dx[i];
            int ny = startY + dy[i];

            for (int j = 0; j < 4; j++) {
                if(board[nx][ny] != currentColor) {
                    flag = false;
                    break;
                }

                nx += dx[i];
                ny += dy[i];
                cnt++;
            }

            // 육목 체크
            if(cnt == 5 && board[nx][ny] == currentColor) {
                continue;
            }

            if(flag) {
                sb.append(currentColor).append("\n");

                int ansX = startX, ansY = startY;
                for (int j = 0; j < 4; j++) {
                    if(ansY > ansY + dy[i]) {
                        ansX = ansX + dx[i];
                        ansY = ansY + dy[i];
                    } else {
                        break;
                    }
                }

                sb.append(ansX).append(" ").append(ansY);
                break;
            }
        }
    }
}