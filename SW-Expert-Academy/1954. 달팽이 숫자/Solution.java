import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append("#").append(i + 1).append('\n');
            makeSnail(n);
        }

        System.out.println(sb);
    }

    public static void makeSnail(int n) {
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int[][] snail = new int[n][n];
        int currNum = 1;

        int dir = 0;
        int x = 0, y = 0;
        while (currNum <= n * n) {
            // 벽에 막힐 때마다 오른쪽으로 회전
            snail[y][x] = currNum++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= n || nx < 0 || ny < 0 || ny >= n || snail[ny][nx] != 0) {
                dir = (dir + 1) % 4;
            }
            x += dx[dir];
            y += dy[dir];
        }

        for (int[] row : snail) {
            for (int num : row) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
        }
    }
}
