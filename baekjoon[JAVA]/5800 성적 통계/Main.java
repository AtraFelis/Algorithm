import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(br.readLine());
            sb.append("Class ").append(i+1).append('\n');

            int n = Integer.parseInt(stk.nextToken());
            int[] scores = new int[n];

            for (int j = 0; j < n; j++) {
                scores[j] = Integer.parseInt(stk.nextToken());
            }

            Arrays.sort(scores);
            
            int max = scores[n-1];
            int min = scores[0];
            int gap = 0;

            for (int j = 0; j < n-1; j++) {
                gap = Math.max(gap, Math.abs(scores[j] - scores[j+1]));
            }

            sb.append("Max ").append(max).append(", ");
            sb.append("Min ").append(min).append(", ");
            sb.append("Largest gap ").append(gap).append("\n");
        }

        System.out.println(sb);
    }
}