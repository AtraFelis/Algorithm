import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    static int[][] mat;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        mat = new int[n][m];
        for(int i=0; i < n; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j =0 ; j < m; j++) {
                mat[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        cnt = 0;
        int ans = -1; // 첫 번째 탐색은 0년이므로 -1로 시작. 반복 들어간 후부터 0년.
        while(cnt < 2) {
            cnt = 0;
            ans++;
            visited = new boolean[n][m];
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if(mat[i][j] != 0 && !visited[i][j]) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }

            if(cnt==0) {
                ans = 0;
                break;
            }
        }

        System.out.println(ans);
    }

    private static void bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            x = tmp[0];
            y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(mat[nx][ny] == 0) {
                    // 빙산 업데이트는 탐색이 종료된 후 일괄적으로 반영되어야 함.
                    // 빙산이 없지만, 방문 표시가 되어 있을 경우 ->
                    // 이번 탐색에 녹은 것이므로 무시한다.
                    if(!visited[nx][ny]) {
                        mat[x][y]--;
                    }
                    mat[x][y]  = Math.max(mat[x][y], 0);
                    continue;
                }

                if(mat[nx][ny] != 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}