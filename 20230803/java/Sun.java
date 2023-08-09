import java.util.Scanner;

public class Main {

    public static int[] arr;
    public static int N;
    public static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    public static void nQueen(int queen) {
        if (queen == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[queen] = i;
            if (Possibility(queen)) {
                nQueen(queen + 1);
            }
        }
    }

    public static boolean Possibility(int queen) {
        for (int i = 0; i < queen; i++) {

            if (arr[queen] == arr[i]) {
                return false;
            }
    
            else if (Math.abs(queen - i) == Math.abs(arr[queen] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}