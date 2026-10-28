import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 도착점을 출발지로 생각하고 거꾸로 사다리 타기 하면 한 번에 찾을 수 있음
        // 애초에 사다리를 입력을 반대로 받기
        for (int tc = 1; tc <= 10; tc++) {
            sb.append('#').append(tc).append(' ');

            // input
            br.readLine();
            int startX = 0;
            int[][] ladder = new int[100][100];
            for (int i = 99; i >= 0; i--) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());

                    if (ladder[i][j] == 2)
                        startX = j;
                }
            }

            int y = 0, x = startX;
            while (y < 100) {
                // System.out.printf("x: %d, y: %d\n", x, y);
                // 좌우 살펴보고 길 있으면 반드시 이동
                if (x - 1 >= 0 && ladder[y][x - 1] == 1) {
                    while (x >= 0 && ladder[y][x - 1] != 0) {
                        x--;
                    }
                    y++;
                } else if (x + 1 < 100 && ladder[y][x + 1] == 1) {
                    while (x < 100 && ladder[y][x + 1] != 0) {
                        x++;
                    }
                    y++;
                } else {
                    y++;
                }

            }
            sb.append(x).append('\n');

        }
        System.out.println(sb);
    }
}