import java.io.*;
import java.util.*;

public class Main {

    static long mul(long n) {
        return n*2L;
    }
    static long add_right(long n) {
        return n * 10L + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        long A = Integer.parseInt(stk.nextToken());
        long B = Integer.parseInt(stk.nextToken());

        Deque<Long[]> deque = new ArrayDeque<>();
        Long[] value = { A, 1L };
        deque.add(value);

        Map<Long, Boolean> visited = new HashMap<>();

        while(!deque.isEmpty()) {
            value = deque.removeFirst();

            if(value[0] == B) {
                System.out.println(value[1]);
                return;
            }

            Long[] next_value;

            long res;
            if((res = mul(value[0])) <= B && !visited.getOrDefault(res, false)) {
                next_value = new Long[]{res, value[1] + 1};
                deque.add(next_value);
                visited.put(res, true);
            }

            if((res = add_right(value[0])) <= B && !visited.getOrDefault(res, false)) {
                next_value = new Long[]{res, value[1] + 1};
                deque.add(next_value);
                visited.put(res, true);
            }
        }

        System.out.println(-1);
    }
}