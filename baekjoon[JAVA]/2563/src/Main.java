import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 몬테카를로 적분법 활용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        boolean[][] paper = new boolean[100][100];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    paper[j + x][k + y] = true;
                }
            }
        }

        int area = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(paper[i][j]) area++;
            }
        }

        System.out.println(area);
    }
/*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());

        ArrayList<int[][]> pos = new ArrayList<>();
        HashSet<List<Integer>> dupCheck = new HashSet<>();

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            // 색종이가 완전히 겹칠 때는 무시
            if (dupCheck.add(Arrays.asList(x, y))) {
                pos.add(new int[][]{{x, y+10}, {x+10, y+10}, {x, y}, {x+10, y}});
            }
        }

        for (int i = 0; i < pos.size(); i++) {
            System.out.println(pos.get(i)[2][0] + " " + pos.get(i)[2][1]);
        }

        int area = getArea(pos);
        System.out.println(area);
    }

    private static int getArea(ArrayList<int[][]> pos) {
        int n = pos.size();
        int area = 100 * n;

        for (int i = 0; i < n - 1; i++) {
            int[][] curPaper = pos.get(i);
            for (int j = i+1; j < n; j++) {
                int[][] comparedPaper = pos.get(j);

                int yGap = Math.abs(curPaper[0][1] - comparedPaper[2][1]);
                int xGap = Math.abs(curPaper[0][0] - comparedPaper[1][0]);

                if((yGap >= 20 || yGap <= 10) && (xGap >= 20 || xGap <= 10)) {
                    continue;
                }

                int w = xGap > 10 ? 20 - xGap : xGap;
                int h = yGap > 10 ? 20 - yGap : yGap;

                System.out.println(w*h);
                area -= w*h;

                System.out.println("area : " + area);
            }
        }
        return area;
    }*/
}