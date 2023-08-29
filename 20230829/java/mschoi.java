import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> numbers = new ArrayList<>();

        // N 이하의 2제곱수 저장
        int number = 1;
        while (number <= N) {
            numbers.add(number);
            number *= 2;
        }

        // 가장 적은 수로 N 만들기 시도
        ArrayList<Integer> cnt = new ArrayList<>();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            int q = N / numbers.get(i);
            N -= q * numbers.get(i);
            if (q > 0) {
                cnt.add(numbers.get(i));
            }
            if (N == 0) {
                break;
            }
        }

        if (cnt.size() > K) {
            int count = cnt.size() - K;
            int temp = 0;
            for (int j = 0; j < count; j++) {
                temp += cnt.get(cnt.size() - j - 2) - cnt.get(cnt.size() - j - 1);
                cnt.set(cnt.size() - j - 2, cnt.get(cnt.size() - j - 2) * 2);
            }
            System.out.println(temp);
        } else {
            System.out.println(0);
        }
    }
}

// 11528KB  80ms
