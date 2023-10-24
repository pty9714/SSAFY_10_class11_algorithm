import java.io.*;
import java.util.StringTokenizer;

public class giryun {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A == 0 && B == 0) break;
            bw.write(binarySearch(A, B)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static int binarySearch(int a, int b) {
        int t = getWatt(a);
        int l = 0;
        int r = t / 2;
        while (l <= r) {
            int mid = (l + r) / 2; //상근이의 사용량

            int sPrice = getPrice(mid); //상근이가 내야하는 전기요금
            int ePrice = getPrice(t-mid); //이웃이 내야하는 전기요금
            int diff = Math.abs(sPrice-ePrice);

            if (diff > b) l = mid+1;
            else if (diff < b) r = mid-1;
            else return sPrice;
        }
        return -1;
    }
    public static int getWatt(int p) {
        if (p <= 200) return p / 2;
        else if (p <= 29900) return (p - 200) / 3 + 100;
        else if (p <= 4979900) return (p - 29900) / 5 + 10000;
        else return (p - 4979900) / 7 + 1000000;
    }
    public static int getPrice(int wh) {
        if (wh <= 100) return wh * 2;
        else if (wh <= 10000) return 200 + (wh - 100) * 3;
        else if (wh <= 1000000) return 200 + 29700 + (wh - 10000) * 5;
        else return 200 + 29700 + 4950000 + (wh - 1000000) * 7;
    }
}
//11876	88
