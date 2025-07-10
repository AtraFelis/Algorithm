import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> bioDict = new HashMap<>();
        List<String> plants = new ArrayList<>();

        int cnt = 0;
        String plant;

        while((plant = br.readLine()) != null) {
            cnt++;
            if(!bioDict.containsKey(plant))
                plants.add(plant);
            bioDict.put(plant, bioDict.getOrDefault(plant, 0) + 1);
        }

        Collections.sort(plants);

        for (String p : plants) {
            double per = (double)bioDict.get(p) / cnt * 100;
            sb.append(p).append(" ").append(String.format("%.4f", per)).append('\n');
        }

        System.out.println(sb);
    }
}