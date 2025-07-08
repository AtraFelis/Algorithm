import java.io.*;
import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;

    private static boolean[] visited;
    private static int n, m, x;

    private static class Edge {
        int dest;
        int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    private static class Node {
        int vertex;
        int time;

        public Node(int vertex, int time) {
            this.vertex = vertex;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        x = Integer.parseInt(stk.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        List<List<Edge>> reverseGraph = new ArrayList<>();

        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int time = Integer.parseInt(stk.nextToken());

            graph.get(start).add(new Edge(end, time));
            reverseGraph.get(end).add(new Edge(start, time));
        }

        // 가는길(역방향 그래프) : forward
        int[] forward = dijkstra(x, reverseGraph);

        // 돌아오는길(정방향 그래프)
        Arrays.fill(visited, false);
        int[] backward = dijkstra(x, graph);

        int answer = 0;
        for (int i = 1; i < n+1; i++) {
            int dist = forward[i] + backward[i];
            answer = answer > dist ? answer : dist;
        }

        System.out.println(answer);
    }

    private static int[] dijkstra(int startVertex, List<List<Edge>> graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.time - n2.time);
        pq.add(new Node(startVertex, 0));

        int[] distances = new int[n+1];
        Arrays.fill(distances, INF);
        distances[startVertex] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            if(visited[curNode.vertex])
                continue;
            
            visited[curNode.vertex] = true;
            
            for (Edge edge : graph.get(curNode.vertex)) {
                if(!visited[edge.dest]) {
                    distances[edge.dest] =
                        distances[edge.dest] < distances[curNode.vertex] + edge.weight ?
                        distances[edge.dest] : distances[curNode.vertex] + edge.weight;
                    
                    pq.offer(new Node(edge.dest, distances[edge.dest]));
                }
            }
        }

        return distances;
    }
}