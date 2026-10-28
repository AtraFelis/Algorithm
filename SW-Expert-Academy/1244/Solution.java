/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int ans;
    static int cnt;
    static char[] numArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;

        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            stk = new StringTokenizer(br.readLine());
            String numStr = stk.nextToken();
            cnt = Integer.parseInt(stk.nextToken());

            numArr = numStr.toCharArray();
            ans = 0;

            backtracking(0, 0);

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.print(sb);
    }

    public static void backtracking(int depth, int startPos) {
        // 교환 횟수를 모두 사용했으면 최댓값 갱신
        if (depth == cnt) {
            ans = Math.max(ans, getNum());
            return;
        }

        int len = numArr.length;

        // 그리디: 왼쪽부터 최적화할 위치 탐색 (가중치가 높은 자리부터)
        for (int i = startPos; i < len - 1; i++) {
            // i 이후 구간에서 최대 숫자 찾기
            char maxDigit = numArr[i];
            for (int j = i + 1; j < len; j++) {
                if (numArr[j] > maxDigit) maxDigit = numArr[j];
            }

            // 현재 위치가 최대가 아니면 → 최대 숫자를 가진 위치와만 교환 시도
            if (numArr[i] < maxDigit) {
                for (int j = len - 1; j > i; j--) {
                    if (numArr[j] == maxDigit) {
                        swap(i, j);
                        backtracking(depth + 1, i + 1);
                        swap(i, j);
                    }
                }
                return; // 그리디: 가장 왼쪽 비최적 위치를 우선 해결
            }
        }

        // 이미 내림차순 정렬 완료 → 남은 교환 횟수 처리
        int remaining = cnt - depth;
        if (remaining % 2 == 0 || hasDuplicate()) {
            // 짝수번 남음: 같은 쌍을 반복 교환하면 원래대로
            // 중복 숫자 존재: 같은 숫자끼리 교환하면 값 유지
            ans = Math.max(ans, getNum());
        } else {
            // 홀수번 남고 중복 없음: 마지막 두 자리 교환이 최선
            swap(len - 2, len - 1);
            ans = Math.max(ans, getNum());
            swap(len - 2, len - 1);
        }
    }

    private static boolean hasDuplicate() {
        for (int i = 0; i < numArr.length; i++) {
            for (int j = i + 1; j < numArr.length; j++) {
                if (numArr[i] == numArr[j]) return true;
            }
        }
        return false;
    }

    private static void swap(int i, int j) {
        char tmp = numArr[i];
        numArr[i] = numArr[j];
        numArr[j] = tmp;
    }

    private static int getNum() {
        int num = 0;
        for (char c : numArr) {
            num = num * 10 + (c - '0');
        }
        return num;
    }
}

*/
public class Solution {
}
