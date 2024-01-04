import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = " " + br.readLine();
        String str2 = " " + br.readLine();
        int[][] dp = new int[str1.length()][str2.length()];
        int max = 0;
        int x = 0;
        int y = 0;

        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
                if(max < dp[i][j]){
                    max = dp[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println(max);
        if(max == 0) return;

        String answer = "";
        while(dp[x][y] > 0){
            if(dp[x][y] == dp[x-1][y]){
                x--;
            }
            else if(dp[x][y] == dp[x][y-1]){
                y--;
            }
            else {
                answer = str1.charAt(x) + answer;
                x--;
                y--;
            }
        }
        System.out.println(answer);
    }
}

/*
    19252KB	144ms

    0 A C A Y K P
    C 0 0 1 1 1 1
    A 0 1 1 2 2 2
    P 0 1 1 2 2 3
    C 0 1 2 2 2 3
    A 0 1 2 3 3 3
    K 0 1 2 3 3 4

    max부터 위, 왼쪽으로 이동할 수 없으면 String에 추가하고 대각선으로 이동
 */
