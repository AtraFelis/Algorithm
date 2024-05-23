import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());

        int[] solution = new int[n];
        int front, answer_front;
        int rear, answer_rear;
        front = answer_front = 0; // 산성
        rear = answer_rear = n-1; // 알칼리

        for (int i = 0; i < n; i++)
            solution[i] = Integer.parseInt(stk.nextToken());

        int ph;
        int value = Integer.MAX_VALUE;
        while(rear != front && value != 0) {
            ph = solution[front] + solution[rear];

            if (Math.abs(ph) <= Math.abs(value)) {
                value = ph;
                answer_front = front;
                answer_rear = rear;
            }

            if(ph < 0) front++;
            else if(ph > 0) rear--;
        }

        System.out.println(solution[answer_front] + " " + solution[answer_rear]);
    }
}