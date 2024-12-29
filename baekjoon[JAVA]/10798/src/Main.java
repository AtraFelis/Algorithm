import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 백준 - bronze I
 * 10789 - 세로읽기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] chars = new char[5][15];
        int max = 0;

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                chars[i][j] = str.charAt(j);
            }

            max = Math.max(max, str.length());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if(chars[j][i] != '\0') {
                    sb.append(chars[j][i]);
                }
            }
        }

        System.out.println(sb);
    }
}