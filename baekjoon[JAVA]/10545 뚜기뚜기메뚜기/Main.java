import java.io.*;
import java.util.*;

public class Main {
    private static final Map<Character, String> KEY_MAP = Map.ofEntries(
        Map.entry('a', "21"),
        Map.entry('b', "22"),
        Map.entry('c', "23"),
        Map.entry('d', "31"),
        Map.entry('e', "32"),
        Map.entry('f', "33"),
        Map.entry('g', "41"),
        Map.entry('h', "42"),
        Map.entry('i', "43"),
        Map.entry('j', "51"),
        Map.entry('k', "52"),
        Map.entry('l', "53"),
        Map.entry('m', "61"),
        Map.entry('n', "62"),
        Map.entry('o', "63"),
        Map.entry('p', "71"),
        Map.entry('q', "72"),
        Map.entry('r', "73"),
        Map.entry('s', "74"),
        Map.entry('t', "81"),
        Map.entry('u', "82"),
        Map.entry('v', "83"),
        Map.entry('w', "91"),
        Map.entry('x', "92"),
        Map.entry('y', "93"),
        Map.entry('z', "94")
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
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            String key = KEY_MAP.get(c);
            bindingNum = mixedKeyMap.get(Integer.parseInt(key.substring(0, 1)));
            int iter = Integer.parseInt(key.substring(1));

            if(prevNum == bindingNum) answer.append("#");
            prevNum = bindingNum;

            for (int j = 0; j < iter; j++) {
                answer.append(bindingNum);
            }
        }

        System.out.println(answer);
    }
}
