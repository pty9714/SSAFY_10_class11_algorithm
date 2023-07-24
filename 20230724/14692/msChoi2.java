import java.util.Scanner;
import java.io.FileInputStream;

class Main
{
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\SSAFY\\intellij\\algorithm\\src\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            String winner = "";
            int num = sc.nextInt();
            if (num % 2 == 0) {
                winner = "Alice";
            } else {
                winner = "Bob";
            }
            System.out.println("#" + test_case + " " + winner);
        }
    }
}

---
결국 가장 작은 자연수(1) 로 잘라야 하기 때문에 `자르는 방법에 관계없이 자르는 횟수는 정해져있음`

따라서 홀수, 짝수에 따라 답이 결정됨
