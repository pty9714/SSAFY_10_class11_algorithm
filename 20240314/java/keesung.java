
package 20240314.java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class keesung {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {0, N});
        int time = Integer.MAX_VALUE;
        int way = 0;
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int repeat = data[0];
            int point = data[1];
            if (point < 0) {
                continue;
            }
            if (repeat > time) {
                break;
            }
            if (point == K) {
                time = repeat;
                way++;
                continue;
            }
            queue.add(new int[] {repeat+1, point+1});
            queue.add(new int[] {repeat+1, point-1});
            queue.add(new int[] {repeat+1, point*2});
        }

        System.out.println(time);
        System.out.println(way);

    }
    
}
