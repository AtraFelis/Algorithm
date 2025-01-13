import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
/*
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
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        int[] memo;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            memo = new int[n];
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                memo[j] = Integer.parseInt(stk.nextToken());
            }

            Arrays.sort(memo);

            int m = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if (binarySearch(memo, Integer.parseInt(stk.nextToken()))) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
        }
        System.out.println(sb);
    }

    private static boolean binarySearch(int[] memo, int num) {
        int min = 0;
        int max = memo.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;

            if(memo[mid] == num) {
                return true;
            }
            if (memo[mid] < num) {
                min = mid + 1;
            }
            if (memo[mid] > num) {
                max = mid - 1;
            }
        }
        return false;
    }
}