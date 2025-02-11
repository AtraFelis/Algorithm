import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 인출 시간이 적은 사람부터 차례대로 업무를 수행하면 됨

        /*
        1. 배열 정렬
        2. 시간의 합 구하기
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(people);

        int ans = 0;
/*
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                ans += people[j];
            }
        }
*/

        // 누적합 알고리즘
        int[] prefixSum = new int[N];
        prefixSum[0] = people[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = people[i] + prefixSum[i-1];
        }

        for (int i = 0; i < N; i++) {
            ans += prefixSum[i];
        }

        System.out.println(ans);
    }
}