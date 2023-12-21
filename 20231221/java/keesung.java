
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class keesung {

    public static Robot[][] map;
    public static Map<String, Integer> dirMap = Map.of("N", 0, "E", 1, "S", 2, "W", 3);
    public static ArrayList<Robot> robots = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        map = new Robot[A][B];

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        robots.add(null);
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            String dir = st.nextToken();
            map[x][y] = new Robot(i, x, y, dirMap.get(dir));
            robots.add(map[x][y]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int index = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            int repeat = Integer.parseInt(st.nextToken());
            Robot robot = robots.get(index);

            if (dir.equals("F")) {
                for (int j = 0; j < repeat; j++) {
                    String result = robot.go();
                    if (!result.equals("OK")) {
                        System.out.println(result);
                        return;
                    }
                }
            } else {
                robot.turn(dir, repeat);
            }

        }
        System.out.println("OK");
    }

    public static class Robot {
        int index;
        int x;
        int y;
        int dir;

        public Robot(int index, int x, int y, int dir) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public void turnLeft() {
            dir--;
            if (dir == -1)
                dir = 3;
        }

        public void turnRight() {
            dir++;
            if (dir == 4)
                dir = 0;
        }

        public void turn(String dir, int repeat) {
            repeat = repeat % 4;
            if (dir.equals("L")) {
                for (int i = 0; i < repeat; i++) {
                    turnLeft();
                }
            }
            if (dir.equals("R")) {
                for (int i = 0; i < repeat; i++) {
                    turnRight();
                }
            }

        }

        public String go() {
            map[x][y] = null;
            if (dir == 0)
                y++;
            else if (dir == 1)
                x++;
            else if (dir == 2)
                y--;
            else
                x--;
            if (x < 0 || y < 0 || x >= map.length || y >= map[0].length) {
                return "Robot " + index + " crashes into the wall";
            }
            if (map[x][y] != null) {
                return "Robot " + index + " crashes into robot " + map[x][y].index;
            }
            map[x][y] = this;
            return "OK";
        }
    }

}

// 메모리 16092, 시간 152
// 자바8에서는 Map.of를 사용 할 수 없다
// 자바11버전으로 바꾸고 나서 통과함, 자바8에서는 컴파일 에러남
// 구현, 그래프
// 충돌 시나리오와, 로봇의 이동의 구현을 객체 안으로 넣음