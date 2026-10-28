import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int num = 1; num <= n; num++) {
            int tmp = num;
            boolean flag = false;
            while (tmp > 0) {
                if (tmp % 10 != 0 && tmp % 10 % 3 == 0) {
                    sb.append('-');
                    flag = true;
                }
                tmp /= 10;
            }
            sb.append(flag ? "" : num).append(' ');
        }

        System.out.println(sb);
    }
}
