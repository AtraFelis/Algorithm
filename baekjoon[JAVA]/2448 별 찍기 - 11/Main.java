import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String[] format = {"  *  ", " * * ", "*****"};
    static char[][] output;

    static void makeStar(int height, int width, int n) {
        if(n == 3) {
            int tmp_h = height - 2;
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j < 5; j++) {
                    output[tmp_h+i][width + j] = format[i].charAt(j);
                }
            }
            return;
        }

        makeStar(height - n/2, width + n/2, n/2);
        makeStar(height, width, n/2);
        makeStar(height, width + n, n/2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        output = new char[n + 1][2 * n + 1];

        makeStar(n, 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n*2; j++) {
                if (output[i][j] == '\0')
                    sb.append(' ');
                else sb.append(output[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}