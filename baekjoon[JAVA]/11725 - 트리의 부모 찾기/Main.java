import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());

        ArrayList< LinkedList<Integer> > graph = new ArrayList<>();
        // ArrayList 와 LinkedList가 값을 접근하는 방법에 대해 자세히 알아보면 된다.
        // LinkedList는 값을 찾아갈 때, 0번부터 차례대로 전부 탐색해야 하지만, ArrayList는 한 번에 찾아갈 수 있다.
        // 이 때문에 graph의 바깥 List를 LinkedList로 하면 시간초과가 나타나는 것.
        for (int i = 0; i < n+1; i++) {
            graph.add(new LinkedList<>());
        }

        int[] parent = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n-1; i++) {
            stk = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(stk.nextToken());
            int node2 = Integer.parseInt(stk.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        // 그래프를 순회할 때, 자신과 연결된 노드 중 1과 연결된 노드가 부모 노드가 된다.
        queue.add(1);
        parent[1] = 1;

        while(!queue.isEmpty()) {
            int node = queue.remove();
            for (int value : graph.get(node)) {
                if (parent[value] == 0) {
                    parent[value] = node;
                    queue.add(value);
                }
            }
//            graph.get(node).forEach(value -> {
//                if(parent[value] == 0) {
//                    parent[value] = node;
//                    queue.add(value);
//                }
//            });
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 2; i <= n; i++)
            bw.write(parent[i] + "\n");

        bw.flush();
        bw.close();

        //Arrays.stream(Arrays.copyOfRange(parent, 2, n+1)).forEach(System.out::println);
    }
}