import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 190604KB, 1100ms
public class B1525 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    static class Cell {
        StringBuilder puzzle;
        int blankIndex;
        Cell(StringBuilder puzzle, int blankIndex) {
            this.puzzle = puzzle;
            this.blankIndex = blankIndex;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder puzzle = new StringBuilder();
        int blank = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                puzzle.append(st.nextToken());
                if(puzzle.charAt(i * 3 + j) == '0') {
                    blank = i * 3 + j;
                }
            }
        }
        bw.write(bfs(puzzle, blank) + "");
        bw.flush();
        bw.close();
        br.close();
    }
    private static int bfs(StringBuilder puzzle, int blank) {
        HashMap<String, Integer> puzzleSet = new HashMap<>();
        String ans = "123456780";
        Queue<Cell> q = new LinkedList<>();
        puzzleSet.put(puzzle.toString(), 0);
        q.offer(new Cell(puzzle, blank));
        while(!q.isEmpty()) {
            Cell cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int tempX = cur.blankIndex / 3 + dx[i];
                int tempY = cur.blankIndex % 3 + dy[i];
                if(tempX < 0 || tempX >= 3 || tempY < 0 || tempY >= 3) continue;
                int tempBlank = tempX * 3 + tempY;
                char temp = cur.puzzle.charAt(tempBlank);
                StringBuilder next = new StringBuilder(cur.puzzle.toString());
                next.replace(tempBlank, tempBlank + 1, "0");
                next.replace(cur.blankIndex, cur.blankIndex + 1, String.valueOf(temp));
                if(!puzzleSet.containsKey(next.toString())) {
                    puzzleSet.put(next.toString(), puzzleSet.get(cur.puzzle.toString()) + 1);
                    q.offer(new Cell(next, tempBlank));
                }
            }
        }
        return puzzleSet.getOrDefault(ans, -1);
    }
}
