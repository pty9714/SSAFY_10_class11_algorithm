
import java.util.*;
import java.io.*;

public class BaekJoon1253 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < N ; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);
        int result = 0;
        for(int i = 0 ; i < N ; i++){
            int left = 0;
            int right = N-1;    // 음수값이 있음에 유의!
            while(true){
                // 현재 나(i)의 위치에 있는 경우
                if(left == i) left++;
                else if(right == i) right--;

                // 결과를 찾을 수 없다.
                if(left >= right) break;

                if(numbers[left] + numbers[right] > numbers[i]) right--;
                else if(numbers[left] + numbers[right] < numbers[i]) left++;
                else{
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }

}
