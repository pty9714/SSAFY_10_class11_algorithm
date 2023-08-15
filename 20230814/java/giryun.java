import java.io.*;
import java.util.*;

public class giryun {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        
        HashMap<Character, Character[]> dic = new HashMap<>();
        dic.put(')', new Character[] {'(', 2});
        dic.put(']', new Character[] {'[', 3});
        
        Stack<Object> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else {
                ArrayList<Object> tmp = new ArrayList<>();
                while (true) {
                    if (stack.isEmpty()) {
                        bw.write("0\n");
                        bw.flush();
                        System.exit(0);
                    }
                    Object top = stack.pop();
                    if (top instanceof Character && ((char) top == dic.get(c)[0])) {
                        int sum = 0;
                        if (!tmp.isEmpty()) {
                            for (Object num : tmp) {
                                sum += (int) num;
                            }
                        }
                        int value = dic.get(c)[1] * (sum == 0 ? 1 : sum);
                        stack.push(value);
                        break;
                    } else if (top instanceof Integer) {
                        tmp.add(top);
                    } else {
                        bw.write("0\n");
                        bw.flush();
                        System.exit(0);
                    }
                }
            }
        }
        
        int sum = 0;
        for (Object c : stack) {
            if (c instanceof Character) {
                bw.write("0\n");
                bw.flush();
                System.exit(0);
            }
            sum += (int) c;
        }
        
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
// 메모리 >> 16308 KB, 시간 >> 172 ms