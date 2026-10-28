import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {

    private static class Pos {
        int x;
        int y;
        int weight;

        public Pos(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Pos [x=" + x + ", y=" + y + ", weight=" + weight + "]";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            sb.append('#').append(tc).append(' ');
            int n = Integer.parseInt(br.readLine());

            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                char[] arr = br.readLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    map[i][j] = arr[j] - '0';
                }
            }

            int ans = bfs(map, n);
            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }

    private static int bfs(int[][] map, int n) {
        PriorityQueue<Pos> pq = new PriorityQueue<>((p1, p2) -> p1.weight - p2.weight);
        pq.add(new Pos(0, 0, 0));

        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        boolean[][] visited = new boolean[n][n];

        while (!pq.isEmpty()) {
            Pos currPos = pq.remove();
            // System.out.println(currPos);

            visited[currPos.x][currPos.y] = true;

            if (currPos.x == n - 1 && currPos.y == n - 1) {
                return currPos.weight;
            }

            for (int i = 0; i < 4; i++) {
                int nx = currPos.x + dx[i];
                int ny = currPos.y + dy[i];

                if (nx >= n || ny >= n || nx < 0 || ny < 0 || visited[nx][ny])
                    continue;

                int nextWeight = currPos.weight + map[nx][ny];
                pq.add(new Pos(nx, ny, nextWeight));
            }
        }

        return -1;
    }
}
