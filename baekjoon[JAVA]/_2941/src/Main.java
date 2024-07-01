import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        String[] croatian = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for (String c : croatian) {
            word = word.replaceAll(c, "_"); // 크로아티아 알파벳을 _로 치환
        }

        System.out.println(word.length());
    }
}