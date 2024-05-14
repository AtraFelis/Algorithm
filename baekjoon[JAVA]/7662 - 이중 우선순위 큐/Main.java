import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        TreeMap<Integer, Integer > tree = new TreeMap<>();

        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            tree.clear();
            int K = Integer.parseInt(bf.readLine());

            for (int i = 0; i < K; i++) {
                stk = new StringTokenizer(bf.readLine());

                String cmd = stk.nextToken();
                int arg = Integer.parseInt(stk.nextToken());

                if(cmd.equals("I")) {
                    tree.put(arg, tree.getOrDefault(arg, 0) + 1);
                }
                else if(cmd.equals("D")) {
                    if(!tree.isEmpty()) {
                        int key = arg == -1 ? tree.firstKey() : tree.lastKey();
                        if(tree.get(key) == 1) {
                            tree.remove(key);
                        } else {
                            tree.put(key, tree.get(key) - 1);
                        }
                    }
                }
            }

            if(tree.isEmpty()) System.out.println("EMPTY");
            else System.out.println(tree.lastKey() + " " + tree.firstKey());
        }
    }
}