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
            countText[text.charAt(i) - 'a'][i] += countText[text.charAt(i) - 'a'][i - 1 > 0 ? i - 1 : 0] + 1;
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

        for (int i = 0; i < text.length(); i++) {
            System.out.print(countText[0][i] + " ");
        }
    }
}