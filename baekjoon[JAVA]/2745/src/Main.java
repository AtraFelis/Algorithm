import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.next();
        int B = sc.nextInt();

        int answer = 0;
        int digit = N.length()-1;
        // A : 65 ~ Z : 90
        for (int i = 0; i < N.length(); i++) {
            char c = Character.valueOf(N.charAt(i));
            int num;
            if (c >= 65) {
                num = c - 65 + 10;
            } else {
                num = Integer.parseInt(String.valueOf(c));
            }

            answer += num * Math.pow(B, digit--);
        }
        System.out.println(answer);
    }
}
