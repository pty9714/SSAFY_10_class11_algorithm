import java.util.*;
import java.util.Map.*;
class Solution {
    static class Room implements Comparable<Room> {
        int dir;
        int number;
        int hour;
        public Room(int dir, int number, int hour) {
            this.dir = dir;
            this.number = number;
            this.hour = hour;
        }
        @Override
        public int compareTo(Room o) {
            return this.hour - o.hour;
        }
    }
    public ArrayList<HashMap<Integer, Room>> rooms;
    public HashSet<Integer> trapSet;
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        rooms = new ArrayList<HashMap<Integer, Room>>();
        for(int i = 0; i < 1000; i++) {
            rooms.add(new HashMap<Integer, Room>());
        }
        trapSet = new HashSet<Integer>();
        for(int trap : traps) {
            trapSet.add(trap - 1);
        }
        for(int[] road : roads) {
            rooms.get(road[0] - 1).put(road[1] - 1, new Room(1, road[1] - 1, road[2]));
            if(trapSet.contains(road[0] - 1)) {
                rooms.get(road[1] - 1).put(road[0] - 1, new Room(-1, road[0] - 1, road[2]));
            }
            else if(trapSet.contains(road[1] - 1)) {
                rooms.get(road[1] - 1).put(road[0] - 1, new Room(-1, road[0] - 1, road[2]));
            }
        }
        answer = bfs(start - 1, end - 1);
        return answer;
    }
    public int bfs(int start, int end) {
        int min = Integer.MAX_VALUE;
        PriorityQueue<Room> q = new PriorityQueue<>();
        q.offer(new Room(1, start, 0));
        while(!q.isEmpty()) {
            Room cur = q.poll();
            if(cur.number == end) {
                min = Math.min(min, cur.hour);
                continue;
            }
            
            if(cur.hour >= min) {
                continue;
            }
            
            if(trapSet.contains(cur.number)) {
                // 함정
                for(Entry<Integer, Room> trapRoom : rooms.get(cur.number).entrySet()) {
                    trapRoom.getValue().dir = -trapRoom.getValue().dir;
                    rooms.get(trapRoom.getKey()).get(cur.number).dir = -rooms.get(trapRoom.getKey()).get(cur.number).dir;
                }
            }
            for (Entry<Integer, Room> next : rooms.get(cur.number).entrySet()) {
                if(next.getValue().dir == 1) {
                    q.offer(new Room(next.getValue().dir, next.getKey(), cur.hour + next.getValue().hour));
                }
            }
        }
        return min;
    }
}