import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 33020KB, 448ms
public class B3020 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] huddle = new int[2][N/2];
        int min = Integer.MAX_VALUE, cnt = 0;
        
        for (int i = 0; i < N/2; i++) {
            huddle[0][i] = Integer.parseInt(br.readLine()); // 석순 (아래)
            huddle[1][i] = Integer.parseInt(br.readLine()); // 종유석 (위)
        }
        
        // 이진 탐색을 위한 정렬
        Arrays.sort(huddle[0]);
        Arrays.sort(huddle[1]);
        
        for (int i = 1; i <= H; i++) {
        	// 이진탐색으로 해당 구간에서 장애물 길이 이상인 것이 처음 나타난 위치
        	int index = binarySearch(huddle[0], i);
        	index += binarySearch(huddle[1], H - i + 1);
        	if(min > N - index) {
        		min = N - index;
        		cnt = 1;
        	}
        	else if(min == N - index) {
        		cnt++;
        	}
        	
        }
        
        bw.write(min + " " + cnt);
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int binarySearch(int[] arr, int key) {
    	int start = 0, end = arr.length, mid;
    	while(start < end) {
    		mid = (start + end) / 2;
    		if(arr[mid] < key) start = mid + 1;
    		else end = mid;
    	}
    	return start;
    }

}