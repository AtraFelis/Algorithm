import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int score;          // 칸에 적힌 점수
        int nextRed;        // 빨간색 경로로 이동 시 다음 칸의 인덱스
        int nextBlue;       // 파란색 경로로 이동 시 다음 칸의 인덱스 (없으면 -1)

        boolean isEmpty = true;

        Node(int score, int nextRed, int nextBlue) {
            this.score = score;
            this.nextRed = nextRed;
            this.nextBlue = nextBlue;
        }
    }

    static class Piece {
        int score;
        int currPos;

        public Piece(int score, int currPos) {
            this.score = score;
            this.currPos = currPos;
        }
    }

    static int[] diceValues = new int[10];
    static Node[] map = new Node[33];
    static Piece[] pieces = new Piece[4];

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        initMap();
        initPiece();

        for (int i = 0; i < 10; i++) {
            diceValues[i] = Integer.parseInt(stk.nextToken());
        }

        backTracking(0);

        System.out.println(ans);

    }

    /**
     * 백트래킹
     * 1. 기존의 말을 움직인다.
     * 2. 새로운 말을 움직인다.
     * 3. depth가 10이 되면 점수를 기록하고 return
     * <p>
     * if (depth == 10) {
     *      max = Math.max(max, score);
     * } else {
     *      기존의 말 혹은 새로운 말을 움직인다.
     *      backtracking(depth + 1, score + ?);
     *      기존 위치로 복구.
     * }
     */
    private static void backTracking(int depth) {
        if (depth == 10) {
            int score = 0;
            for (int i = 0; i < 4; i++) {
                score += pieces[i].score;
            }
            ans = Math.max(ans, score);
        } else {
            for (int i = 0; i < 4; i++) {
                if(pieces[i].currPos == 32)
                    continue;

                int diceValue = diceValues[depth];
                int tmp = pieces[i].currPos;

                // 파란색 칸이라면
                if (map[pieces[i].currPos].nextBlue != -1) {
                    diceValue--;
                    pieces[i].currPos = map[pieces[i].currPos].nextBlue;
                }

                // 남은 value만큼 빨간색 화살표를 따라 이동
                for (int j = 0; j < diceValue; j++) {
                    pieces[i].currPos = map[pieces[i].currPos].nextRed;
                }

                pieces[i].score += map[pieces[i].currPos].score;

                // 이동하고자 하는 노드가 비어있다면
                if(map[pieces[i].currPos].isEmpty) {
                    if(pieces[i].currPos != 32)
                        map[pieces[i].currPos].isEmpty = false;
                    map[tmp].isEmpty = true;
                    backTracking(depth + 1);
                    map[tmp].isEmpty = false;
                    map[pieces[i].currPos].isEmpty = true;
                }

                pieces[i].score -= map[pieces[i].currPos].score;
                pieces[i].currPos = tmp;
            }
        }
    }


    private static void initMap() {
        for (int i = 0; i < 20; i++) {
            map[i] = new Node(i*2, i+1, -1);
        }

        map[5].nextBlue = 21;
        map[10].nextBlue = 24;
        map[15].nextBlue = 26;

        map[20] = new Node(40, 32, -1);
        map[21] = new Node(13, 22, -1);
        map[22] = new Node(16, 23, -1);
        map[23] = new Node(19, 29, -1);
        map[24] = new Node(22, 25, -1);
        map[25] = new Node(24, 29, -1);
        map[26] = new Node(28, 27, -1);
        map[27] = new Node(27, 28, -1);
        map[28] = new Node(26, 29, -1);
        map[29] = new Node(25, 30, -1);
        map[30] = new Node(30, 31, -1);
        map[31] = new Node(35, 20, -1);
        map[32] = new Node(0, 32, -1);

//        int idx = 0;
//        for (Node node : map) {
//            System.out.println(idx++ + " " +node);
//        }
    }

    private static void initPiece() {
        for (int i = 0; i < pieces.length; i++) {
            pieces[i] = new Piece(0, 0);
        }
    }
}