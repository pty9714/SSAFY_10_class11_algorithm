import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class keesung {

    // static int[] queens;
    static int N;
    static int result;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        // queens = new int[N];
        result = 0;
        List queens = new LinkedList<Integer>();
        List notAbles = new LinkedList<Integer>();
        dfs(queens, notAbles, 0);
        System.out.println(result);
    }

    static void dfs(List queens, List notAbles, int idx) {
        if (idx == N) {
//            System.out.println(queens.toString());
//            System.out.println(notAbles.toString());
            result += 1;
            return;
        }
        ListIterator<Integer> iterator = notAbles.listIterator();
        Integer num;
        for (int j = 0; j < queens.size(); j++) {
            // 0번째가 마이너스 1번째가 플러스
            num = iterator.next();
            iterator.set(num - 1);
            num = iterator.next();
            iterator.set(num + 1);
        }
        for (int i = 0; i < N; i++){

            if (queens.contains(i)) {
                continue;
            } else {

                if (notAbles.contains(i) == false) {
                    queens.add(i);
                    notAbles.add(i);
                    notAbles.add(i);
                    dfs(queens, notAbles, idx + 1);
                    queens.remove(queens.size()-1);
                    notAbles.remove(notAbles.size()-1);
                    notAbles.remove(notAbles.size()-1);
                }
            }
        }
        iterator = notAbles.listIterator();
        for (int j = 0; j < queens.size(); j++) {
            // 0번째가 마이너스 1번째가 플러스
            num = iterator.next();
            iterator.set(num + 1);
            num = iterator.next();
            iterator.set(num - 1);
        }

    }
}