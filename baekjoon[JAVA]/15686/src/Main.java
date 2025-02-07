import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<List<Integer>> chickenDistances;
    static List<Integer[]> housePositions = new ArrayList<>();
    static List<Integer[]> chickenPositions = new ArrayList<>();

    static boolean[] visited;
    static int houseCnt, chickenCnt;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                String input = stk.nextToken();
                if (input.equals("1")) {
                    housePositions.add(new Integer[]{i, j});
                } else if(input.equals("2")) {
                    chickenPositions.add(new Integer[]{i, j});
                }
            }
        }

        houseCnt = housePositions.size();
        chickenCnt = chickenPositions.size();

        chickenDistances = new ArrayList<>();
        int idx = 0;
        for (Integer[] chickenPosition : chickenPositions) {
            chickenDistances.add(new ArrayList<>());
            for (Integer[] housePosition : housePositions) {
                int xDist = Math.abs(chickenPosition[0] - housePosition[0]);
                int yDist = Math.abs(chickenPosition[1] - housePosition[1]);

                chickenDistances.get(idx).add(xDist + yDist);
            }

            idx++;
        }

        for (List<Integer> chickenDistance : chickenDistances) {
            System.out.println(chickenDistance);
        }

        visited = new boolean[chickenCnt];
        for (int i = 1; i <= M; i++) {
            backtracking(i, new ArrayList<>());
        }

        System.out.println(result);
        br.close();
    }


    private static void backtracking(int maxDepth, ArrayList<Integer> idxes) {
        if (idxes.size() == maxDepth) {
            int[] tmp = new int[houseCnt];
            for (int j = 0; j < houseCnt; j++) {
                tmp[j] = chickenDistances.get(idxes.get(0)).get(j);
            }

            for (Integer idx : idxes) {
                for (int j = 0; j < houseCnt; j++) {
                    tmp[j] = Math.min(tmp[j], chickenDistances.get(idx).get(j));
                }
            }
            int sum = 0;
            for (int i : tmp) {
                sum += i;
            }

            result = Math.min(result, sum);
        } else {
            for (int i = 0; i < chickenCnt; i++) {
                if(visited[i] || (!idxes.isEmpty() && idxes.get(idxes.size() - 1) > i)) continue;

                idxes.add(i);
                visited[i] = true;
                backtracking(maxDepth, idxes);
                visited[i] = false;
                idxes.remove(idxes.size() - 1);
            }
        }
    }
}