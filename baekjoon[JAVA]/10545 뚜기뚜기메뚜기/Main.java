import java.io.*;
import java.util.*;

public class Main {
    private static final Map<Character, int[]> KEY_MAP = Map.ofEntries(
        Map.entry('a', new int[]{2, 1}),
        Map.entry('b', new int[]{2, 2}),
        Map.entry('c', new int[]{2, 3}),
        Map.entry('d', new int[]{3, 1}),
        Map.entry('e', new int[]{3, 2}),
        Map.entry('f', new int[]{3, 3}),
        Map.entry('g', new int[]{4, 1}),
        Map.entry('h', new int[]{4, 2}),
        Map.entry('i', new int[]{4, 3}),
        Map.entry('j', new int[]{5, 1}),
        Map.entry('k', new int[]{5, 2}),
        Map.entry('l', new int[]{5, 3}),
        Map.entry('m', new int[]{6, 1}),
        Map.entry('n', new int[]{6, 2}),
        Map.entry('o', new int[]{6, 3}),
        Map.entry('p', new int[]{7, 1}),
        Map.entry('q', new int[]{7, 2}),
        Map.entry('r', new int[]{7, 3}),
        Map.entry('s', new int[]{7, 4}),
        Map.entry('t', new int[]{8, 1}),
        Map.entry('u', new int[]{8, 2}),
        Map.entry('v', new int[]{8, 3}),
        Map.entry('w', new int[]{9, 1}),
        Map.entry('x', new int[]{9, 2}),
        Map.entry('y', new int[]{9, 3}),
        Map.entry('z', new int[]{9, 4})
    );

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> mixedKeyMap = new HashMap<>();
        StringBuilder answer = new StringBuilder();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i < 10; i++) {
            mixedKeyMap.put(Integer.parseInt(stk.nextToken()), i);
        }

        String word = br.readLine();
        
        int bindingNum = 0;
        int prevNum = -1;
        for (char c : word.toCharArray()) {
            int[] key = KEY_MAP.get(c);
            bindingNum = mixedKeyMap.get(key[0]);
            int iter = key[1];

            if(prevNum == bindingNum) answer.append("#");
            prevNum = bindingNum;

            for (int j = 0; j < iter; j++) {
                answer.append(bindingNum);
            }
        }

        System.out.println(answer);
    }
}
