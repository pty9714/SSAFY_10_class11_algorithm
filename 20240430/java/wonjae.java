import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class B1972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

next:   while(true){
            String s = br.readLine();
            if(s.equals("*")) break;
            int s_len = s.length();

            for(int i = 1; i < s_len; i++){
                HashSet<Integer> hs = new HashSet<>();
                for(int j = 0; j + i < s_len; j++){
                    int hash = (s.charAt(j)-'A') * 100 + (s.charAt(j+i)-'A');
                    if(hs.contains(hash)) {
                        sb.append(s).append(" is NOT surprising.").append('\n');
                        continue next;
                    }
                    hs.add(hash);
                }
            }
            sb.append(s).append(" is surprising.").append('\n');
        }
        System.out.println(sb.toString());
    }
}
