import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        // 만약 덤프할 때마다 정렬을 한다면? -> 이미 거의 정렬된 상태이므로, O(N)

        for (int i = 1; i <= 10; i++) {
            int[] arr = new int[100];

            int n = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 100; j++) {
                arr[j] = Integer.parseInt(stk.nextToken());
            }

            for (int j = 0; j < n; j++) {
                Arrays.sort(arr); // 첫 정렬 빼고는 O(N)
                if (arr[0] == arr[99] || arr[0] == arr[99] - 1) {
                    break;
                }

                arr[0]++;
                arr[99]--;
            }

            Arrays.sort(arr);
            sb.append('#').append(i).append(' ').append(arr[99] - arr[0]).append('\n');
        }

        System.out.println(sb);
    }
}
