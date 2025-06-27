import java.io.*;

public class Main {
    private static char[][] peterpan = {
        {'.', '.', '#', '.', '.'},
        {'.', '#', '.', '#', '.'},
        {'#', '.', '?', '.', '#'},
        {'.', '#', '.', '#', '.'},
        {'.', '.', '#', '.', '.'}
    };

    private static char[][] wendy = {
        {'.', '.', '*', '.', '.'},
        {'.', '*', '.', '*', '.'},
        {'*', '.', '?', '.', '*'},
        {'.', '*', '.', '*', '.'},
        {'.', '.', '*', '.', '.'}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int len = word.length();
        char[][] answer = new char[5][len * 4 + 1]; // 최대 길이

        int ansIdx = 0;

        boolean isPrevWendy = false;
        for (int i = 0; i < len; i++) {
            char[][] template = (i + 1) % 3 != 0 ? peterpan : wendy;

            for (int j = ansIdx; j < 5 + ansIdx; j++) {
                for (int k = 0; k < 5; k++) {                    
                    answer[k][j] = template[k][j - ansIdx];
                }
            }
            answer[2][ansIdx+2] = word.charAt(i);

            if(isPrevWendy) {
                answer[2][ansIdx] = '*';
                isPrevWendy = false;
            }

            if((i + 1) % 3 == 0) isPrevWendy = true;
            ansIdx += 4;
        }

        StringBuilder sb = new StringBuilder();
        for (char[] str : answer) {
            sb.append(str).append('\n');
        }

        System.out.println(sb);
    }
}