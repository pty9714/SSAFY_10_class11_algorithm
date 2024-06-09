import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] alpha = new int[26];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            int len = str.length()-1;

            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                int index = c - 'A'; // 알파벳 위치
                alpha[index] += (int) Math.pow(10, len);
                len--;
            }
        }
//        for(int al : alpha){
//            System.out.println(al);
//        }
        Arrays.sort(alpha);

        int index = alpha.length -1;
        int max = 9;
        int sum = 0;

        while (max >= 0 && alpha[index] > 0){
            sum += alpha[index] * max;
            max--;
            index--;
        }

        System.out.println(sum);
    }
}