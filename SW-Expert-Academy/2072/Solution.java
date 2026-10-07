import java.io.*;
import java.util.StringTokenizer;

/*
 * 10개의 수를 입력 받아, 그 중에서 홀수만 더한 값을 출력하는 프로그램을 작성하라.
 * 
 * 
 * [제약 사항]
 * 
 * 각 수는 0 이상 10000 이하의 정수이다.
 * 
 * 
 * [입력]
 * 
 * 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
 * 
 * 각 테스트 케이스의 첫 번째 줄에는 10개의 수가 주어진다.
 * 
 * 
 * [출력]
 * 
 * 출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
 * 
 * (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
 */

class Solution {
    public static void main(String args[]) throws Exception {
        // System.setIn(new FileInputStream("input.txt"));

        /*
         * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
         */
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());

            int sum = 0;
            for (int j = 0; j < 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num % 2 != 0) {
                    sum += num;
                }
            }
            sb.append("#").append(i).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
