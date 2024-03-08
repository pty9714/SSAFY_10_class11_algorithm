import java.io.*;

// 11588KB, 88ms
public class B1195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String gearStr1 = br.readLine();
        String gearStr2 = br.readLine();
        int gearLen1 = gearStr1.length();
        int gearLen2 = gearStr2.length();
        int ans = gearLen1 + gearLen2;
        int[][] gear = new int[2][ans];
        for (int i = 0; i < gearLen1; i++) {
            gear[0][i] = gearStr1.charAt(i) - '0';
        }
        for (int i = 0; i < gearLen2; i++) {
            gear[1][i] = gearStr2.charAt(i) - '0';
        }
        for (int i = 0; i < gearLen1; i++) {
            boolean flag = true;
            for (int j = 0; j < gearLen2; j++) {
                if(gear[0][i+j] + gear[1][j] >= 4) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                int temp = Math.max(gearLen1, i + gearLen2);
                ans = Math.min(ans, temp);
            }
        }
        for (int i = 0; i < gearLen2; i++) {
            boolean flag = true;
            for (int j = 0; j < gearLen1; j++) {
                if(gear[1][i+j] + gear[0][j] >= 4) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                int temp = Math.max(gearLen2, i + gearLen1);
                ans = Math.min(ans, temp);
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
