import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 신발끈 공식
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());

        long[][] pos = new long[n][2];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(stk.nextToken());
            pos[i][1] = Integer.parseInt(stk.nextToken());
        }

        double answer = 0;
        for (int i = 0; i < n-1; i++) {
            answer += (double) (pos[i][0] * pos[i + 1][1]) / 2;
            answer -= (double) (pos[i][1] * pos[i + 1][0]) / 2;
            // 곱할 때 overflow가 일어나기 때문에 64bit 정수형을 사용해야 함.
        }
        answer += (double) (pos[n - 1][0] * pos[0][1]) / 2;
        answer -= (double) (pos[n - 1][1] * pos[0][0]) / 2;

        answer = Math.abs(answer);

        System.out.printf("%.1f", answer);
    }
}