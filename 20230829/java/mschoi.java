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
        int answer = 0;
        while (true) {
            int temp = N + answer;
            int count = 0;
            if (answer == temp) {
                numbers.add(temp);
            }
            for (int i = numbers.size() - 1; i >= 0; i--) {
                int q = temp / numbers.get(i);
                temp -= q * numbers.get(i);
                if (q > 0) {
                    count += 1;
                }
                if (temp == 0) {
                    break;
                }
            }
            if (temp == 0) { // N을 만들었다
                if (count <= K) { // K개 이하로 만들었다
                    System.out.println(answer);
                    break;
                }
            }
            if ((N + answer) % 2 == 0) {
                answer += 2;
            } else {
                answer += 1;
            }
        }
    }
}

// 12332KB  884ms
