import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B12869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[3];

        arr[0] = arr[1] = arr[2] = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cnt-o2.cnt);

        pq.offer(new Node(arr[0], arr[1], arr[2], 0));

        HashSet<Integer> hs = new HashSet<>();
        hs.add(hashing(arr[0], arr[1], arr[2]));

        Node curr = null;
        while(!pq.isEmpty()){
            curr = pq.poll();
            if(curr.scv[0] <= 0 && curr.scv[1] <= 0 && curr.scv[2] <= 0){
                System.out.println(curr.cnt);
                break;
            }
            if(!hs.contains(hashing(curr.scv[0]-9, curr.scv[1]-3, curr.scv[2]-1))){
                pq.offer(new Node(curr.scv[0]-9, curr.scv[1]-3, curr.scv[2]-1, curr.cnt+1));
                hs.add(hashing(curr.scv[0]-9, curr.scv[1]-3, curr.scv[2]-1));
            }
            if(!hs.contains(hashing(curr.scv[0]-9, curr.scv[1]-1, curr.scv[2]-3))){
                pq.offer(new Node(curr.scv[0]-9, curr.scv[1]-1, curr.scv[2]-3, curr.cnt+1));
                hs.add(hashing(curr.scv[0]-9, curr.scv[1]-1, curr.scv[2]-3));
            }
            if(!hs.contains(hashing(curr.scv[0]-3, curr.scv[1]-9, curr.scv[2]-1))){
                pq.offer(new Node(curr.scv[0]-3, curr.scv[1]-9, curr.scv[2]-1, curr.cnt+1));
                hs.add(hashing(curr.scv[0]-3, curr.scv[1]-9, curr.scv[2]-1));
            }
            if(!hs.contains(hashing(curr.scv[0]-3, curr.scv[1]-1, curr.scv[2]-9))){
                pq.offer(new Node(curr.scv[0]-3, curr.scv[1]-1, curr.scv[2]-9, curr.cnt+1));
                hs.add(hashing(curr.scv[0]-3, curr.scv[1]-1, curr.scv[2]-9));
            }
            if(!hs.contains(hashing(curr.scv[0]-1, curr.scv[1]-9, curr.scv[2]-3))){
                pq.offer(new Node(curr.scv[0]-1, curr.scv[1]-9, curr.scv[2]-3, curr.cnt+1));
                hs.add(hashing(curr.scv[0]-1, curr.scv[1]-9, curr.scv[2]-3));
            }
            if(!hs.contains(hashing(curr.scv[0]-1, curr.scv[1]-3, curr.scv[2]-9))){
                pq.offer(new Node(curr.scv[0]-1, curr.scv[1]-3, curr.scv[2]-9, curr.cnt+1));
                hs.add(hashing(curr.scv[0]-1, curr.scv[1]-3, curr.scv[2]-9));
            }
        }

    }

    static int hashing(int a, int b, int c){
        return a*10000 + b*100 + c;
    }

    static class Node{
        int[] scv;
        int cnt;
        Node(int a, int b, int c, int cnt){
            this.scv = new int[3];
            scv[0] = a;
            scv[1] = b;
            scv[2] = c;
            this.cnt = cnt;
        }
    }
}
