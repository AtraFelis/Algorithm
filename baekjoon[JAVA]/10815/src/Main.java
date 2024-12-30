import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    // use HashSet
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(stk.nextToken()));
        }

        m = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(set.contains(Integer.parseInt(stk.nextToken())) ? "1" : "0").append(' ');
        }

        System.out.println(sb);
    }*/


    // Use Binary Search
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        // 배열 정렬
        Arrays.sort(nums);

        m = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int idx = Arrays.binarySearch(nums, Integer.parseInt(stk.nextToken()));
            sb.append(idx >= 0 ? "1 " : "0 ");
        }
        System.out.println(sb);
    }
}