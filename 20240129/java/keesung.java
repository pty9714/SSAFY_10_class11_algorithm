import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        int K = Integer.parseInt(br.readLine());
        int[][] countText = new int[26][text.length()];
        for (int i = 0; i < text.length(); i++) {
            countText[text.charAt(i) - 'a'][i]++;
            for (int j = 0; j < 26; j++) {
                countText[j][i] = i == 0 ? countText[j][i] : countText[j][i] + countText[j][i - 1];
            }
        }

        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            char target = input[0].charAt(0);
            int start = Integer.parseInt(input[1]);
            int end = Integer.parseInt(input[2]);
            int minus = 0;
            if (start > 0) {
                minus = countText[target - 'a'][start - 1];
            }
            System.out.println(countText[target - 'a'][end] - minus);
        }

    }
}

// 누적합
// 근데 왜 50점 이라고 뜨냐?
// 248ms