import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackTracking {
    static int answer = Integer.MAX_VALUE;
    static int n, m;
    static int[] lectures;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        lectures = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(stk.nextToken());
        }

        arr = new int[m];
        backTracking(0, 0);
        System.out.println(answer);
    }

    static void backTracking(int depth, int len_chk) {
        if (depth == m) {
            if (len_chk == n) {
                int idx = 0, max = 0, tmp = 0;
                for (int i = 0; i < m; i++) {
                    tmp = 0;
                    for (int j = idx; j < arr[i] + idx; j++) {
                        tmp += lectures[j];
                    }
                    max = Math.max(max, tmp);
                    idx += arr[i];
                }
                answer = Math.min(answer, max);
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (len_chk + i > n) continue; // 가지치기
            arr[depth] = i; // 현재 블루레이 길이 저장
            backTracking(depth + 1, len_chk + i);
        }
    }
}