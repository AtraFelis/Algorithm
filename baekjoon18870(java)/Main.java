import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] coordinateCompression = new int[n];
        int[] sorted = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");


        for (int i = 0; i < n; i++) {
            int currentPos = Integer.parseInt(stk.nextToken());
            coordinateCompression[i] = currentPos;
            sorted[i] = currentPos;
        }

        Arrays.sort(sorted);

        int rank = 0;
        for(int i : sorted)
            if(!map.containsKey(i))
                map.put(i, rank++);

        for(int i : coordinateCompression)
            sb.append(map.get(i) + " ");

        System.out.println(sb);
    }
}