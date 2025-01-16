import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         *  1. 점의 좌표를 정렬하여 배열에 저장한다.
         *  2. 선분의 시작 위치에서 가장 가까운 점, 끝점의 위치에서 가장 가까운 점 (두 점 모두 선분 안에 속함)의 인덱스를 구한다.
         *  3. 인덱스를 이용해 점의 개수를 구한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n, m;
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int[] dots = new int[n];
        for (int i = 0; i < n; i++) {
            dots[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(dots);

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

//            int idx1 = lowerBound(dots, start);
//            int idx2 = upperBound(dots, end);

            int idx1 = binarySearch(dots, start, false);
            int idx2 = binarySearch(dots, end, true);

            sb.append(idx2 - idx1).append('\n');
        }

        System.out.println(sb);
    }

    private static int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (key <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (key < arr[mid]) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return lo;
    }

    /**
     * @param flag : upperBound Flag
     */
    private static int binarySearch(int[] arr, int key, boolean flag) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if(key == arr[mid]) {
                if (flag) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }
            }
            else if (key < arr[mid]) {
                hi = mid;
            } else if(key > arr[mid]) {
                lo = mid+1;
            }
        }
        return lo;
    }
}