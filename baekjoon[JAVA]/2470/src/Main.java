import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] solution = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(solution);

        int ans1=0, ans2=0;
        int min_density = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            int value = binarySearch(solution, i);

            int current_density = Math.abs(solution[value] + solution[i]);
            if(current_density < min_density) {
                min_density = current_density;
                ans1 = i;
                ans2 = value;
            }
            if(current_density == 0) {
                break;
            }
        }

        System.out.println(solution[ans1] + " " + solution[ans2]);
    }

    private static int binarySearch(int[] solution, int idx) {
        int lo = idx+1;
        int hi = solution.length;
        int current_density;
        int min_density = Integer.MAX_VALUE;
        int min_density_idx = -1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            current_density = solution[idx] + solution[mid];

            if (Math.abs(current_density) < Math.abs(min_density)) {
                min_density = current_density;
                min_density_idx = mid;
            }

            if(current_density < 0) {
                lo = mid+1;
            } else if(current_density > 0) {
                hi = mid;
            } else {
                return min_density_idx;
            }
        }
        return min_density_idx;
    }
}