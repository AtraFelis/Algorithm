import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dijkstra;
    static boolean[] visited;
    static int n, m;
    static final int INF = Integer.MAX_VALUE / 2;

    static void setDijkstra (int start) {
        int node = start;
        for (int j = 0; j < n-1; j++) {
            for (int i = 1; i < n+1; i++) {
                if(!visited[i]) {
                    dijkstra[i] = Integer.min(dijkstra[node] + map[node][i], dijkstra[i]);
                }
            }

            int min_value = INF;
            for (int i = 1; i < n+1; i++) {
                if(!visited[i] && min_value > dijkstra[i]) {
                    min_value = dijkstra[i];
                    node = i;
                }
            }
            visited[node] = true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(i == j)
                    map[i][j] = 0;
                else
                    map[i][j] = INF;
            }
        }
        dijkstra = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            dijkstra[i] = INF;
        }
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(stk.nextToken());
            int node2 = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());

            map[node1][node2] = Integer.min(weight, map[node1][node2]);
            // 여러 개의 간선이 존재할 수 있음. (근데 이건 문제에 명시를 해줘야 되는 거 아닌가. 예시로 힌트라도 주던가..)
        }

        stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int dest = Integer.parseInt(stk.nextToken());

        visited[start] = true;
        dijkstra[start] = 0;

        setDijkstra(start);

        System.out.println(dijkstra[dest]);
    }
}