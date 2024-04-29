import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1525 {

    static HashSet<String> hs = new HashSet<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] table = new int[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                table[i][j] = -1;
            }
        }

        for(int i = 1; i <= 3 ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 3; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = -1;

        hs.add(hash(table));
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(hash(table), 0));

        Node curr = null;
        StringBuilder tempSb;
        while (!q.isEmpty()){
            curr = q.poll();
            if(curr.table.equals("123456780")) {
                answer = curr.count;
                break;
            }
            Point zero = findZero(curr.table);
            for(int i = 0; i < 4; i++){
                int nx = zero.x + dx[i];
                int ny = zero.y + dy[i];
                if(nx >= 0 && nx < 3 && ny >= 0 && ny < 3){
                    tempSb = new StringBuilder(curr.table);
                    char temp = tempSb.charAt(zero.x*3 + zero.y);
                    tempSb.setCharAt(zero.x*3 + zero.y, tempSb.charAt(nx*3 + ny));
                    tempSb.setCharAt(nx*3 + ny, temp);
                    if(!hs.contains(tempSb.toString())){
                        hs.add(tempSb.toString());
                        q.offer(new Node(tempSb.toString(), curr.count+1));
                    }
                }
            }
        }
        System.out.println(answer);

    }

    static class Node{
        String table;
        int count;

        Node(String table, int count){
            this.table = table;
            this.count = count;
        }

    }

    static Point findZero(String table){
        for(int i = 0; i < table.length(); i++){
            if(table.charAt(i) == '0') return new Point(i/3, i%3);
        }
        return null;
    }

    static String hash(int[][] table){
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= 3; j++){
                sb.append(table[i][j]);
            }
        }
        return sb.toString();
    }
}
