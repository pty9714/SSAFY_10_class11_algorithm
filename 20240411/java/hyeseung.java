import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
// 243328KB, 856ms
public class B27171 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] cards = new int[N][2];
        int max = 0;
        HashMap<Integer, Integer> cardInfo = new HashMap<>();
        for (int i = 0; i < N; i++) {
            cards[i][0] = Integer.parseInt(st.nextToken());
            cards[i][1] = 0; // 점수
            cardInfo.put(cards[i][0], i);
            max = Math.max(cards[i][0], max);
        }
        for(int[] card : cards) {
            for(int j = card[0] * 2; j <= max; j += card[0]) {
                if(!cardInfo.containsKey(j)) continue;
                card[1]++;
                cards[cardInfo.get(j)][1]--;
            }
        }

        for (int[] card : cards) {
            bw.write(card[1] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
