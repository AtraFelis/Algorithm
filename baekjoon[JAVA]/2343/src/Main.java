import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] lectures = new int[n];
        st = new StringTokenizer(br.readLine());

        int sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            sum += lectures[i];
            max = Math.max(max, lectures[i]);
        }

        int ans = binarySearch(lectures, max, sum + 1, m);
        System.out.println(ans);
    }

    private static int binarySearch(int[] lectures, int lo, int hi, int m) {
        int mid;
        while(lo < hi) {
            mid = lo + (hi-lo)/2;

            int cnt = 1, total_time = 0;
            for (int i = 0; i < lectures.length; i++) {
                if(total_time + lectures[i] > mid) {
                    cnt++;
                    total_time = 0;
                }
                total_time += lectures[i];

                if(cnt > m)
                    break;
            }

            if(cnt <= m) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }

        return lo;
    }
}