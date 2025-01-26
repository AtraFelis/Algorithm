import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<String, Integer> yut = new HashMap<>();
    static int[][] move = new int[29][5];
    static int[] map = new int[29];
    static int U, N, A, B;
    static int goalA = 0, goalB = 0;
    static int remainA, remainB;
    static String[] yutStates;
    static ArrayList<Integer> aPos, bPos;
    static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        yut.put("Do", 1);
        yut.put("Gae", 2);
        yut.put("Gul", 3);
        yut.put("Yut", 4);
        yut.put("Mo", 5);

        for (int i = 0; i < 29; i++) {
            for (int j = 0; j < 5; j++) {
                move[i][j] = i+j+1;
            }
            map[i] = 0;
        }

        move[5] = new int[]{20, 21, 22, 23, 24};
        move[10] = new int[]{25, 26, 22, 27, 28};
        move[15] = new int[]{16, 17, 18, 19, 0};
        move[16] = new int[]{17, 18, 19, 0, 29};
        move[17] = new int[]{18, 19, 0, 29, 29};
        move[18] = new int[]{19, 0, 29, 29, 29};
        move[19] = new int[]{0, 29, 29, 29, 29};
        move[20] = new int[]{21, 22, 24, 25, 15};
        move[21] = new int[]{22, 23, 24, 15, 16};
        move[22] = new int[]{27, 28, 0, 29, 29};
        move[23] = new int[]{24, 15, 16, 17, 18};
        move[24] = new int[]{15, 16, 17, 18, 19};
        move[25] = new int[]{26, 22, 27, 28, 0};
        move[26] = new int[]{22, 27, 28, 0, 29};
        move[27] = new int[]{28, 0, 29, 29, 29};
        move[28] = new int[]{0, 29, 29, 29, 29};
        move[0] = new int[]{29, 29, 29, 29, 29};


        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            stk = new StringTokenizer(br.readLine());
            remainA = remainB = U = Integer.parseInt(stk.nextToken());
            N = Integer.parseInt(stk.nextToken());
            A = Integer.parseInt(stk.nextToken());
            B = Integer.parseInt(stk.nextToken());

            yutStates = new String[N];
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                yutStates[j] = stk.nextToken();
            }

            aPos = new ArrayList<>();
            bPos = new ArrayList<>();

            stk = new StringTokenizer(br.readLine());
            while (stk.hasMoreTokens()) {
                aPos.add(Integer.parseInt(stk.nextToken()));
            }
            stk = new StringTokenizer(br.readLine());
            while (stk.hasMoreTokens()) {
                bPos.add(Integer.parseInt(stk.nextToken()));
            }

            result = false;
            solution(0, 1);
            sb.append("Case #").append(i + 1).append(": ").append(result ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }

    private static void solution(int cnt, int turn) {
        if(result) return;

        // 윷을 전부 소모하지 않았는데 게임이 종료되었다면, return
        if (cnt != N && (goalA == U || goalB == U)) {
            return;
        }

        if (cnt == N) {
            int currentA = 0, currentB = 0; // 현재 말판 위에 올라간 말의 개수
            for (int i = 0; i < 29; i++) {
                if(map[i] > 0)
                    currentA += map[i];
                else if(map[i] < 0)
                    currentB += map[i] * -1;
            }

            if(currentA != A || currentB != B) {
                return;
            }

            for (Integer a : aPos) {
                if (map[a] <= 0)
                    return;
            }
            for (Integer b : bPos) {
                if (map[b] >= 0)
                    return;
            }

            result = true;
        } else {
            /*
            1. 기존에 있던 말을 움직임.
            2. 새로운 말이 나감
             */

            int moveDis = yut.get(yutStates[cnt]);
            int oneMore = moveDis >= 4 ? 1 : -1;

            // 1. 기존 말을 움직임
            int nextPos;
            for (int i = 0; i < map.length; i++) {
                if (turn == 1 && map[i] > 0) {
                    nextPos = move[i][moveDis-1];
                    if (nextPos < 29) {
                        int tmp = map[nextPos];

                        if (map[nextPos] < 0) { // B의 말이 이미 존재할 경우
                            remainB += map[nextPos];
                            map[nextPos] = map[i];
                            map[i] = 0;
                            solution(cnt + 1, turn);
                            map[i] = map[nextPos];
                            map[nextPos] = tmp;
                            remainB -= map[nextPos];
                        } else if (map[nextPos] >= 0) {
                            map[nextPos] += map[i];
                            map[i] = 0;
                            solution(cnt + 1, turn * oneMore);
                            map[i] = map[nextPos] - tmp;
                            map[nextPos] = tmp;
                        }
                    } else { // 골인
                        int tmp = map[i];
                        goalA++;
                        map[i] = 0;
                        solution(cnt + 1, turn * oneMore);
                        map[i] = tmp;
                        goalA--;
                    }
                } else if (turn == -1 && map[i] < 0) {
                    nextPos = move[i][moveDis-1];
                    if (nextPos < 29) {
                        int tmp = map[nextPos];
                        // A의 말이 이미 존재할 경우
                        if (map[nextPos] > 0) {
                            remainA += map[nextPos];
                            map[nextPos] = map[i];
                            map[i] = 0;
                            solution(cnt + 1, turn);
                            map[i] = map[nextPos];
                            map[nextPos] = tmp;
                            remainA -= map[nextPos];
                        } else if (map[nextPos] <= 0) {
                            map[nextPos] += map[i];
                            map[i] = 0;
                            solution(cnt + 1, turn * oneMore);
                            map[i] = map[nextPos] - tmp;
                            map[nextPos] = tmp;
                        }
                    } else { // 골인
                        int tmp = map[i];
                        map[i] = 0;
                        goalB++;
                        solution(cnt + 1, turn * oneMore);
                        goalB--;
                        map[i] = tmp;
                    }
                }
            }

            // 2. 새로운 말을 내보냄
            if (turn == 1 && remainA != 0) {
                int tmp = map[moveDis];
                remainA--;
                // B의 말이 이미 존재할 경우
                if (map[moveDis] < 0) {
                    map[moveDis] = 1;
                    solution(cnt + 1, turn);
                } else {
                    map[moveDis]++;
                    solution(cnt + 1, turn * oneMore);
                }
                remainA++;
                map[moveDis] = tmp;
            } else if (turn == -1 && remainB != 0) {
                remainB--;
                int tmp = map[moveDis];
                // A의 말이 이미 존재할 경우
                if (map[moveDis] > 0) {
                    map[moveDis] = -1;
                    solution(cnt + 1, turn);
                } else {
                    map[moveDis]--;
                    solution(cnt + 1, turn * oneMore);
                }
                remainB++;
                map[moveDis] = tmp;
            }
        }
    }
}