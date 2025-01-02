import java.util.Arrays;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;

        int low = 1;
        int high = 0;

        for (int i = 0; i < diffs.length; i++) {
            if(high < diffs[i]) {
                high = diffs[i];
            }
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean result = solve(diffs, times, limit, mid);

            if(result) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        answer = low;
        return answer;
    }

    private boolean solve(int[] diffs, int[] times, long limit, int level) {
        long duration = times[0];
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                duration += times[i];
            } else {
                int gap = diffs[i] - level;
                duration += gap * times[i - 1] + (gap + 1) * times[i];
            }

            if(limit < duration) {
                return false;
            }
        }
    
        return true;
    }
}