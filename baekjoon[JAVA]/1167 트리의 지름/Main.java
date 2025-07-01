import java.util.*;
import java.io.*;

public class Main {
    
    private static List<List<Node>> tree;
    private static boolean[] visited;

    // 노드와 거리 정보를 담는 클래스
    static class Node {
        int vertex;
        int dist;
        
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

        // 1번 노드를 루트로 두고 탐색
        checkDiameter(1, 1, 0);

        int answer = 0;
        for (int i = 1; i <= v; i++) {
            for (int j = i; j <= v; j++) {
                answer = Math.max(answer, tree[i][j]);
            }
        }

        System.out.println(answer);
    }

    // dfs로 노드별로 탐색
    private static void checkDiameter(int root, int prevNode, int prevDist) {
        for (Node child : tree.get(prevNode)) {
            if(!visited[child.vertex]) {
                visited[child.vertex] = true;
                checkDiameter(root, child.vertex, prevDist + child.dist);
            }
            
        }
    }
}