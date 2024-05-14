import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr, seq;

    static void backtracking(int idx) {
        if(idx == m) {
            Arrays.stream(seq).forEach(value -> System.out.print(value + " "));
            System.out.println();
        }
        else {
            int last = 0;
            for (int i = 0; i < n; i++) {
                if(last != arr[i] && (idx == 0 || seq[idx-1] <= arr[i])) {
                    seq[idx] = arr[i];
                    last = arr[i];
                    backtracking(idx + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        arr = new int[n];
        seq = new int[m];

        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(stk.nextToken());

        Arrays.sort(arr);

        backtracking(0);
    }
}