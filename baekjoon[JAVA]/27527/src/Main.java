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

        int check = (9 * M + 9) / 10;

        boolean resultFlag = false;
        Map<Integer, Integer> window = new HashMap<>();

/*      // HashMap 사용
        for (int i = 0; i < N; i++) {
            window.put(map[i], 1 + window.getOrDefault(map[i], 0));

            if(i >= M) window.put(map[i - M], window.get(map[i - M]) - 1);

            if(window.get(map[i]) >= check) {
                resultFlag = true;
                break;
            }
        }
*/

        int[] numCnt = new int[1000001];

        for (int i = 0; i < N; i++) {
            numCnt[map[i]]++;

            if(i >= M) numCnt[map[i - M]]--;

            if(numCnt[map[i]] == check) {
                resultFlag = true;
                break;
            }
        }


        System.out.println(resultFlag ? "YES" : "NO");
    }
}