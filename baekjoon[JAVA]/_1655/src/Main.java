import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min_pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            max_pq.add(num);
            min_pq.add(max_pq.poll());

            if (max_pq.size() < min_pq.size()) {
                max_pq.add(min_pq.poll());
            }

            System.out.println(max_pq.peek());
        }
    }
}