import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Long> aList = new ArrayList<>();
        ArrayList<Long> bList = new ArrayList<>();

        cal(aList, A);
        cal(bList, B);

        Collections.sort(bList);

        long count = 0;
        for(long num : aList){
            count += binarySearch(T - num, bList);
        }

        System.out.println(count);

    }

    static void cal(ArrayList<Long> list, int[] num){
        for(int i = 0; i < num.length; i++){
            long sum = 0;
            for(int j = i; j < num.length; j++){
                sum += num[i];
                list.add(sum);
            }
        }
    }

    static int binarySearch(long target, ArrayList<Long> b){
        int left = 0;
        int right = 0;

        int start = 0;
        int end = b.size() - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(b.get(mid) >= target){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }

        left = end;
        start = 0;
        end = b.size() - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(b.get(mid) <= target){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        right = end;

        return right - left;
    }
}
