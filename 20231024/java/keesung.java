import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            if(a == 0 && b == 0) return;

            int total = cal_watt(a);
            int left = 0;
            int right = total / 2;
            while(left <= right) {
                int mid = (left + right) / 2;

                int s_price = cal_price(mid);
                int n_price = cal_price(total - mid);

                int diff = Math.abs(s_price - n_price);
                if(diff < b) {
                    right = mid - 1;
                } else if(diff > b){
                    left = mid + 1;
                } else {
                    System.out.println(cal_price(mid));
                    break;
                }
            }
        }
    }

    public static int cal_watt(int p) {
        if(p <= 200) {
            return p / 2;
        } else if(p <= 29900) {
            return (p - 200) / 3 + 100;
        } else if(p <= 4979900) {
            return (p - 29900) / 5 + 10000;
        } else {
            return (p - 4979900) / 7 + 1000000;
        }
    }

    public static int cal_price(int watt) {
        if(watt <= 100) {
            return watt * 2;
        } else if(watt <= 10000) {
            return 200 + (watt - 100) * 3;
        } else if(watt <= 1000000) {
            return 200 + 29700 + (watt - 10000) * 5;
        } else {
            return 200 + 29700 + 4950000 + (watt - 1000000) * 7;
        }
    }
}


// 답지 확인
// 이분탐색은 이해가 되나, 왜 (A - B) / 2 만큼을 상근이가 내는게 아닌지????
