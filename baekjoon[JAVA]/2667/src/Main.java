import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] matrix;
    static int n;
    static int area = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> matrix_cnt = new ArrayList<Integer>();

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = str.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && matrix[i][j] == 1) {
                    area = 0;
                    cnt++;
//                    dfs(i, j);
                    bfs(i, j);
                    matrix_cnt.add(area);
                }
            }
        }

        Collections.sort(matrix_cnt);
        sb.append(cnt).append("\n");
        for (Integer i : matrix_cnt) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        area++;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;
            if(visited[nx][ny])
                continue;

            if (matrix[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            x = pos[0];
            y = pos[1];
            area++;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if (visited[nx][ny])
                    continue;

                if (matrix[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}