
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int[] score_distribution;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            score_distribution = new int[101];
            for (int idx = 0; idx < score_distribution.length; idx++) {
                score_distribution[idx] = 0;
            }

            int num = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());

            for (int j = 0; j < 1000; j++) {
                score_distribution[Integer.parseInt(stk.nextToken())]++;
            }

            int max_idx = 0, max_val = 0;
            for (int idx = 0; idx < score_distribution.length; idx++) {
                if (max_val <= score_distribution[idx]) {
                    max_idx = idx;
                    max_val = score_distribution[idx];
                }
            }

            sb.append("#").append(num).append(" ").append(max_idx).append('\n');
        }

        System.out.println(sb);
    }
}
