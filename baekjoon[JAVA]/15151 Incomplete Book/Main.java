import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        
        int k, d;
        stk = new StringTokenizer(br.readLine());
        k = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());
        
        int sum = k;
        int ans = 0;
        while(sum <= d) {
            ans++;
            k*=2;
            sum += k;
        }

        System.out.println(ans);
    }
}