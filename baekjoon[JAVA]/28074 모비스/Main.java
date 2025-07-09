import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        boolean[] alpha = new boolean[26];
        for (char c : str.toCharArray()) {
            alpha[c - 'A'] = true;
        }
        
        boolean flag = true;
        for (char c : ("MOBIS").toCharArray()) {
            if(!alpha[c - 'A'])
                flag = false;
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");

        sc.close();
    }
}