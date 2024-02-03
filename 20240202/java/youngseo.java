import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon2473 {

    static int n;
    static long[] map;
    static long[] pick = new long[3];
    static long max = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            map[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(map);
        for(int i=0; i<n-2; i++)
            solution(map, i);
        
        for(int i=0; i<3; i++)
            System.out.print(pick[i] + " ");

    }
    
    static void solution(long[] arr, int index){
        int left = index+1;
        int right = arr.length-1;
        
        while(left<right){
            long sum = arr[left] + arr[right] + arr[index];
            long absSum = Math.abs(sum);
            
            if(absSum < max){
                pick[0] = arr[left];
                pick[1] = arr[index];
                pick[2] = arr[right];
                max = absSum;
            }
            
            if(sum>0) right--;
            else left++;

        }
        
    }

}
