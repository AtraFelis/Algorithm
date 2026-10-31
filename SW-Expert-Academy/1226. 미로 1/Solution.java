import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static Pos start, dest;

    private static int[][] map = new int[16][16];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {

            Integer.parseInt(br.readLine());

            for (int i = 0; i < 16; i++) {
                char[] arr = br.readLine().toCharArray();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = arr[j] - '0';

                    if (map[i][j] == 2)
                        start = new Pos(i, j);

                    if (map[i][j] == 3)
                        dest = new Pos(i, j);
                }
            }

            // for (int i = 0; i < 16; i++) {
            // System.out.println(Arrays.toString(map[i]));
            // }

            sb.append('#').append(tc).append(' ');
            if (bfs()) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static boolean bfs() {
        Queue<Pos> q = new LinkedList<>();
        q.add(start);

        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };
        boolean[][] visited = new boolean[16][16];

        while (!q.isEmpty()) {
            Pos cur = q.remove();

            if (cur.r == dest.r && cur.c == dest.c) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nr >= 16 || nc < 0 || nc >= 16)
                    continue;

                if (visited[nr][nc] || map[nr][nc] == 1)
                    continue;

                visited[nr][nc] = true;

                q.add(new Pos(nr, nc));
            }
        }

        return false;
    }
}
