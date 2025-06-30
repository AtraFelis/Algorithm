import java.util.*;
import java.io.*;

public class Main {
    
    private static int[][] tree;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int v = Integer.parseInt(br.readLine());
        tree = new int[v+1][v+1];
        visited = new boolean[v+1][v+1];

        for (int[] nodes : tree) {
            Arrays.fill(nodes, -1);
        }

        // 자기 자신과의 거리는 0
        for (int i = 1; i <= v; i++) {
            tree[i][i] = 0;
            visited[i][i] = true;
        }
        
        for (int i = 0; i < v; i++) {
            stk = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(stk.nextToken());
            
            while(true) {
                int connectedNode = Integer.parseInt(stk.nextToken());
                if(connectedNode == -1) break;
                int dist = Integer.parseInt(stk.nextToken());
                
                tree[node][connectedNode] = dist;
            }
        }

        checkDiameter(1, 1, 0); // 1번 노드를 루트로 두고 탐색

        int answer = 0;
        for (int i = 1; i <= v; i++) {
            for (int j = i; j <= v; j++) {
                answer = Math.max(answer, tree[i][j]);
            }
        }

        System.out.println(answer);
    }

    private static void checkDiameter(int root, int prevNode, int prevDist) { // dfs로 노드별로 탐색
        for (int i = 1; i < tree.length; i++) {
            if(!visited[prevNode][i] && canGo(tree[prevNode][i])) {
                visited[prevNode][i] = true;
                visited[i][prevNode] = true;
                checkDiameter(root, i, prevDist + tree[prevNode][i]);
            }
            
            tree[root][prevNode] = tree[root][prevNode] == -1 ?
                   prevDist : Math.min(prevDist, tree[root][prevNode]);
            tree[prevNode][root] = tree[root][prevNode];
        }
    }

    private static boolean canGo(int value) {
        return value != -1 && value != 0;
    }
}