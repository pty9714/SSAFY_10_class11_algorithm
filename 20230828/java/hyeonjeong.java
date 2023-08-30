import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S15231 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            String n = Integer.toBinaryString(N); // 마지막 정점 (전체 깊이)
            String v = Integer.toBinaryString(V);  // 시작 정점 (시작 깊이)

            int result = 0;
            if(V==1) {  // 루트 노드일 땐 전체 깊이만큼
                result += (n.length()-1);
            } else if(v.charAt(1)=='0' && n.charAt(1)=='0') {  // 왼쪽에서 시작하고 마지막 오른쪽 존재하지 않을 때 -1
                result += (v.length()-1) + (n.length()-2);
            } else {  // 나머지 경우는 전체 깊이 + 시작 깊이
                result += (v.length()-1) + (n.length()-1);
            }
        
            sb.append("#"+tc+" "+result+"\n");
        }
        System.out.println(sb.toString());
    }
}
// 93,340 kb 297 ms
