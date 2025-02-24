import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] map = new int[N];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(stk.nextToken());
        }

        int check = 9 * M / 10;
        check = 9 * M % 10 == 0 ? check : check + 1;

        boolean resultFlag = false;
        Map<Integer, Integer> window = new HashMap<>();
        for (int j = 0; j < M; j++) {
            window.put(map[j], 1 + window.getOrDefault(map[j], 0));

            if(window.get(map[j]) >= check)
                resultFlag = true;
        }

        for (int i = 1; i <= N - M; i++) {
            window.put(map[i-1], window.get(map[i-1]) - 1);
            window.put(map[i + M - 1], 1 + window.getOrDefault(map[i + M - 1], 0));

            if(window.get(map[i + M - 1]) >= check) {
                resultFlag = true;
                break;
            }
        }

        System.out.println(resultFlag ? "YES" : "NO");
    }
}