
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    private static int ans = 0;
    private static HashSet<String> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int swapCnt = Integer.parseInt(st.nextToken());

            int[] numBoard = new int[num.length()];
            int idx = 0;
            for (String numStr : num.split("")) {
                numBoard[idx++] = Integer.parseInt(numStr);
            }

            ans = 0;

            visited = new HashSet<>();

            backtracking(numBoard, 0, swapCnt);
            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }

        System.out.println(sb);
    }

    private static void backtracking(int[] numBoard, int depth, int swapCnt) {

        if (swapCnt == depth) {
            int num = 0;
            for (int i = 0; i < numBoard.length; i++) {
                num = num * 10 + numBoard[i];
            }
            ans = Math.max(ans, num);
            return;
        }

        if (!visited.add(1 + ":" + Arrays.toString(numBoard))) {
            return;
        }

        for (int i = 0; i < numBoard.length; i++) {
            for (int j = i + 1; j < numBoard.length; j++) {
                int tmp = numBoard[i];
                numBoard[i] = numBoard[j];
                numBoard[j] = tmp;

                backtracking(numBoard, depth + 1, swapCnt);

                tmp = numBoard[i];
                numBoard[i] = numBoard[j];
                numBoard[j] = tmp;
            }
        }
    }
}
