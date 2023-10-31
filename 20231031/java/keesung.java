
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main2 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Person normal = new Person(true);
        Person abnormal = new Person(false);
        int N = Integer.parseInt(br.readLine());
        Node[][][] map = new Node[2][N][N];
        int[] results = new int[2];
        for (int i = 0; i < N; i++) {
            String text = br.readLine().toString();
            for (int j = 0; j < N; j++) {
                char numText = text.charAt(j);
                map[0][i][j] = new Node(numText, normal, i, j);
                map[1][i][j] = new Node(numText, abnormal, i, j);
            }
        }

        int[][] directions = new int[][] {
                { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
        };

        for (int k = 0; k < 2; k++) {
            Queue<Node> queue = new LinkedList<>();
            int result = 0;
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) {
                        continue;
                    }
                    queue.add(map[k][i][j]);
                    visited[i][j] = true;
                    result++;
                    while (!queue.isEmpty()) {
                        Node node = queue.poll();
                        for (int[] direction : directions) {
                            int nx = node.x + direction[0];
                            int ny = node.y + direction[1];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                                continue;
                            }
                            if (visited[nx][ny]) {
                                continue;
                            }
                            if (map[k][nx][ny].equals(node)) {
                                queue.add(map[k][nx][ny]);
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            results[k] = result;
        }

        System.out.println(results[0] + " " + results[1]);

    }

    public static class Person {
        boolean normal;

        public Person(boolean normal) {
            this.normal = normal;
        }
    }

    public static class Node {
        char color;
        Person person;

        int x;
        int y;

        public Node(char color, Person person, int x, int y) {
            this.color = color;
            this.person = person;
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }
            Node node = (Node) o;
            if (node.person.normal) {
                return color == node.color;
            } else {
                if (color == node.color) {
                    return true;
                }
                if (color == 'R') {
                    return node.color == 'G';
                } else if (color == 'G') {
                    return node.color == 'R';
                }
            }
            return false;
        }
    }
}

// 13968kb, 112ms
// 객체지향 개념 활용, equals 재정의를 통해 while문 1번 사용