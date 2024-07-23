import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            sb.append(i).append('\n');
        }

        System.out.println(sb);
    }
}