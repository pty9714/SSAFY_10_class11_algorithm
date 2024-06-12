import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer> plus;
    static ArrayList<Integer> minus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        plus = new ArrayList<>();
        minus = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int k = Integer.parseInt(st.nextToken());
            if(k < 0){
                minus.add(k);
            } else{
                plus.add(k);
            }
        }
        // -39 -37 -29 -28 -6
        Collections.sort(minus);
        // 11 6 5 4 3
        Collections.sort(plus, Comparator.reverseOrder());

        int left = 0;
        if(minus.size() > 0){
            left = Math.abs(minus.get(0));
        }
        int right = 0;
        if(plus.size() > 0){
            right = plus.get(0);
        }
        int leftStart = M;
        int rightStart = M;
        if(left < right){
            left = 0;
            leftStart = 0;
        } else{
            right = 0;
            rightStart = 0;
        }
        // Minus
        for(int i=leftStart; i<minus.size(); i+=M){
            left += Math.abs(minus.get(i)) * 2;
        }

        // Plus
        for(int i=rightStart; i<plus.size(); i+=M){
            right += plus.get(i) * 2;
        }

        System.out.println(left + right);
    }
}
