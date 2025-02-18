import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(stk.nextToken());
            meetings[i][1] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(meetings, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(meetings[0][1]);
        for (int i = 1; i < N; i++) {
            if(pq.peek() <= meetings[i][0]) {
                pq.poll();
            }
            pq.add(meetings[i][1]);
        }

        System.out.println(pq.size());

        /* 우선순위 큐를 사용하지 않은 버전 - 시간 초과는 나타나지 않으나 비효율적임
        List<Integer> meetingList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            boolean found = false;
            for (int j = 0; j < meetingList.size(); j++) {
                if(meetingList.get(j) <= meetings[i][0]) { // 기존 회의실에 배정이 가능한 경우
                    meetingList.set(j, meetings[i][1]);
                    found = true;
                    break;
                }
            }

            if(!found) { // 기존 회의실에 배정이 불가능한 경우
                meetingList.add(meetings[i][1]);
            }
        }

        System.out.println(meetingList.size());
        */
    }
}