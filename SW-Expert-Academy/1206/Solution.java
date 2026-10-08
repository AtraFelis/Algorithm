import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static int[] map;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            init();

            // 좌우 2개 건물(총 4개)의 높이가 자신의 높이보다 작은지 확인.
            // 만약 이에 해당한다면, 현재 건물 높이 - 그 4개중 가장 높은 건물이 조망권 확보된 가구
            int ans = 0;
            for (int j = 2; j < n + 2; j++) {
                if (map[j] > map[j - 2] && map[j] > map[j - 1] && map[j] > map[j + 1] && map[j] > map[j + 2]) {
                    int max_h = 0;
                    max_h = Math.max(max_h, map[j - 2]);
                    max_h = Math.max(max_h, map[j - 1]);
                    max_h = Math.max(max_h, map[j + 1]);
                    max_h = Math.max(max_h, map[j + 2]);

                    ans += map[j] - max_h;
                }
            }

            sb.append("#").append(i + 1).append(" ").append(ans).append('\n');
        }

        System.out.println(sb);
    }

    public static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n + 4];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 2; i < n + 2; i++) {
            map[i] = Integer.parseInt(stk.nextToken());
        }
    }
}