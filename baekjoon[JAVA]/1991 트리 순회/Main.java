import java.io.*;
import java.util.*;

public class Main {

    static void preorder(int idx) {
        if(tree[idx] == '.') return;

        result.append(tree[idx]);
        preorder(idx * 2);
        preorder(idx*2 + 1);
    }
    static void inorder(int idx) {
        if(tree[idx] == '.')
            return;
        inorder(idx * 2);
        result.append(tree[idx]);
        inorder(idx * 2 + 1);
    }

    static void postorder(int idx) {
        if(tree[idx] == '.')
            return;
        postorder(idx*2);
        postorder(idx *2 + 1);
        result.append(tree[idx]);
    }
    static char[] tree;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(bf.readLine());

        char parent, left, right;
        tree = new char[(int) Math.pow(2, n+1) + 1];
        // 마지막 단말 노드의 자식에 들어가는 '.'도 있으므로 n+1
        Map<Character, Integer> index_map = new HashMap<>();

        int idx = 1;
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine());
            parent = stk.nextToken().charAt(0);
            left = stk.nextToken().charAt(0);
            right = stk.nextToken().charAt(0);

            idx = index_map.getOrDefault(parent, 1);

            tree[idx] = parent;
            index_map.put(parent, idx);
            tree[idx * 2] = left;
            index_map.put(left, idx*2);
            tree[idx * 2 + 1] = right;
            index_map.put(right, idx*2+1);
        }

        preorder(1);
        result.append('\n');
        inorder(1);
        result.append('\n');
        postorder(1);

        System.out.println(result);
    }
}