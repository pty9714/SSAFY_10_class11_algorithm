import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class keesung {

    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[][] dxMoveDirections = new int[][] {
        {-1, 0, 1, 0}, {-1, 1, 1, -1}
    };
    public static int[][] dyMoveDirections = new int[][] {
        {0, 1, 0, -1}, {1, 1, -1, -1}
    };


    public static FireBall[][][] map;
    public static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new FireBall[2][N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[0][r][c] = new FireBall(m, d, s);
        }

        for (int i = 0; i < K; i++) {
            moveFireBall(i);
        }

        int realMap = K % 2;
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[realMap][i][j] == null) {
//                    System.out.print("0 ");
                    continue;
                }
                FireBall sumBall = map[realMap][i][j];
                if (sumBall.number > 1) {
                    result += sumBall.weight / 5 * 4;
                } else {
                    result += sumBall.weight;
                }
//                System.out.print(sumBall.weight + " ");

            }
//            System.out.println();
        }


        System.out.println(result);
    }

    private static void moveFireBall(int index) {
        int now = index % 2;
        int moveTo = (index + 1) % 2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[now][i][j] != null) {
                    FireBall ball = map[now][i][j];

                    if (ball.number > 1) {
                        int direction = 0;
                        for (int dir : ball.directions) {
                            if (dir % 2 != ball.direction % 2) {
                                direction = 1;
                                break;
                            }
                        }

                        for (int k = 0; k < 4; k++) {
                            int newDirection = k * 2 + direction;
                            FireBall newBall = new FireBall(ball.weight / 5, newDirection, ball.speed / ball.number);
                            if (newBall.weight == 0) continue;
                            int nx = i + dx[newBall.direction] * newBall.speed;
                            int ny = j + dy[newBall.direction] * newBall.speed;
                            nx = nx % N;
                            while (nx < 0) {
                                nx += N;
                            }
                            ny = ny % N;
                            while (ny < 0) {
                                ny += N;
                            }
                            moveOneBall(moveTo, nx, ny, newBall);
                        }

                    } else { // 볼이 하나밖에 없을 때
                        int nx = i + dx[ball.direction] * ball.speed;
                        int ny = j + dy[ball.direction] * ball.speed;
                        nx = nx % N;
                        while (nx < 0) {
                            nx += N;
                        }
                        ny = ny % N;
                        while (ny < 0) {
                            ny += N;
                        }
                        moveOneBall(moveTo, nx, ny, ball);
                    }
                    map[now][i][j] = null;
                }
            }
        }

    }

    private static void moveOneBall(int moveTo, int nx, int ny, FireBall newBall) {
        if (map[moveTo][nx][ny] != null) { // 볼 있으면 합치기
            FireBall tmpBall = map[moveTo][nx][ny];
            tmpBall.speed += newBall.speed;
            tmpBall.directions.add(newBall.direction);
            tmpBall.weight += newBall.weight;
            tmpBall.number += 1;
        } else { // 없으면 할당
            map[moveTo][nx][ny] = newBall;
        }
    }

    public static class FireBall {

        int weight;
        int direction;
        int speed;

        int number = 1;
        ArrayList<Integer> directions = new ArrayList<>();

        FireBall(int weight, int direction, int speed) {
            this.weight = weight;
            this.direction = direction;
            this.speed = speed;
        }
    }
}

// 메모리 30140kb, 380ms
// 주의사항 : 무게가 0인 파이어볼을 더해서 speed 계산 시에 같이 나눠지는 것 방지할 것...!!!!!!!
// 무게가 0인 파이어볼 바로 없애야함. (더한 뒤에 없애는게 아님)