import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static StringBuilder dfs_sb = new StringBuilder();
    static StringBuilder bfs_sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        boolean[][] mat = new boolean[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            mat[p1][p2] = mat[p2][p1] = true;
        }

        visited = new boolean[n+1];
        DFS(mat, v);
        System.out.println(dfs_sb);

        visited = new boolean[n+1];
        BFS(mat,v);
        System.out.println(bfs_sb);

    }

    static void DFS(boolean[][] mat, int v) {
        visited[v] = true;
        dfs_sb.append(v).append(" ");
        for (int i = 0; i < mat[v].length; i++) {
            if(mat[v][i] && !visited[i])
                DFS(mat, i);
        }
    }

    static void BFS(boolean[][] mat, int v) {
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.add(v);

        int len = mat[v].length;

        while (!q.isEmpty()) {
            int curNode = q.poll();

            bfs_sb.append(curNode).append(" ");
            for (int i = 0; i < len; i++) {
                if (mat[curNode][i] && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}