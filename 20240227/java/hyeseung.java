import java.io.*;
import java.util.StringTokenizer;

// 	174424KB, 812ms
public class B20327 {
    private static int length;
    private static int[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        length = (int) Math.pow(2, N);
        int R = Integer.parseInt(st.nextToken());
        A = new int[length][length];

        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < length; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] operations = new int[R][2];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            operations[i][0] = Integer.parseInt(st.nextToken());
            operations[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int[] operation : operations) {
            switch (operation[0]) {
                case 1 : subUpDown(operation[1]); break;
                case 2 : subLeftRight(operation[1]); break;
                case 3 : subSpinRight(operation[1]); break;
                case 4 : subSpinLeft(operation[1]); break;
                case 5 : upDown(operation[1]); break;
                case 6 : leftRight(operation[1]); break;
                case 7 : spinRight(operation[1]); break;
                case 8 : spinLeft(operation[1]); break;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                bw.write(A[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    // 1. 부분배열 내 상하반전
    private static void subUpDown(int l) {
        int subLength = (int) Math.pow(2, l);
        for (int i = 0; i < length / subLength; i++) {
            for (int j = 0; j < length / subLength; j++) {
                int x = i * subLength;
                int y = j * subLength;
                int[][] temp = copy(x, y, subLength);
                for (int k = 0; k < subLength; k++) {
                    for (int m = 0; m < subLength; m++) {
                        A[x + k][y + m] = temp[subLength - k - 1][m];
                    }
                }
            }
        }
    }
    // 2. 부분배열 내 좌우반전
    private static void subLeftRight(int l) {
        int subLength = (int) Math.pow(2, l);
        for (int i = 0; i < length / subLength; i++) {
            for (int j = 0; j < length / subLength; j++) {
                int x = i * subLength;
                int y = j * subLength;
                int[][] temp = copy(x, y, subLength);
                for (int k = 0; k < subLength; k++) {
                    for (int m = 0; m < subLength; m++) {
                        A[x + k][y + m] = temp[k][subLength - m - 1];
                    }
                }
            }
        }
    }
    // 3. 부분배열 내 오른쪽으로 90도 회전
    private static void subSpinRight(int l) {
        int subLength = (int) Math.pow(2, l);
        for (int i = 0; i < length / subLength; i++) {
            for (int j = 0; j < length / subLength; j++) {
                int x = i * subLength;
                int y = j * subLength;
                int[][] temp = copy(x, y, subLength);
                for (int k = 0; k < subLength; k++) {
                    for (int m = 0; m < subLength; m++) {
                        A[x + k][y + m] = temp[subLength - m - 1][k];
                    }
                }
            }
        }
    }
    // 4. 부분배열 내 왼쪽으로 90도 회전
    private static void subSpinLeft(int l) {
        int subLength = (int) Math.pow(2, l);
        for (int i = 0; i < length / subLength; i++) {
            for (int j = 0; j < length / subLength; j++) {
                int x = i * subLength;
                int y = j * subLength;
                int[][] temp = copy(x, y, subLength);
                for (int k = 0; k < subLength; k++) {
                    for (int m = 0; m < subLength; m++) {
                        A[x + k][y + m] = temp[m][subLength - k - 1];
                    }
                }
            }
        }
    }
    // 5. 상하반전
    private static void upDown(int l) {
        int subLength = (int) Math.pow(2, l);
        int[][] temp = copy(0, 0, length);
        for (int i = 0; i < length / subLength; i++) {
            int change = ((length / subLength) - i - 1) * subLength;
            for (int j = 0; j < length / subLength; j++) {
                int x = i * subLength;
                int y = j * subLength;
                for (int k = 0; k < subLength; k++) {
                    for (int m = 0; m < subLength; m++) {
                        A[x + k][y + m] = temp[change + k][y + m];
                    }
                }
            }
        }
    }
    // 6. 좌우반전
    private static void leftRight(int l) {
        int subLength = (int) Math.pow(2, l);
        int[][] temp = copy(0, 0, length);
        for (int i = 0; i < length / subLength; i++) {
            for (int j = 0; j < length / subLength; j++) {
                int x = i * subLength;
                int y = j * subLength;
                int change = ((length / subLength) - j - 1) * subLength;
                for (int k = 0; k < subLength; k++) {
                    for (int m = 0; m < subLength; m++) {
                        A[x + k][y + m] = temp[x + k][change + m];
                    }
                }
            }
        }
    }
    // 7. 오른쪽으로 90도 회전
    private static void spinRight(int l) {
        int subLength = (int) Math.pow(2, l);
        int[][] temp = copy(0, 0, length);
        for (int i = 0; i < length / subLength; i++) {
            for (int j = 0; j < length / subLength; j++) {
                int x = i * subLength;
                int y = j * subLength;
                int change = ((length / subLength) - j - 1) * subLength;
                for (int k = 0; k < subLength; k++) {
                    for (int m = 0; m < subLength; m++) {
                        A[x + k][y + m] = temp[change + k][x + m];
                    }
                }
            }
        }
    }
    // 8. 왼쪽으로 90도 회전
    private static void spinLeft(int l) {
        int subLength = (int) Math.pow(2, l);
        int[][] temp = copy(0, 0, length);
        for (int i = 0; i < length / subLength; i++) {
            int change = ((length / subLength) - i - 1) * subLength;
            for (int j = 0; j < length / subLength; j++) {
                int x = i * subLength;
                int y = j * subLength;
                for (int k = 0; k < subLength; k++) {
                    for (int m = 0; m < subLength; m++) {
                        A[x + k][y + m] = temp[y + k][change + m];
                    }
                }
            }
        }
    }
    // 배열 복사
    private static int[][] copy(int x, int y, int subLength) {
        int[][] temp = new int[subLength][subLength];
        for (int i = 0; i < subLength; i++) {
            for (int j = 0; j < subLength; j++) {
                temp[i][j] = A[x + i][y + j];
            }
        }
        return temp;
    }
}
