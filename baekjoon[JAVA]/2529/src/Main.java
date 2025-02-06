import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String maxLong = "0";
    static String minLong = String.valueOf(Long.MAX_VALUE);
    static Character[] symbols;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        k = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());

        symbols = new Character[k];
        for (int i = 0; i < k; i++) {
            symbols[i] = stk.nextToken().charAt(0);
        }

        backtracking(sb);

        System.out.println(maxLong);
        System.out.println(minLong);
    }

    static boolean[] visited = new boolean[10];
    private static void backtracking(StringBuilder sb) {
        if (sb.length() == k+1) {
            String num = sb.toString();
            if (Long.parseLong(maxLong) < Long.parseLong(num)) {
                maxLong = num;
            }
            if (Long.parseLong(minLong) > Long.parseLong(num)) {
                minLong = num;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;

            // 첫 숫자이거나, 부등호 조건이 만족되면
            if (sb.isEmpty() || isValid(sb, i)) {
                visited[i] = true;
                sb.append(i);
                backtracking(sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    private static boolean isValid(StringBuilder sb, int i) {
        int idx = sb.length() - 1;
        char sign = symbols[idx];
        int prev = sb.charAt(idx) - '0';
        return sign == '<' ? prev < i : prev > i;
    }
}