import java.util.*;
import java.io.*;

public class keesung {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int N;
        int M;
        String token[];
        Queue<Integer> stack = new LinkedList<>();
        int result;
        int number;
        boolean signal;
        for (int i = 0; i < T; i++){
            stack.clear();
            result = 0;
            token = br.readLine().split(" ");
            N = Integer.parseInt(token[0]);
            M = Integer.parseInt(token[1]);
            token = br.readLine().split(" ");
            for (int j = 0; j < N; j++){
                stack.add(Integer.parseInt(token[j]));
            }

            while (true) {
                signal = true;
//                System.out.println(M);
                number = stack.poll();
                for (Integer integer : stack) {
                    if (number < integer) {
                        signal = false;
                        stack.add(number);
                        break;
                    }
                }
                M--;
//                System.out.println(stack);
//                System.out.println(signal + " " + M);
                if (signal) {
                    result++;
                    if (M == -1) {
                        System.out.println(result);
                        break;
                    }
                } else {
                    if (M < 0) {
                        M = stack.size() - 1;
                    }
                }
            }


        }



    }
}