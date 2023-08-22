import java.io.*;
import java.util.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split("");
		String[] s2 = br.readLine().split("");
		
		
		int[][] arr = new int[s1.length+1][s2.length+1];
		
		for(int i =1; i <= s1.length; i++) {
			for(int j =1;j <= s2.length; j++) {
				if(s1[i-1].equals(s2[j-1])) {
					arr[i][j] = arr[i-1][j-1] + 1;
				}else {
					arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
				}
			}
		}
		
		System.out.println(arr[s1.length][s2.length]);
		
	}

}


16304kb	132ms
