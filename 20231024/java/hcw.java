import java.io.*;
import java.util.*;

public class Main {
	
	private static long calculateCost(long watt) {
		long cost = 0;
		if(watt > 100) {
			cost += 200;
			watt -= 100;
			if(watt > 9900) {
				cost += 29700;
				watt-= 9900;
				if(watt > 990000) {
					cost += 4950000;
					watt -= 990000;
					cost += watt * 7;
				}else {
					cost += watt * 5;
				}
			}else {
				cost += watt * 3;
			}
		}else {
			cost += watt * 2;
		}

		return cost;
	}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			long a = Integer.parseInt(st.nextToken());
			long b = Integer.parseInt(st.nextToken());
			if(a == 0 && b == 0) break;
		
			long temp = a;
			long totalWatt = 0;

			if(200 < a) {
				totalWatt = 100;
				temp -= 200;
				if(29700 < temp) {
					totalWatt = 10000;
					temp -= 29700;
					if(4950000 < temp) {
						totalWatt = 1000000;
						temp -= 4950000;
						totalWatt += temp / 7;
					}else {
						totalWatt += temp/5;
					}
				}else {
					totalWatt += temp / 3; 
				}
			}else {
				totalWatt += temp / 2;
			}
			
			
			long s = 0;
			long e = totalWatt;
			long m = 0;
			
			
			long answer = 0;
			while(s <= e) {
				m = (s+e) / 2;
				if(Math.abs(calculateCost(m) - calculateCost(totalWatt - m)) > b) {
					s = m+1;
				}else if(Math.abs(calculateCost(m) - calculateCost(totalWatt - m)) < b) {
					e = m -1;
				} else { // 정답이라면
					answer = Math.min(calculateCost(totalWatt - m), calculateCost(m));
					break;
				}
			}
			
			sb.append(answer + "\n");
		}

		System.out.println(sb);

	}

}


11944kb	88ms
