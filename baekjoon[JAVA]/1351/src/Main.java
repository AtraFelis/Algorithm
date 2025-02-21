import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Long, Long> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        Long n = Long.parseLong(stk.nextToken());
        Long p = Long.parseLong(stk.nextToken());
        Long q = Long.parseLong(stk.nextToken());


        // N 크기의 DP 배열 선언은 0 <= N <= 10^12 조건 때문에 불가능
        // HashMap<idx, value>로 해결
        dp.put(0L, 1L);

        // top-down 방식
        solution(n, p, q);
        System.out.println(dp.get(n));
    }

    private static void solution(Long N, Long P, Long Q) {
        if(dp.containsKey(N)) {
            return;
        }

        solution(N/P, P, Q);
        solution(N/Q, P, Q);
        dp.put(N, dp.get(N/P) + dp.get(N/Q));
    }
}