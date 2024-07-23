import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        String[] grades = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
        double[] gradePoints = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};

        double totalScore = 0;
        double totalCredit = 0;

        for (int i = 0; i < 20; i++) {
            stk = new StringTokenizer(br.readLine());

            stk.nextToken();
            double credit = Double.parseDouble(stk.nextToken());
            String grade = stk.nextToken();
            double gradePoint = 0;

            if(grade.equals("P"))
                continue;

            for (int k = 0; k < 9; k++) {
                if (grade.equals(grades[k])) {
                    gradePoint = gradePoints[k];
                    break;
                }
            }

            totalScore += credit * gradePoint;
            totalCredit += credit;

        }

        System.out.printf("%.6f", totalScore / totalCredit);
    }
}