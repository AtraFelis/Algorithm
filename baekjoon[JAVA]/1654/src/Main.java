import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int k = Integer.valueOf(stk.nextToken());
        int n = Integer.valueOf(stk.nextToken());

        int[] cable = new int[k];
        int max = 0;
        for (int i = 0; i < k; i++) {
            cable[i] = Integer.valueOf(br.readLine());
            max = Math.max(max, cable[i]);
        }

        long ans = binarySearch(cable, max, n);
        System.out.println(ans);
    }

    private static long binarySearch(int[] cable, long max,int n) {
        long min = 1;
        max+=1;
        while (min < max-1) {
            long mid = (min + max) / 2;

            int cnt = 0;
            for (int i = 0; i < cable.length; i++) {
                cnt += cable[i] / mid;
            }

            if (cnt >= n) {
                min = mid;
            } else if (cnt < n) {
                max = mid;
            }
        }
        return min;
    }
}