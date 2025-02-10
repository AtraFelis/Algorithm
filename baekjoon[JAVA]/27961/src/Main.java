import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long answer = 1L;
        long cnt = 1L; // 생성마법 1번

        while (cnt < N) {
            answer++;
            cnt *= 2;
        }

        System.out.println(N == 0 ? 0 : answer);
    }
}