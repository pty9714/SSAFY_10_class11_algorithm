import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {

        static ArrayList<Point>[] hiking;
        static int[] spot;

        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            int[] answer = {0, 10000001};
            spot = new int[n+1];
            hiking = new ArrayList[n+1];
            for(int i = 0; i < n+1; i++){
                hiking[i] = new ArrayList<>();
            }
            for(int gate : gates){
                spot[gate] = 1;
            }
            for(int summit : summits){
                spot[summit] = 2;
            }
            for(int[] path : paths){
                hiking[path[0]].add(new Point(path[1], path[2]));
                hiking[path[1]].add(new Point(path[0], path[2]));
            }
            for (int gate : gates){
                int[] root = getRoot(gate, n, answer[1]);
                if(root[1] < answer[1]){
                    answer[0] = root[0];
                    answer[1] = root[1];
                }
                else if(root[1] == answer[1]){
                    if(root[0] < answer[0]) answer[0] = root[0];
                }
            }

            return answer;
        }

        static int[] getRoot(int start, int n, int limit){
            PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
                if(o1.y == o2.y) return o1.x-o2.x;
                return o1.y-o2.y;
            });
            int[] answer = new int[]{0, 0};
            boolean[] visited = new boolean[n+1];
            pq.add(new Point(start, 0));
            Point current = new Point(0,0);
            while(!pq.isEmpty()){
                current = pq.poll();
                if(visited[current.x]) continue;
                if(current.y > limit) return new int[]{0, 10000001};
                visited[current.x] = true;
                if(current.y > answer[1]) answer[1] = current.y;
                if(spot[current.x] == 2) break;
                for(Point p : hiking[current.x]){
                    if(visited[p.x] || spot[p.x] == 1) continue;
                    pq.add(p);
                }
            }
            if(spot[current.x] == 2){
                answer[0] = current.x;
                return answer;
            }
            else return new int[]{0, 10000001};
        }

    }

/*
테스트 1 〉	통과 (0.85ms, 76.4MB)
테스트 2 〉	통과 (0.86ms, 75.1MB)
테스트 3 〉	통과 (0.96ms, 71.7MB)
테스트 4 〉	통과 (1.13ms, 80MB)
테스트 5 〉	통과 (0.88ms, 74.4MB)
테스트 6 〉	통과 (0.93ms, 71.2MB)
테스트 7 〉	통과 (0.96ms, 71.5MB)
테스트 8 〉	통과 (1.24ms, 76MB)
테스트 9 〉	통과 (1.09ms, 67.8MB)
테스트 10 〉	통과 (1.64ms, 77.1MB)
테스트 11 〉	통과 (1.54ms, 76.2MB)
테스트 12 〉	통과 (1.40ms, 77.9MB)
테스트 13 〉	통과 (6.59ms, 76.9MB)
테스트 14 〉	통과 (21.09ms, 97.1MB)
테스트 15 〉	통과 (95.55ms, 160MB)
테스트 16 〉	통과 (74.05ms, 154MB)
테스트 17 〉	통과 (82.75ms, 153MB)
테스트 18 〉	통과 (21.43ms, 101MB)
테스트 19 〉	통과 (24.78ms, 105MB)
테스트 20 〉	통과 (108.76ms, 156MB)
테스트 21 〉	통과 (109.03ms, 140MB)
테스트 22 〉	통과 (26.81ms, 108MB)
테스트 23 〉	통과 (61.30ms, 161MB)
테스트 24 〉	통과 (134.60ms, 262MB)
테스트 25 〉	통과 (319.72ms, 524MB)
*/
