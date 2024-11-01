import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;

    static int find(int x) {
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parents[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        parents = new int[G+1];
        for(int i = 1; i <= G; i++) {
            parents[i] = i;
        }

        int P = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            if(find(g) ==0) break;
            cnt++;
            union(find(g), find(g)-1);
        }
        System.out.println(cnt);
    }
}
