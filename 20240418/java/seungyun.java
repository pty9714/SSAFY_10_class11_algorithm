import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
// 풀이
// 누적합으로 배열을 구해서 S가 초과한다면 left를 증가시켜서 누적배열이 S이상이 되는 것 중에서 최솟값을 구하려고함

public class B1806 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[n];
        sum[0] = arr[0];

        for(int i=0; i<arr.length-1; i++){
            sum[i+1] = sum[i] + arr[i+1];
        }

        int min = Integer.MAX_VALUE;
        int len = 0;

        int left = 0;
        int right = 0;

        int result = 0;
        while(right < n){
            len = right - left;
            if(sum[len] < s){
                right++;
                result = sum[len];
            } else{
                left++;
                result = sum[len];

            }

            System.out.println(len);
        }

        if(min == Integer.MAX_VALUE) {
            min = 0;
        }
        System.out.println("answer: " + min);

    }

}
