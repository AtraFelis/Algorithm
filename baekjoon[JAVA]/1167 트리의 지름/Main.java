import java.util.*;
import java.io.*;

public class Main {
    private static List<List<Node>> tree;
    private static boolean[] visited;
    private static Node maxNode = new Node(0, 0);

    // 노드와 거리 정보를 담는 클래스
    static class Node {
        int vertex;
        int dist; // 부모 노드와의 거리
        
        Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int v = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            tree.add(new ArrayList<>());
        }

        visited = new boolean[v+1];
        
        for (int i = 0; i < v; i++) {
            stk = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(stk.nextToken());
            
            while(true) {
                int connectedNode = Integer.parseInt(stk.nextToken());
                if(connectedNode == -1) break;
                int dist = Integer.parseInt(stk.nextToken());
                tree.get(node).add(new Node(connectedNode, dist));
            }
        }
        
        visited[1] = true;
        dfs(1, 0); // 임의의 노드에서 가장 거리가 먼 노드 찾기 (이게 가장 긴 지름은 아님)

        Arrays.fill(visited, false);

        visited[maxNode.vertex] = true;
        dfs(maxNode.vertex, 0); // 임의의 노드로부터 가장 먼 거리의 노드를 루트로 dfs -> 여기서 구해진 지름이 가장 긴 지름

        System.out.println(maxNode.dist);
    }

    private static void dfs(int vertex, int dist) {
        for (Node child : tree.get(vertex)) {
            if(!visited[child.vertex]) {
                visited[child.vertex] = true;
                dfs(child.vertex, dist + child.dist);
            }
        }

        if(maxNode.dist < dist) {
            maxNode = new Node(vertex, dist);
        }
    }
}