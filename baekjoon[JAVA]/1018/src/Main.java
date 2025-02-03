import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Character[][] board;
    static int ans = 32;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        board = new Character[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                solution2(i, j);
            }
        }

        System.out.println(ans);
    }

    private static void solution(int startX, int startY) {
        // 현재 위치에서 오른쪽과 아래쪽만 확인하면 됨.
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        int result = 0;

        // board 깊은 복사
        int[][] copyBoard = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8 ; j++) {
                copyBoard[i][j] = board[startX + i][startY + j] == 'W' ? 1 : -1;
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                for (int k = 0; k < 2; k++) {
                    int nextX = i + dx[k];
                    int nextY = j + dy[k];

                    if (nextX >= 8 || nextY >= 8) {
                        continue;
                    }

                    if(copyBoard[i][j] == copyBoard[nextX][nextY]) {
                        result++;
                        copyBoard[nextX][nextY] = copyBoard[i][j] * -1;
                    }
                }

            }
        }

        // 32개를 초과하여 뒤집는 경우는 시작점을 W -> B 혹은 B -> W로 바꾸는 것이 최솟값을 보장함.
        if (result > 32)
            result = 64 - result;
        ans = Math.min(ans, result);
    }

    private static void solution2(int startX, int startY) {
        // 현재 위치에서 오른쪽과 아래쪽만 확인하면 됨.
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        int result1 = 0, result2 = 0;

        // board 깊은 복사
        int[][] copyBoard = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8 ; j++) {
                copyBoard[i][j] = board[startX + i][startY + j] == 'W' ? 1 : -1;
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                for (int k = 0; k < 2; k++) {
                    int nextX = i + dx[k];
                    int nextY = j + dy[k];

                    if (nextX >= 8 || nextY >= 8) {
                        continue;
                    }

                    if(copyBoard[i][j] == copyBoard[nextX][nextY]) {
                        result1++;
                        copyBoard[nextX][nextY] = copyBoard[i][j] * -1;
                    }
                }

            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8 ; j++) {
                copyBoard[i][j] = board[startX + i][startY + j] == 'W' ? 1 : -1;
            }
        }

        copyBoard[0][0] *= -1; // 시작 지점의 색을 바꾼 후 탐색
        result2++;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 2; k++) {
                    int nextX = i + dx[k];
                    int nextY = j + dy[k];

                    if (nextX >= 8 || nextY >= 8) {
                        continue;
                    }

                    if(copyBoard[i][j] == copyBoard[nextX][nextY]) {
                        result2++;
                        copyBoard[nextX][nextY] = copyBoard[i][j] * -1;
                    }
                }

            }
        }


        int result = Math.min(result1, result2);
        ans = Math.min(ans, result);
    }
}