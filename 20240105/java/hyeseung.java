import java.io.*;

// 16352KB, 124ms
public class B9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String firstString = br.readLine();
        int firstStringLength = firstString.length();
        String secondString = br.readLine();
        int secondStringLength = secondString.length();
        int[][] dp = new int[firstStringLength+1][secondStringLength+1];

        for (int i = 1; i <= firstStringLength; i++) {
            for (int j = 1; j <= secondStringLength; j++) {
                // 같은 문자가 존재하면
                if(firstString.charAt(i-1) == secondString.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                // 문자가 같지 않으면
                else if(firstString.charAt(i-1) != secondString.charAt(j-1)) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        bw.write(dp[firstStringLength][secondStringLength] + "\n" + findLCS(dp, firstString, firstStringLength, secondStringLength));
        bw.flush();
        bw.close();
        br.close();
    }
    // LCS 찾기
    public static StringBuilder findLCS(int[][] dp, String firstString, int firstStringLength, int secondStringLength) {
        StringBuilder LCS = new StringBuilder();
        int firstIndex = firstStringLength, secondIndex = secondStringLength;
        while(dp[firstIndex][secondIndex] != 0) {
            // dp[firstIndex-1][secondIndex]랑 dp[firstIndex][secondIndex-1] 중에 같은 것이 있으면 이동
            if(dp[firstIndex-1][secondIndex] == dp[firstIndex][secondIndex]) {
                firstIndex--;
            }
            else if(dp[firstIndex][secondIndex-1] == dp[firstIndex][secondIndex]) {
                secondIndex--;
            }
            // 같은 것이 없으면 LCS에 해당 문자 추가 dp[firstIndex-1][secondIndex-1] 이동
            else {
                LCS.insert(0, firstString.charAt(firstIndex-1)); // 역순이므로 첫번째에 삽입
                firstIndex--; secondIndex--;
            }
        }
        return LCS;
    }
}
/*
dp
-> 별도 정리
 */