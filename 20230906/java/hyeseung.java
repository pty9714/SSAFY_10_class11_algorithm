import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;


public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			HashSet<String> nameSet = new HashSet<>();
			for (int j = 0; j < N; j++) {
				nameSet.add(br.readLine());
			}
			ArrayList<String> nameList = new ArrayList<>(nameSet); 
			Collections.sort(nameList, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if(o1.length() == o2.length()) {
						return o1.compareTo(o2);
					}
					return o1.length() - o2.length();
				}
			});
			bw.write("#" + test_case + "\n");
			for (String name : nameList) {
				bw.write(name + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
// 99,096 kb, 665 ms
