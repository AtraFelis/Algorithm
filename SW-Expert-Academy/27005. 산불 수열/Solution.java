import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> iList = new ArrayList<>();
        int t = Integer.parseInt(br.readLine());

        int maxI = 0;
        for (int tc = 1; tc <= t; tc++) {
            int i = Integer.parseInt(br.readLine());
            iList.add(i);
            maxI = Math.max(maxI, i);
        }

        int[] seq = new int[maxI + 1];
        seq[0] = 1;
        seq[1] = 1;

        for (int i = 2; i <= maxI; i++) {
            // 최솟값 찾으므로 1부터 찾음, k = i//2만큼 금지 숫자 생김 -> 즉 1 ~ i/2 + 1 사이에 A[i] 존재
            boolean[] forbidden = new boolean[i / 2 + 2];
            // i/2만큼 반복
            for (int k = 1; k <= i / 2; k++) {
                int value = 2 * seq[i - k] - seq[i - 2 * k];
                if (value > 0 && value < forbidden.length)
                    forbidden[value] = true;
            }

            for (int j = 1; j <= 2 * i + 1; j++) {
                if (!forbidden[j]) {
                    seq[i] = j;
                    break;
                }
            }
        }

        for (

        Integer i : iList) {
            System.out.println(seq[i]);
        }
    }
}
