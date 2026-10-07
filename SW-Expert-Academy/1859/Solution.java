import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());

            int[] price = new int[n];
            for (int j = 0; j < n; j++) {
                price[j] = Integer.parseInt(stk.nextToken());
            }

            // 1. 최댓값 찾기. 최댓값 기준으로 뒤쪽 인덱스에서도 순차적으로 최댓값 찾기
            int curIdx = 0;
            long profit = 0;

            while (curIdx < n) {
                int maxIdx = curIdx;
                int maxPrice = 0;
                for (int j = curIdx; j < n; j++) {
                    if (price[j] > maxPrice) {
                        maxPrice = price[j];
                        maxIdx = j;
                    }
                }

                // 2. 반복 돌리면서 수익 계산하기
                if (maxIdx == curIdx) {
                    curIdx++;
                    continue;
                }

                for (int j = curIdx; j < maxIdx; j++) {
                    profit += maxPrice - price[j];
                }
                curIdx = maxIdx + 1;
            }

            sb.append("#").append(i).append(" ").append(profit).append("\n");
        }
        System.out.println(sb);
    }
}
