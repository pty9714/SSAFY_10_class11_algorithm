import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1421 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int max_tree = 0;
        Long max_money = 0L;

        int[] trees = new int[n];
        for(int i = 0; i < n;  i++){
            trees[i] = Integer.parseInt(br.readLine());
            max_tree = Math.max(max_tree, trees[i]);
        }

        for(int i = 1; i <= max_tree; i++){
            int sum=0, cut, wood, cnt = 0;
            for(int j = 0; j < n; j++){
                wood = trees[j]/i;
                cut = trees[j]%i==0 ? wood-1 : wood;
                if(wood*w*i < cut*c) continue;
                sum += wood;
                cnt += cut;;
            }
            max_money = Math.max(max_money, (long) sum *w*i - (long) cnt *c);
        }
        System.out.println(max_money);

    }
}
