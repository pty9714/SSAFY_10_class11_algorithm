import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class keesung {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
//        boolean[][] visited = new boolean[N][M];
//        visited[0][0] = true;
        for (int i = 0; i < N; i++) {
            String text = br.readLine().toString();
            for (int j = 0; j < M; j++) {
                char numText = text.charAt(j);
                int num;
                if (numText == 'H') {
                    num = -1;
                } else {
                    num = Integer.valueOf(numText) - Integer.valueOf('0');
                }

                map[i][j] = num;

            }
        }
        boolean[][][] dp = new boolean[N*M+2][N][M];
        dp[0][0][0] = true;
        int index = 0;
        int result = 0;
        while (index < N * M + 1) {
            boolean signal = false;



            ArrayList<int[]> visitArr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
//                    System.out.print(dp[index][i][j] + " ");
                    if (dp[index][i][j]) {
                        signal = true;
                        int speed = map[i][j];
//                        System.out.println(speed);
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k] * speed;
                            int ny = j + dy[k] * speed;
//                            System.out.println("nx : " + nx + " ny : " + ny);
                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                                continue;
                            }
                            if (map[nx][ny] == -1) {
                                continue;
                            }
//                            if (visited[nx][ny]) {
//                                result = -1;
//                                System.out.println("index : " + index + " nx : " + nx + " ny : " + ny + " i : " + i + " j : " + j);
//                                break;
//                            }
//                            System.out.println("----------------");
//
//                            System.out.println(index);
//                            System.out.println(nx);
//                            System.out.println(ny);
                            dp[index+1][nx][ny] = true;
//                            visitArr.add(new int[] {nx, ny});
//                            System.out.println("=============방문============");
//                            System.out.println("index : " + index + " nx : " + nx + " ny : " + ny + " i : " + i + " j : " + j);
                        }
                    }

                }
//                System.out.println();
            }
//            for (int[] tmpVisited : visitArr) {
//                visited[tmpVisited[0]][tmpVisited[1]] = true;
//            }
//            System.out.println();


            if (!signal) {
                break;
            }
            if (result != -1) {
                result += 1;
            } else {
                break;
            }
            index += 1;
        }

        if (index == N * M + 1) {
            result = -1;
        }
        System.out.println(result);


    }
}

// 22624kb, 244ms
// 메모이제이션
// N번 실행 후 한번더 실행 했을 때 가능한 곳이 있으면 순환이 생긴 것이므로 -1 return
// 나머지는 다음에 가능한 곳을 메모이제이션 해두고 거기서 계속 이동하는 방식으로 진행