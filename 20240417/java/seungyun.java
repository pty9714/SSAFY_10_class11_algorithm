import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class B13164 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 차이 배열
        int[] gap = new int[n-1];

        for(int i=0; i<n-1; i++){
            gap[i] = arr[i+1] - arr[i];
        }

        // gap 차이 정렬
        Arrays.sort(gap);

        int a = n-k;
        int answer = 0;
        for(int i=0; i<n-k; i++){
            answer += gap[i];
        }

        System.out.println(answer);
    }

}
