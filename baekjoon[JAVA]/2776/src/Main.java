import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> memo;
        StringTokenizer stk;

        int T = Integer.parseInt(br.readLine());

        for (int j = 0; j < T; j++) {
            memo = new HashSet<>();

            int N = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                memo.add(Integer.parseInt(stk.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                sb.append(memo.contains(Integer.parseInt(stk.nextToken())) ? 1 : 0).append('\n');
            }
        }

        System.out.println(sb);
    }
}