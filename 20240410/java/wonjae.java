import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2224 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Point> al = new ArrayList<>();

        Node[] nodes = new Node[52];
        for(int i = 0; i < 26; i++){
            nodes[i] = new Node(i, (char)('A'+i));
        }
        for(int i = 0; i < 26; i++){
            nodes[i+26] = new Node(i+26, (char) ('a'+i));
        }
        int n = Integer.parseInt(st.nextToken());

        int x, y;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            st.nextToken();
            char b = st.nextToken().charAt(0);
            if(a >= 'a') x = a-'a'+26;
            else x = a-'A';
            if(b >= 'a') y = b-'a'+26;
            else y = b-'A';
            nodes[x].hs.add(y);
        }

        for(Node node : nodes){
            int start = node.i;
            int curr = start;
            Queue<Integer> q = new LinkedList<>();
            q.offer(curr);
            boolean[] visited = new boolean[52];
            visited[curr] = true;

            while (!q.isEmpty()){
                curr = q.poll();
                for(int h : nodes[curr].hs){
                    if(!visited[h]){
                        visited[h] = true;
                        al.add(new Point(start, h));
                        q.offer(h);
                    }
                }
            }
        }

        al.sort((p1, p2) -> {
            if (p1.x != p2.x) return p1.x-p2.x;
            return p1.y-p2.y;
        });

        System.out.println(al.size());

        for(Point p : al){
            System.out.println(nodes[p.x].c + " => " + nodes[p.y].c);
        }
    }

    static class Node{
        char c;
        int i;
        HashSet<Integer> hs;
        Node(int i, char c){
            this.i = i;
            this.c =c;
            this.hs = new HashSet<>();
        }
    }
}
