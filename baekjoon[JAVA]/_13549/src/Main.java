import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((v1, v2) -> {
            if(v1[1] == v2[1])
                return v1[0] - v2[0];
            return v1[1] - v2[1];
        });

        priorityQueue.add(new int[]{n, 0});
        boolean[] visited = new boolean[100001];

        while(!priorityQueue.isEmpty()) {
            int[] value = priorityQueue.remove();

            int pos = value[0];
            int time = value[1];

            if(pos == k) {
                System.out.println(time);
                break;
            }

            if( pos * 2 <= 100000 && !visited[pos*2]) {
                visited[pos*2] = true;
                priorityQueue.add(new int[]{pos * 2, time});
            }
            if ( pos + 1 <= 100000 && !visited[pos+1]) {
                visited[pos+1] = true;
                priorityQueue.add(new int[]{pos + 1, time + 1});
            }
            if (pos - 1 >= 0 && !visited[pos - 1]) {
                visited[pos-1] = true;
                priorityQueue.add(new int[]{pos - 1, time + 1});
            }
        }
    }
}