import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text1 = br.readLine();
        String text2 = br.readLine();

        int[][] lcs = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                }
            }
        }

        int i = text1.length();
        int j = text2.length();
        String answer = "";
        while (i > 0 && j > 0) {
            if (lcs[i][j] == lcs[i - 1][j]) {
                i--;
            } else if (lcs[i][j] == lcs[i][j - 1]) {
                j--;
            } else {
                answer = text1.charAt(i - 1) + answer;
                i--;
                j--;
            }
        }

        System.out.println(lcs[text1.length()][text2.length()]);
        if (lcs[text1.length()][text2.length()] != 0) {
            System.out.println(answer);
        }
    }

}

// 답지
// 처음에 String[][][] 배열로 해서 제출하니 메모리 초과나서 답지 확인
// dp에 String 기록 하는게 아니라 다시 while문을 통해서 찾는 거였음.