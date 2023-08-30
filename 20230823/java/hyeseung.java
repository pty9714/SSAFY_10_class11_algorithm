import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 16132KB, 116ms	
public class B9251 {
	
	public static int sub[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		sub = new int[s1.length() + 1][s2.length() + 1]; 
		
		int ans = findSubSeuquence(s1, s2);
		bw.write(String.valueOf(ans));
		
		bw.flush();
		bw.close();
		br.close();
	}

	private static int findSubSeuquence(String s1, String s2) {
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) { // 같은 문자라면 첫번째 문자 이전 문자와 두번째 문자 이전 문자 값에 +1
					sub[i][j] = sub[i-1][j-1] + 1;
				}
				else {
					sub[i][j] = Math.max(sub[i-1][j], sub[i][j-1]); // // 다른 문자라면 첫번째 문자 이전 문자와 두번째 문자 값, 첫번째 문자와 두번째 문자 이전 문자 값 중 최댓값
				}
			}
		}
		return sub[s1.length()][s2.length()];
	}

}
