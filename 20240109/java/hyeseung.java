import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 13016KB, 168ms
public class B1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ans = 0;
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num); // 정렬
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;
            while(left < right) {
                // i 번째 인덱스랑 같으면 조절
                if(left == i) left++;
                else if(right == i) right--;
                else if(num[left] + num[right] < num[i]) { // 양쪽 인덱스 위치의 합이 i번째 인덱스보다 작으면
                    left++; // 왼쪽 인덱스 증가
                }
                else if(num[left] + num[right] > num[i]) { // 양쪽 인덱스 위치의 합이 i번째 인덱스보다 크면
                    right--; // 오른쪽 인덱스 감소
                }
                else if(num[left] + num[right] == num[i]) { // 양쪽 인덱스 위치의 합이 i번째 인덱스와 같으면
                    ans++; // GOOD
                    break;
                }
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
투포인터
-> 정렬 후 양쪽 인덱스를 조절한다.
   양쪽 인덱스 위치의 합이 현재보다 작으면 왼쪽 인덱스를 증가시켜 합이 커지도록 하고, 현재보다 크면 오른쪽 인덱스를 감소시켜 합이 작아지도록 함.
   같은 경우가 있다면 GOOD!!
 */
