import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			Set<String> set = new HashSet<>();
			int N = Integer.parseInt(br.readLine());
			for(int i =0 ; i< N; i++) {
				set.add(br.readLine());
			}
			List<String> list = new ArrayList<>(set);
			
			Collections.sort(list, (el1, el2) -> {
				if(el1.length() != el2.length()) {
					return el1.length() - el2.length();
				}else {
					return el1.compareTo(el2);
				}
			});
			sb.append("#" + t + "\n");
			for(String s : list) {
				sb.append(s + "\n");
			}

		}
		System.out.println(sb);
	}
}

159,584 kb
855 ms
