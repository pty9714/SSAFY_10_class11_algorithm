import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		LinkedList<Integer> list = new LinkedList<>();
		int j = 1;
		for (int i = 1; i <= 10000; i += j) {
			list.add(i);
			j++;
		}
		list.add(10000);
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int Afloor = -1;
			int[] aArr = { a, a };
			int Bfloor = -1;
			int[] bArr = { b, b };
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) >= a && Afloor == -1)
					Afloor = i;
				if (list.get(i) >= b && Bfloor == -1)
					Bfloor = i;
			}
			
			if (Afloor >= Bfloor) {
				j = Bfloor+1;
				for (int i = 1; i <= Afloor - Bfloor; i++) {
					bArr[0] += j;
					bArr[1] = bArr[0] + i;
					j++;
				}
				
				if(a < bArr[0]) {
					sb.append("#" + t + " " + ((Afloor-Bfloor) + bArr[0] - a) + "\n");
				}else if(a > bArr[1]) {
					sb.append("#" + t + " " + ((Afloor-Bfloor) + a - bArr[1]) + "\n");
				}else {
					sb.append("#" + t + " " + (Afloor-Bfloor) + "\n");
				}

			} else {
				j = Afloor+1;
				for (int i = 1; i <= Bfloor - Afloor; i++) {
					aArr[0] += j;
					aArr[1] = aArr[0] + i;
					j++;
				}
				
				if(b < aArr[0]) {
					sb.append("#" + t + " " + ((Bfloor-Afloor) + aArr[0] - b) + "\n");
				}else if(b > aArr[1]) {
					sb.append("#" + t + " " + ((Bfloor-Afloor) + b - aArr[1]) + "\n");
				}else {
					sb.append("#" + t + " " + (Bfloor-Afloor) + "\n");
				}
				
			}
		}
		System.out.println(sb);
	}
}

20,788 kb
140 ms
