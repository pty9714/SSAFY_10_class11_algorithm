
import com.sun.jmx.remote.internal.ArrayQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Set;

class keesung
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = tmp[0];
            long A = tmp[1];
            long B = tmp[2];
            int sqrt = (int)Math.sqrt(N);
            long minVal = Long.MAX_VALUE;
            for (int i = 1; i <= sqrt; i++) {
                int j = i;
                while (true) {
                    long result = A * Math.abs(i - j) + B * (N - i * j);
                    minVal = Math.min(minVal, result);
                    j++;
                    if (i * j > N) {
                        break;
                    }
                }
            }
            System.out.println("#" + test_case + " " + minVal);
        }
    }
}

// 08:11:56 실행이 완료되었습니다. 실행 시간 : 0.29065s

// 가능한 직사각형의 갯수는 첫번째 숫자가 N ** 0.5 이하여야 한다.
// int형과 long형 잘 사용해야 한다. 계산 할 때 int형으로 계산하면 오버플로우가 발생할 수 있다.
// 1. 1부터 N ** 0.5 까지의 숫자를 i로 놓고, i * j = N 이 되는 j를 찾는다.
// 2. i와 j의 차이를 구하고, A * (i - j) + B * (N - i * j)를 계산한다.
// 3. 1번과 2번을 반복하면서 최소값을 찾는다.
