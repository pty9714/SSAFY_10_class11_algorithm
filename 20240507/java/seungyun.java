import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.IOException;
public class B1911 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i][0] = start;
            arr[i][1] = end;
        }

        // 시작 기준으로 정렬
        Arrays.sort(arr, new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int answer = 0;
        int range = 0;
        for(int i=0; i<n; i++){
            // 시작점이 덮을 수 있는 널빤지보다 크다면
            if(arr[i][0] > range){
                range = arr[i][0]; // 범위 = 시작점
            }
            // 끝점이 널빤지범위보다 크다면
            if(arr[i][1] >= range){
                // 끝점이 초과할때까지 범위를 널빤지만큼 추가시켜준다.
                // 널빤지도 추가
                while (arr[i][1] > range){ 
                    range += l;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

}
