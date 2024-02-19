import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BaekJoon1327 {

    static int[] num;
    static HashMap<String, Boolean> visited;
    static int k;
    static int n;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        num = new int[n];
        visited = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            num[i] = Integer.parseInt(st.nextToken());

        answer = -1;

        dfs(num, 0);

        System.out.println(answer);


    }

    public static void dfs(int[] arr, int depth){
        for(int i=0; i<n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        if(isAsc(arr)){
            answer = depth;
            return;
        }


        for(int i=0; i<n-k+1; i++){
            StringBuilder temp = new StringBuilder();
            StringBuilder tempReverse = new StringBuilder();
            for(int j=0; j<k; j++) {
                temp.append(arr[i + j]);
                tempReverse.append(arr[i+k-j-1]);
            }

            if(!visited.getOrDefault(temp.toString(), false) || !visited.getOrDefault(tempReverse.toString(), false) ){
                visited.put(temp.toString(), true);
                visited.put(tempReverse.toString(), true);
                dfs(swap(arr, i), depth + 1);
//                visited.put(temp.toString(), false);
            }
        }

    }

    public static int[] swap(int[] map, int start){
        int[] response = Arrays.copyOf(map, n);

        for(int i=0; i<k/2; i++){
            int temp = map[start+i];
            response[start+i] = map[start+k-i-1];
            response[start+k-i-1] = temp;
        }

        return response;
    }

    public static boolean isAsc(int[] num){
        for(int i=1; i<num.length; i++)
            if(num[i-1] >= num[i])
                return false;
        return true;
    }

}

