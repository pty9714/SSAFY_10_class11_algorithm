import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1062 {

    static int n, k;
    static int visited = 0;
    static ArrayList<Integer> words;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        visited |= 1 << 'a'-'a';
        visited |= 1 << 'n'-'a';
        visited |= 1 << 't'-'a';
        visited |= 1 << 'i'-'a';
        visited |= 1 << 'c'-'a';

        words = new ArrayList<>();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int always_answer = 0;

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            String substring =  s.substring(4, s.length()-4);
            if(substring.equals("")) {
                always_answer++;
                continue;
            }
            int word = 0;
            for(int j = 0; j < substring.length(); j++){
                word |= 1 << (substring.charAt(j)-'a');
            }
            words.add(word);
        }

        if (k < 5) {
            System.out.println(0);
            return;
        }
        if (k == 26){
            System.out.println(n);
            return;
        }

        combination(0, 1);

        System.out.println(answer + always_answer);

    }

    static void combination(int d, int start){
        if(d == k-5){
            int cnt = 0;
            for(int word : words){
                if((word&visited) == word) cnt++;
            }
            answer = Math.max(answer, cnt);
            return;
        }
        for(int i = start; i < 26; i++){
            if((visited & (1 << i)) != 0) continue;
            visited |= (1 << i);
            combination(d+1, i+1);
            visited ^= (1<<i);
        }
    }
}
