import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = Integer.MAX_VALUE;
    private static int[] dist;
    private static boolean[] visited;

    private static class Edge {
        private int dest;
        private int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    private static class Node implements Comparable{
        private int vertex;
        private int path;

        public Node(int vertex, int path) {
            this.vertex = vertex;
            this.path = path;
        }

        @Override
        public int compareTo(Object o) {
            return this.path - ((Node)o).path;
        }
    }

    private static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(stk.nextToken());
        int E = Integer.parseInt(stk.nextToken());
        int startVertex = Integer.parseInt(br.readLine());

        dist = new int[V+1];
        for (int i = 0; i <= V; i++) {
            dist[i] = INF;
        }

        visited = new boolean[V+1];

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());

            graph.get(u).add(new Edge(v, w));
        }

        dikjstra(startVertex);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < V+1; i++) {
            if(dist[i] != INF)
                sb.append(dist[i]).append('\n');
            else
                sb.append("INF\n");
        }

        System.out.println(sb);
    }
    
    private static void dikjstra(int startVertex) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startVertex, 0));
        dist[startVertex] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            
            if(visited[curNode.vertex])
                continue;

            visited[curNode.vertex] = true;
            
            for (Edge edge : graph.get(curNode.vertex)) {
                if(!visited[edge.dest]) {
                    dist[edge.dest] = Math.min(dist[edge.dest], dist[curNode.vertex] + edge.weight);
                    pq.add(new Node(edge.dest, dist[edge.dest]));
                }
            }
        }
    }
}