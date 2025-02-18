import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static class Volunteer implements Comparable<Volunteer> {
        int documentRank;
        int interviewRank;

        public Volunteer(int document, int interview) {
            this.documentRank = document;
            this.interviewRank = interview;
        }

        @Override
        public int compareTo(Volunteer o) {
            return this.documentRank - o.documentRank;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Volunteer[] volunteers = new Volunteer[N];

            for(int i = 0; i < N; i++) {
                StringTokenizer stk =  new StringTokenizer(br.readLine());
                int document = Integer.parseInt(stk.nextToken());
                int interview = Integer.parseInt(stk.nextToken());

                volunteers[i] = new Volunteer(document, interview);
            }

            // 서류 순위 기준 오름차순 정렬 - compareTo() 메소드
            Arrays.sort(volunteers);

            // 1번부터 자신보다 서류 순위가 높은 인원 중 서류 순위가 높은 인원이 있는지 확인
            int answer = 1; // 0번은 서류 1위이므로 반드시 뽑히므로 제외
            int topRate = volunteers[0].interviewRank;
            for (int i = 1; i < N; i++) {
                /* 완전탐색 - 시간초과 Fail
                boolean isAcceptance = true;
                for (int j = 0; j < i; j++) {
                    if (volunteers[i].interviewRank > volunteers[j].interviewRank) {
                        isAcceptance = false;
                        break;
                    }
                }
                if (isAcceptance) {
                    answer++;
                }*/

                if (volunteers[i].interviewRank < topRate) {
                    answer++;
                    topRate = volunteers[i].interviewRank;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}