import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Queue<Integer> knownPeopleQueue;
    private static ArrayList<HashSet<Integer>> parties;
    private static boolean[] canLie; // 어떤 파티에서 거짓말을 할 수 있는지 저장
    private static boolean[] checked; // 진실을 아는 사람 중, 확인을 했는지 여부

    private static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        knownPeopleQueue = new LinkedList<>();
        parties = new ArrayList<>();

        canLie = new boolean[m];
        checked = new boolean[n + 1];

        Arrays.fill(canLie, true);
        Arrays.fill(checked, false);

        stk = new StringTokenizer(br.readLine());
        int truthCnt = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < truthCnt; i++) {
            int tmp = Integer.parseInt(stk.nextToken());
            knownPeopleQueue.add(tmp);
            checked[tmp] = true;
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(stk.nextToken());

            parties.add(new HashSet<>());
            for (int j = 0; j < tmp; j++) {
                parties.get(i).add(Integer.parseInt(stk.nextToken()));
            }
        }


        System.out.println(solution());
    }


    /*
    1. 진실을 알고 있는 사람을 우선하여 어떤 파티에 참석하는지 탐색
        - 이 사람이 참석한 파티는 제외
        - 이 사람과 같이 파티에 참석한 사람은 큐에 추가
    2. 진실을 알게된 사람을 기준으로 어떤 파티에 참석했는지 탐색
    3. 큐가 비면 탐색 종료.
     */
    private static int solution() {
        int lyingPartyCount = m;

        while (!knownPeopleQueue.isEmpty()) {
            int knownPerson = knownPeopleQueue.poll();

            for (int i = 0; i < m; i++) {
                HashSet<Integer> party = parties.get(i);

                if (party.contains(knownPerson)) { // 진실을 아는 사람이 파티에 참여했다면
                    if (canLie[i]) { // 거짓말을 할 수 있을 줄 알았다면
                        canLie[i] = false;
                        lyingPartyCount--;

                        for (Integer person : party) {
                            if(!checked[person]) {
                                checked[person] = true;
                                knownPeopleQueue.add(person);
                            }
                        }
                    }
                }
            }

            if(lyingPartyCount == 0) {
                break;
            }
        }

        return lyingPartyCount;
    }
}