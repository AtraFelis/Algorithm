import java.util.Scanner;

/*
JAVA 12 버전 이상부터 사용 가능
백준은 11까지만 지원하므로, 그대로 제출하면 컴파일 에러.
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            int word = str.charAt(i);

            answer += switch (word) {
                case 'A', 'B', 'C' -> 3;
                case 'D', 'E', 'F' -> 4;
                case 'G', 'H', 'I' -> 5;
                case 'J', 'K', 'L' -> 6;
                case 'M', 'N', 'O' -> 7;
                case 'P', 'Q', 'R', 'S' -> 8;
                case 'T', 'U', 'V' -> 9;
                case 'W', 'X', 'Y', 'Z' -> 10;

                default -> 10; // 예외 처리를 위한 기본값
            };
        }

        System.out.println(answer);
    }
}