import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
/*        for (int i = 0; i < n; i++) {
            int a, b;

            stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());

            ArrayList<Integer> nums = new ArrayList<>();
            HashSet<Integer> seen = new HashSet<>();

            nums.add(a%10==0 ? 10 : a%10);
            seen.add(a%10);

            int temp = a;
            for (int j = 0; j < b; j++) {
                temp = temp * a % 10;
                if (seen.contains(temp)) {
                    break;
                }
                nums.add(temp == 0 ? 10 : temp);
                seen.add(temp);
            }

            int size = nums.size();
            int idx = b % size - 1;
            sb.append(nums.get(idx < 0 ? size - 1 : idx)).append('\n');
        }*/

        for (int i = 0; i < n; i++) {
            int a, b;
            stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());

            if (a % 10 == 0) {
                sb.append(10).append("\n");
                continue;
            }

            LinkedHashSet<Integer> set = new LinkedHashSet<>();
            set.add(a%10);
            int temp = a;
            while (true) {
                temp = temp * a % 10;
                if (set.contains(temp)) {
                    break;
                }
                set.add(temp%10);
            }


            int size = set.size();
            int idx = (b - 1) % size;
            sb.append(new ArrayList<>(set).get(idx)).append('\n');
        }

        System.out.println(sb.toString());
    }
}