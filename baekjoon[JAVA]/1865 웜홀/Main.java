import java.util.*;
import java.io.*;

public class Main {
    private static class Edge {
        int source;
        int dest;
        int weight;

        private Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    private static int distances[];
    private static List<Edge> graph;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stk;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException{

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            init();
            bellmanFord();
        }

        System.out.println(answer);
    }

    private static void bellmanFord() {
        int n = distances.length;

        for (int i = 0; i < n-1; i++) {
            for (Edge edge : graph) {
                if(distances[edge.source] != Integer.MAX_VALUE) {
                    distances[edge.dest] = Math.min(distances[edge.dest], distances[edge.source] + edge.weight);
                }
            }
        }

        // 음의 사이클 존재 여부 검사
        boolean hasNegativeCycle = false;
        for (Edge edge : graph) {
            if(distances[edge.source] != Integer.MAX_VALUE) {
                if(distances[edge.dest] > distances[edge.source] + edge.weight) {
                    hasNegativeCycle = true;
                    break;
                }
            }
        }

        // 음의 사이클이 하나라도 존재한다면
        // 임의의 출발점을 기준으로 복귀했을 때 시간이 줄어드는 것이 반드시 가능
        answer.append(hasNegativeCycle ? "YES\n" : "NO\n" );
    }

    private static void init() throws IOException{
        stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int w = Integer.parseInt(stk.nextToken());

        graph = new ArrayList<>();

        for (int j = 0; j < m; j++) {
            stk = new StringTokenizer(br.readLine());

            int source = Integer.parseInt(stk.nextToken());
            int dest = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());

            graph.add(new Edge(source, dest, weight));
            graph.add(new Edge(dest, source, weight));
        }

        for (int j = 0; j < w; j++) {
            stk = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(stk.nextToken());
            int dest = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());

            graph.add(new Edge(start, dest, weight * -1));
        }

        distances = new int[n+1]; // 1번부터 시작
        for (int i = 0; i < n+1; i++) {
            distances[i] = 0;
            // 어떤 노드든 출발점이 될 수 있으며,
            // 이 문제에서 중요한 것은 최단 거리가 아니므로 0으로 초기화하여
            // 모든 노드를 검사해야함.
            // Integer.MAX_VALUE와 같이 초기화를 진행할 경우, 임의의 출발점과 연결되지 않은
            // 다른 노드들로만 이루어진 그래프에 대해서는 검사를 진행할 수 없음
            // 즉, 그래프가 2개가 등장할 경우에 예외가 발생할 수 있음.
        }
    }
}
