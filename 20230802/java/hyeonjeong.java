import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    static int building, road;
    static ArrayList<Info> map[];
    static int distance[];
    static Queue<Info> queue;
    
    static class Info implements Comparable<Info>{
        int end, dist;
        public Info(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }
        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=1; t<=tc; t++) {
            building = sc.nextInt();
            road = sc.nextInt();

            map = new ArrayList[building+1];
            for(int i=1; i<=building; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                int dist = sc.nextInt();
                map[start].add(new Info(end, dist));
            }

            int answer = Integer.MAX_VALUE;
            for(int i=1; i<=building; i++) {
                distance = new int[building+1];
                queue = new LinkedList<Info>();
                for(int j=1; j<=building; j++) {
                    distance[j] = Integer.MAX_VALUE;
                }
                queue.add(new Info(i, 0));
                Info info;
                while(!queue.isEmpty()) {
                    info = queue.poll();
                    int cend = info.end;
                    int cdist = info.dist;
                    if(cdist > answer) continue;
                    for(int j=0; j<map[cdist].size(); j++) {
                        int nend = map[cend].get(j).end;
                        int ndist = map[cend].get(j).dist;
                        if(distance[nend] > cdist + ndist) {
                            distance[nend] = cdist + ndist;
                            queue.add(new Info(nend, distance[nend]));
                        }
                    }
                }
                answer = Math.min(distance[i], answer);
            }
            if(answer==Integer.MAX_VALUE) answer = -1;
            System.out.printf("#%d %d%n", t, answer);
        }
        
    }
}
