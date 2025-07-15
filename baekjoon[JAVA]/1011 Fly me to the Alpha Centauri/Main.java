import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int ans = -1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            int dest = y - x;

            backtracking(1, 1, dest, 1);
            sb.append(ans).append('\n');
            ans = -1;
        }

        System.out.println(sb);
    }

    private static void backtracking(int curPos, int travelDist, int dest, int depth) {
        if(ans != -1) return;
        if(curPos > dest) return;

        if(curPos == dest && travelDist == 1){
            ans = depth;
            return;
        }

        backtracking(curPos + travelDist, travelDist + 1, dest, depth + 1);
        backtracking(curPos + travelDist, travelDist, dest, depth + 1);

        if(travelDist - 1 > 0)
            backtracking(curPos + travelDist, travelDist - 1, dest, depth + 1);
    }
}