import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13460 {

    static PriorityQueue<PointPair> pq;
    static HashSet<Integer> hs;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        hs = new HashSet<>();
        pq = new PriorityQueue<>((pp1, pp2)->pp1.depth-pp2.depth);

        Point Blue = null;
        Point Red = null;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'R') {
                    Red = new Point(i,j);
                    map[i][j] = '.';
                }
                if(map[i][j] == 'B') {
                    Blue = new Point(i,j);
                    map[i][j] = '.';
                }
            }
        }

        pq.offer(new PointPair(Red, Blue, 0));
        hs.add(hash(Red,Blue));
        int nf = hash(Red,Blue);
        if(hs.contains(nf+1)){
            System.out.println("yes");
        }

        PointPair curr = null;

        int answer = -1;

label:  while(!pq.isEmpty()){
            curr = pq.poll();
            for(int i = 0; i < 4;i++){
                answer = move(i, curr);
                if(answer != -1) break label;
            }
        }

        System.out.println(answer);
        br.close();
    }

    static int move(int dir, PointPair pp){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean isRedFirst = false;
        switch (dir){
            case 0:
                isRedFirst = pp.red.x < pp.blue.x;
                break;
            case 1:
                isRedFirst = pp.red.x > pp.blue.x;
                break;
            case 2:
                isRedFirst = pp.red.y < pp.blue.y;
                break;
            case 3:
                isRedFirst = pp.red.y > pp.blue.y;
                break;
        }
        boolean isRedOut = false, isBlueOut = false;
        Point first, second;
        if(isRedFirst){
            first = new Point(pp.red.x, pp.red.y);
            second = new Point(pp.blue.x, pp.blue.y);
        }
        else{
            first = new Point(pp.blue.x, pp.blue.y);
            second = new Point(pp.red.x, pp.red.y);
        }
        while (true){
            if(map[first.x+dx[dir]][first.y+dy[dir]] == '#') break;
            if(map[first.x+dx[dir]][first.y+dy[dir]] == '.') {
                first.x += dx[dir];
                first.y += dy[dir];
            }
            else if(map[first.x+dx[dir]][first.y+dy[dir]] == 'O') {
                if(isRedFirst) {
                    isRedOut = true;
                    first.x = -1;
                    first.y = -1;
                    break;
                }
                else return -1;
            }
        }

        while (true){
            if(map[second.x+dx[dir]][second.y+dy[dir]] == 'O'){
                if(!isRedFirst) {
                    isRedOut = true;
                    break;
                }
                else return -1;
            }
            if((first.x == second.x+dx[dir]) &&(first.y == second.y+dy[dir])) break;
            if(map[second.x+dx[dir]][second.y+dy[dir]] == '#') break;
            if(map[second.x+dx[dir]][second.y+dy[dir]] == '.') {
                second.x += dx[dir];
                second.y += dy[dir];
            }
        }

        if(isRedOut) return pp.depth+1;

        int hash;
        if(isRedFirst) hash = hash(first, second);
        else hash = hash(second, first);

        if(!hs.contains(hash) && pp.depth < 9) {
            hs.add(hash);
            if(isRedFirst) pq.offer(new PointPair(first,second,pp.depth+1));
            else pq.offer(new PointPair(second, first, pp.depth+1));
        }
        return -1;
    }

    static class PointPair{
        int depth;
        Point red;
        Point blue;

        PointPair(Point red, Point blue, int depth){
            this.red = red;
            this.blue = blue;
            this.depth = depth;
        }

    }

    static int hash(Point red, Point blue){
        return red.x*1000 + red.y*100 + blue.x*10 + blue.y;
    }
}
