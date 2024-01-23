import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Ball[] pool = new Ball[n];
        int[] colors = new int[n+1];
        int[] sizes = new int[2001];
        int total = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            pool[i] = new Ball(i, color, size);
        }

        Arrays.sort(pool, (o1, o2) -> {
            if(o1.size == o2.size) return o1.color - o2.color;
            return o1.size - o2.size;
        });

        pool[0].sum = 0;
        total += pool[0].size;
        colors[pool[0].color] += pool[0].size;
        sizes[pool[0].size] += pool[0].size;

        for(int i = 1; i < n; i++){
            pool[i].sum = total - colors[pool[i].color] - sizes[pool[i].size];
            total += pool[i].size;
            colors[pool[i].color] += pool[i].size;
            sizes[pool[i].size] += pool[i].size;
            if(pool[i].size == pool[i-1].size && pool[i].color == pool[i-1].color){
                pool[i].sum = pool[i-1].sum;
            }
        }

        Arrays.sort(pool, ((o1, o2) -> o1.index - o2.index));
        for(int i = 0; i < n; i++){
            bw.write(pool[i].sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Ball{
        int index;
        int color;
        int size;
        int sum = 0;
        Ball(int index, int color, int size){
            this.index = index;
            this.color = color;
            this.size = size;
        }
    }
}
