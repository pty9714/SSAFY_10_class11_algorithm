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
        result = 0;
        int[] queens = new int[N];
        int[] notAbles = new int[N*2];
        dfs(queens, notAbles, 0);
        System.out.println(result);
    }

    static void dfs(int[] queens, int[] notAbles, int idx) {
        if (idx == N) {
            result += 1;
            return;
        }
        Integer num;
        for (int j = 0; j < idx; j++) {
            notAbles[j*2] -= 1;
            notAbles[j*2+1] += 1;
        }
        label: for (int i = 0; i < N; i++){
            for (int j = 0; j < idx; j++) {
                if (queens[j] == i) {
                    continue label;
                }
            }
            boolean flag = false;
            for (int j = 0; j < idx*2; j++) {
                if (notAbles[j] == i) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                queens[idx] = i;
                notAbles[idx*2] = i;
                notAbles[idx*2+1] = i;
                dfs(queens, notAbles, idx + 1);
                queens[idx] = -1;
                notAbles[idx*2] = -1;
                notAbles[idx*2+1] = -1;
            }
        }
        for (int j = 0; j < idx; j++) {
            // 0번째가 마이너스 1번째가 플러스
            notAbles[j*2] += 1;
            notAbles[j*2+1] -= 1;
        }

    }
}

// 6572ms
// 처음에는 LinkedList로 시도함 ( 계속 삽입 삭제가 일어났기 때문에, 삽입 삭제가 빠른 링크드리스트 선택, contains를 쓰기 위해 선택했지만 메모리 오버)
// 메모리 오버 나는 이유는 계속 삽입 삭제를 반복하면서 새로운 객체를 만들었기 때문에, 사용하지 않는 메모리가 생긴것으로 예상
// 배열을 int[]로 바꿔서 고정적인 메모리를 사용하도록 한 뒤 배열 접근 방식을 index로 하도록 설정
// 퀸을 판단할 때 같은 열, 행에 있으면 안되기 때문에 배열을 하나 만들고, 각자의 값이 모두 다르도록 배열 구성
// 해당 배열과 더불어 배열의 길이 *2를 하나더 만들어, 그 배열에는 대각선을 표시해서 -1 +1을 해주며 배열 길이가 하나 늘어날 때마다 퀸이 위치할 수 없는 곳을 체크하도록 함