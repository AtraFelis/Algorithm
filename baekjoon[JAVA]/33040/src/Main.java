import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h, w, c, d;
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // 마작 거신병을 만들 수 없는 경우
        if(h-1 > w) {
            System.out.println(-1);
            return;
        }

        int minNines = 0;
        for (int i = 1; i <= h - 1; i++)
            minNines += i;

        if(d < minNines || d > h*w-minNines) {
            System.out.println(-1);
            return;
        }

        // 마작 거신병을 만들 수 있는 경우
        int remainingNines = d - minNines;
        int[][] matrix = new int[h][w];

        for (int i = h-1; i >= 0; i--) {
            int requiredNines = i;
            int maxNines = w - h + i + 1;

            if (remainingNines > 0) {
                if(remainingNines - (maxNines - requiredNines) >= 0) {
                    remainingNines -= maxNines - requiredNines;
                    requiredNines = maxNines;
                } else {
                    requiredNines += remainingNines;
                    remainingNines = 0;
                }
            }

            for (int j = 0; j < requiredNines; j++) {
                matrix[i][j] = 9;

            }
            for (int j = requiredNines; j < w; j++) {
                matrix[i][j] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}