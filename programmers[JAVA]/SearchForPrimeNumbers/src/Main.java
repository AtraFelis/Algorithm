import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("011");
    }
}

class Solution {
    private List<Integer> probableNums = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    private boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;
        int len = numbers.length();

        visited = new boolean[len];
        for (int i = 1; i <= len; i++) {
            backtracking(i, numbers);
        }

        int max = probableNums.stream().max(Integer::compareTo).get();
        boolean[] isNotPrime = new boolean[max + 1];
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i <= max; i++) {
            if(!isNotPrime[i]) {
                int idx = 2;
                int num = i * idx;
                while (num <= max) {
                    isNotPrime[num] = true;
                    num = i * idx++;
                }
            }
        }

        for (Integer probableNum : probableNums) {
            if(!isNotPrime[probableNum]) {
                answer++;
            }
        }

        return answer;
    }

    private void backtracking(int maxDepth, String numbers) {
        if (sb.length() == maxDepth) {
            int number = Integer.parseInt(sb.toString());
            if(!probableNums.contains(number)) {
                probableNums.add(number);
            }
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if(visited[i])
                continue;

            sb.append(numbers.charAt(i));
            visited[i] = true;
            backtracking(maxDepth, numbers);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}