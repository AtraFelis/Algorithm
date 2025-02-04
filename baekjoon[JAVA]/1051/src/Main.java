import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[][] map = new int[N+1][M+1];
        for (int i = 1; i < N+1; i++) {
            String line = br.readLine();
            for (int j = 1; j < M+1; j++) {
                map[i][j] = line.charAt(j-1) - '0';
            }
        }

        int maxSideLen = getMaxSideLen(N, M, map);
        System.out.println(maxSideLen*maxSideLen);
    }

    private static int getMaxSideLen(int N, int M, int[][] map) {
        int maxIdx = Math.min(N, M);
        int maxSideLen = 1;

        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= M; y++) {

                int curNum = map[x][y];
                for (int curSideLen = 1; curSideLen <= maxIdx; curSideLen++) {
                    if(curSideLen < maxSideLen) continue;

                    int nextX = x + curSideLen - 1;
                    int nextY = y + curSideLen - 1;

                    if(nextX > N || nextY > M) {
                        continue;
                    }

                    if (map[nextX][nextY] == curNum && map[x][nextY] == curNum && map[nextX][y] == curNum) {
                        maxSideLen = Math.max(maxSideLen, curSideLen);
                    }
                }
            }
        }
        return maxSideLen;
    }
}