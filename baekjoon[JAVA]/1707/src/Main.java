import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            if(V == 1) {
                sb.append("YES").append("\n");
                continue;
            }

            graph = new ArrayList<>();
            for (int j = 0; j < V + 1; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());

                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }

            sb.append(bfs() ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }

    static boolean bfs() {

        Queue<Integer> q;
        int[] visited = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            // 이미 방문한 노드라면 무시
            if (visited[i] != 0)
                continue;

            q = new LinkedList<>();
            q.add(i);

            visited[i] = 1;

            // BFS
            while (!q.isEmpty()) {
                int node = q.poll();
                for (Integer next_node : graph.get(node)) {
                    // 방문하지 않은 정점이면
                    if (visited[next_node] == 0) {
                        // 방문 체크 및 색 체크
                        visited[next_node] = visited[node]*-1;
                        q.add(next_node);
                    }
                    // 이분 그래프가 아니라면 (인접한 노드의 색과 자신으 색이 같다면)
                    else if (visited[next_node] == visited[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}