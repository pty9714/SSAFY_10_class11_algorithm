import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1327 {

    static int n;
    static int k;
    static PriorityQueue<Node> pq;
    static HashMap<String, Boolean> hm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        StringBuilder answer_string = new StringBuilder();

        for(int i = 1; i <= n; i++){
            answer_string.append(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            sb.append(st.nextToken());
        }

        pq = new PriorityQueue<>((n1, n2)->n1.depth-n2.depth);
        hm = new HashMap<>();
        pq.offer(new Node(0, sb.toString()));
        hm.put(sb.toString(), true);

        int answer = -1;

        Node curr = null;
        String swap_string;

        while (!pq.isEmpty()){
            curr = pq.poll();
            if(curr.s.contentEquals(answer_string)){
                answer = curr.depth;
                break;
            }
            for(int i = 0; i <= n-k; i++){
                swap_string = swap(curr.s, i);
                if(hm.get(swap_string) == null || !hm.get(swap_string)){
                    hm.put(swap_string, true);
                    pq.offer(new Node(curr.depth+1, swap_string));
                }
            }
        }

        System.out.println(answer);
    }

    public static class Node{
        int depth;
        String s;

        Node(int depth, String s){
            this.depth = depth;
            this.s = s;
        }
    }

    public static String swap(String s, int idx){
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < (k/2); i++){
            char temp = s.charAt(idx+i);
            sb.setCharAt(idx+i, s.charAt(idx+k-i-1));
            sb.setCharAt(idx+k-i-1, temp);
        }
        return sb.toString();
    }
}
