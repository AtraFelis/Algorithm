import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] solution = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(solution);

        int[] ans = twoPointerSearch(solution);
        System.out.println(solution[ans[0]] + " " + solution[ans[1]]);
    }

    private static int[] twoPointerSearch(int[] solution) {
        int left = 0, right = solution.length-1;
        int min_density = Integer.MAX_VALUE;
        int[] ans = {left, right};

        while (left < right) {
            int current_density = solution[left] + solution[right];
            if(Math.abs(current_density) < Math.abs(min_density)) {
                min_density = current_density;
                ans[0] = left;
                ans[1] = right;
            }

            if(current_density < 0) {
                left++;
            } else if (current_density > 0) {
                right--;
            } else {
                // 농도가 0이 되었을 경우 더 탐색할 필요 없으므로 바로 return
                return ans;
            }
        }

        return ans;
    }
}
