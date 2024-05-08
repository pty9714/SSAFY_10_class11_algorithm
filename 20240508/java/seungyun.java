import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int max = 0;
        int[] arr = new int[n];
        int[] check = new int[d+1];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int res = 1;
        check[c]++; // 쿠폰 체크

        for(int i=0; i<k; i++) {
            // 연속된거 추가
            if(check[arr[i]] == 0){
                res++;
            }
            check[arr[i]]++;
        }

        int cnt = res;

        for(int i=1; i<n; i++){
            int front = arr[i-1];
            check[front]--;
            if(check[front] == 0){ // 앞에서 뺴고 갯수도 빼줌
                cnt--;
            }
            int back = arr[(i+k-1)%n];
            if(check[back] == 0){
                cnt++;
            }
            check[back]++;
            // 비교
            res = Math.max(res,cnt);
        }

        System.out.println(res);
    }

}
