import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int next;
        int shortCut;
        boolean goal;
        int piece;

        public Node(int next, int shortCut, boolean goal) {
            this.next = next;
            this.shortCut = shortCut;
            this.goal = goal;
        }
    }

    static class Piece {
        int player;
        int position;
        boolean goal = false;

        public Piece(int player, int position) {
            this.player = player;
            this.position = position;
        }
    }

    static HashMap<String, Integer> yutCnt = new HashMap<>();
    static int U, N, A, B;
    static int[] yutValues;
    static int[] aPosition, bPosition;
    static Piece[] aPieces, bPieces;
    static Node[] board = new Node[31];
    // 마지막 노드 인덱스는 29 -> 여기서는 말이 잡힐 수 있음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        yutCnt.put("Do", 1);
        yutCnt.put("Gae", 2);
        yutCnt.put("Gul", 3);
        yutCnt.put("Yut", 4);
        yutCnt.put("Mo", 5);

        initGame();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            initGame();
            backTracking(0);
            sb.append("Case #").append(i+1).append(": ").append(canMade ? "YES\n" : "NO\n");
        }

        System.out.println(sb);
    }

    private static boolean canMade = false;
    private static void backTracking(int depth) {
        if(canMade)
            return;

        if (depth == N) {
            /*
            1. 판 위에 올라간 말의 개수가 동일한지.
            2. 말의 위치가 동일한지.
             */
        } else {

        }
    }

    private static void initGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        initBoard();

        stk = new StringTokenizer(br.readLine());
        U = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        A = Integer.parseInt(stk.nextToken());
        B = Integer.parseInt(stk.nextToken());

        aPieces = bPieces = new Piece[U];

        for (int i = 0; i < U; i++) {
            aPieces[i] = new Piece(1, 0);
            bPieces[i] = new Piece(-1, 0);
        }

        yutValues = new int[N];
        aPosition = new int[A];
        bPosition = new int[B];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            yutValues[i] = yutCnt.get(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            aPosition[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            bPosition[i] = Integer.parseInt(stk.nextToken());
        }
    }

    private static void initBoard() {
        for (int i = 0; i < 19; i++) {
            board[i] = new Node(i+1, -1, false);
        }

        board[5].shortCut = 20;
        board[10].shortCut = 25;

        board[20] = new Node(21, -1, false);
        board[21] = new Node(22, -1, false);
        board[25] = new Node(26, -1, false);
        board[26] = new Node(22, -1, false);
        board[23] = new Node(24, -1, false);
        board[24] = new Node(15, -1, false);
        board[27] = new Node(28, -1, false);
        board[28] = new Node(29, -1, false);

        // 21과 26에서 지나갈 때의 방향이 다르므로 예외처리.
        board[22] = new Node(-1, 27, false);
        // 실제로는 0번 노드와 같은 위치. 편하게 처리하기 위해서 29로 따로 배정
        board[29] = new Node(30, -1, false);
        board[30] = new Node(30, -1, true);
    }
}