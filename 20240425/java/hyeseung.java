import java.io.*;
import java.util.*;

// 30220KB, 252ms
public class B19238 {
    static class Point {
        int x;
        int y;
        int dist;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] map;
    private static int N, taxiX, taxiY;
    private static HashMap<Integer, Point> guestInfo = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        taxiX = Integer.parseInt(st.nextToken()) - 1;
        taxiY = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int startY = Integer.parseInt(st.nextToken()) - 1;
            map[startX][startY] = -i; // 고객 있는 자리 체크
            int endX = Integer.parseInt(st.nextToken()) - 1;
            int endY = Integer.parseInt(st.nextToken()) - 1;
            guestInfo.put(-i, new Point(endX, endY)); // 고객 목적지 정보 해시맵에 넣기
        }

        for (int i = 0; i < M; i++) {
            fuel = driveGuest(fuel);
            if(fuel == -1) break;
        }

        bw.write(fuel + "");
        bw.flush();
        bw.close();
        br.close();
    }
    private static int driveGuest(int fuel) {
        Point startGuest = findGuest();
        if(!guestInfo.containsKey(map[startGuest.x][startGuest.y])) return -1; // 고객한테 도달하지 못하는 경우
        Point destGuest = guestInfo.get(map[startGuest.x][startGuest.y]);
        destGuest.dist = getDistance(startGuest.x, startGuest.y, destGuest.x, destGuest.y); // 고객 출발지 -> 목적지 경로
        map[startGuest.x][startGuest.y] = 0;
        // 택시 목적지 이동
        taxiX = destGuest.x;
        taxiY = destGuest.y;
        // 연료 사용
        if(fuel < startGuest.dist) { // 고객한테 가는 도중 연료 부족
            return -1;
        }
        fuel -= startGuest.dist;
        if(fuel < destGuest.dist) { // 고객 목적지 가는 도중 연료 부족
            return -1;
        }
        fuel += destGuest.dist;
        return fuel;
    }
    private static Point findGuest() {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        q.offer(new Point(taxiX, taxiY, 0));
        visited[taxiX][taxiY] = true;
        Point guest = new Point(0, 0, Integer.MAX_VALUE); // 최단 거리가 가장 짧은 승객
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(map[cur.x][cur.y] < 0) { // 승객이 있는 경우
                if(guest.dist > cur.dist) { // 최단 거리 짧은 경우로 갱신
                    guest.dist = cur.dist;
                    guest.x = cur.x;
                    guest.y = cur.y;
                }
                else if(guest.dist == cur.dist) {
                    if(guest.x == cur.x) { // 열이 더 작은 경우로 갱신
                        guest.y = Math.min(guest.y, cur.y);
                    }
                    else if(guest.x > cur.x) { // 행이 더 작은 경우로 갱신
                        guest.x = cur.x;
                        guest.y = cur.y;
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int tempX = cur.x + dx[i];
                int tempY = cur.y + dy[i];
                if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= N
                        || visited[tempX][tempY] || map[tempX][tempY] == 1) continue;
                q.offer(new Point(tempX, tempY, cur.dist + 1));
                visited[tempX][tempY] = true;
            }
        }
        return guest;
    }
    private static int getDistance(int startX, int startY, int endX, int endY) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        q.offer(new Point(startX, startY, 0));
        visited[startX][startY] = true;
        int dist = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(cur.x == endX && cur.y == endY) {
                dist = Math.min(dist, cur.dist);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int tempX = cur.x + dx[i];
                int tempY = cur.y + dy[i];
                if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= N
                        || visited[tempX][tempY] || map[tempX][tempY] == 1) continue;
                q.offer(new Point(tempX, tempY, cur.dist + 1));
                visited[tempX][tempY] = true;
            }
        }
        return dist;
    }
}
