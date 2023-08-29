import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1052 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        long N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String num = Long.toBinaryString(N);
        int cnt = 0;
        for(int i=0; i<num.length(); i++) {
            if(num.charAt(i)=='1') cnt++;
        }

        int result = 0;
        while(--cnt>=K) {
            int right = 0;
            int left = 0;
            for(int i=num.length()-1; i>=0; i--) {
                if(num.charAt(i)=='1') {
                    if(right==0) right = i;
                    else {
                        left = i;
                        break;
                    }
                } 
            }
            int temp = (int) (Math.pow(2, num.length()-left-1) - Math.pow(2, num.length()-right-1));
            result += temp;
            N += temp;
            num = Long.toBinaryString(N);
        }
        System.out.println(result);
    }
}
