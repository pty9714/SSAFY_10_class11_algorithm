import java.io.*;
import java.util.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];
		for(int i =0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(temp[0]);
			arr[i][1] = Integer.parseInt(temp[1]);
			arr[i][2] = Integer.parseInt(temp[2]);
		}
		
		Arrays.sort(arr, (el1, el2) -> {
			if(el1[1] == el2[1]) return el1[2] - el2[2];
			return el1[1] - el2[1];
		});
		
		PriorityQueue<Integer> room = new PriorityQueue<>();
		int max = 1;
		room.add(arr[0][2]);
		for(int j =1; j < arr.length; j++) {
			if(room.peek() <= arr[j][1]) {
				room.poll();
				room.add(arr[j][2]);
			}else {
				room.add(arr[j][2]);
				max += 1;
			}
		}
		
		System.out.println(max);
	}

}
	73748kb	908ms
