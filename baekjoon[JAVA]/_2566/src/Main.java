import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int[][] matrix = new int[9][9];

        for (int i = 0; i < 9; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int row = 1, column = 1, max = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                    row = i+1;
                    column = j+1;
                }
            }
        }


        System.out.println(max);
        System.out.println(row + " " + column);
    }
}