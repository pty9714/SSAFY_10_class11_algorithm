import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
            		// N 입력 받기
			int N = Integer.parseInt(br.readLine());
            		int[] buildings = new int[N];
            		int ans = 0;
            
            		// N 개의 건물 높이 입력 받기
            		StringTokenizer st = new StringTokenizer(br.readLine());
            		for(int i = 0; i < N - 2; i++) {
            			buildings[i] = Integer.parseInt(st.nextToken());
            		}
            
            		for(int i = 2; i < N - 2; i++) {
                			// 좌우 2칸 이내 최대 건물 높이 구하기
                			int max = 0;
             			for(int j = i - 2; j <= i + 2; j++) {
                    				if(j == i) continue;
                				max = Math.max(max, buildings[j]);
                			}
                			// 자신이 최대 건물 높이보다 높다면 조망 확보
                			if(buildings[i] > max) ans += buildings[i] - max;
            		}
            
        			bw.write("#" + test_case + " " + ans + "\n");

		}
        		bw.close();
	}
}