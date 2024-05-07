import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Point[] woods = new Point[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            woods[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(woods, (o1, o2) -> o1.x-o2.x);
        int last = -1;
        int start, end, dist, cnt;
        int answer = 0;

        for(Point w : woods){
            if(w.y < last) continue;
            start = Math.max(w.x, last);
            end = w.y;

            dist = end-start;
            cnt = dist/l;
            if(dist%l != 0) cnt++;
            last = start+(cnt*l);
            answer += cnt;
        }
        System.out.println(answer);
    }
}
