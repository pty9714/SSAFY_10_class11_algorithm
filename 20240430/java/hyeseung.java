import java.io.*;
import java.util.HashSet;

// 11960KB, 88ms
public class B1972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        while(true) {
            String input = br.readLine();
            if(input.equals("*")) break;
            int N = input.length();
            boolean flag = false;
            for (int i = 1; i < N; i++) {
                set.clear();
                for (int j = 0; j + i < N; j++) {
                    String dPair = input.charAt(j) + "" + input.charAt(j + i);
                    if(set.contains(dPair)) {
                        flag = true;
                        break;
                    }
                    else {
                        set.add(dPair);
                    }
                }
                if(flag) break;
            }
            sb.append(input).append(" is ");
            if(flag) {
                sb.append("NOT ");
            }
            sb.append("surprising.\n");
        }
        System.out.print(sb);
        br.close();
    }
}
