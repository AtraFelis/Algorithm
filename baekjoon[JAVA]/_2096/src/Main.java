import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][3];
        int[][] dp_max = new int[n][3];
        int[][] dp_min = new int[n][3];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                map[i][j] = Integer.parseInt(stk.nextToken());
        }


        for (int i = 0; i < 3; i++)
            dp_max[0][i] = dp_min[0][i] = map[0][i];

        for (int i = 1; i < n; i++) {
            dp_max[i][0] = map[i][0] + Integer.max(dp_max[i-1][0], dp_max[i-1][1]);
            dp_max[i][1] = map[i][1] + Integer.max(Integer.max(dp_max[i-1][0], dp_max[i-1][1]), dp_max[i-1][2]);
            dp_max[i][2] = map[i][2] + Integer.max(dp_max[i-1][1], dp_max[i-1][2]);

            dp_min[i][0] = map[i][0] + Integer.min(dp_min[i-1][0], dp_min[i-1][1]);
            dp_min[i][1] = map[i][1] + Integer.min(Integer.min(dp_min[i-1][0], dp_min[i-1][1]), dp_min[i-1][2]);
            dp_min[i][2] = map[i][2] + Integer.min(dp_min[i-1][1], dp_min[i-1][2]);
        }

        int max = Integer.max(Integer.max(dp_max[n-1][0], dp_max[n-1][1]), dp_max[n-1][2]);
        int min = Integer.min(Integer.min(dp_min[n-1][0], dp_min[n-1][1]), dp_min[n-1][2]);

        System.out.println(max + " " + min);
    }
}