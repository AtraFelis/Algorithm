import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean isIncrease = true, isDecrease = true, isSame = true;

        int prevNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(br.readLine());

            if(prevNum > num) {
                isIncrease = false;
                isSame = false;
            } else if(prevNum < num) {
                isDecrease = false;
                isSame = false;
            } else {
                isIncrease = false;
                isDecrease = false;
            }
            prevNum = num;
        }

        if(isIncrease) System.out.println("Fish Rising");
        else if(isDecrease) System.out.println("Fish Diving");
        else if(isSame) System.out.println("Fish At Constant Depth");
        else System.out.println("No Fish");
    }
}