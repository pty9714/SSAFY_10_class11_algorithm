class Solution {
    int MOD = 20170805;

    public static int solution(int m, int n, int[][] cityMap) {
        int k, t, cnt;
        int[][] map = new int[m][n];
        map[0][0] = 1;

        for (int i = 1; i < n; i++) {
            if (cityMap[0][i] == 1) {
                map[0][i] = 0;
            } else {
                map[0][i] = map[0][i - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            if (cityMap[i][0] == 1) {
                map[i][0] = 0;
            } else {
                map[i][0] = map[i - 1][0];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j] == 1) {
                    map[i][j] = 0;
                } else {
                    k = map[i][j - 1];
                    t = map[i - 1][j];
                    cnt = 1;
                    if (cityMap[i][j - cnt] == 2) {
                        while (cityMap[i][j - cnt] == 2) {
                            cnt++;
                            if (j - cnt < 0) {
                                k = 0;
                                break;
                            }
                        }
                        if (j - cnt >= 0) {
                            k = map[i][j - cnt];
                        }
                    }

                    cnt = 1;
                    if (cityMap[i - cnt][j] == 2) {
                        while (cityMap[i - cnt][j] == 2) {
                            cnt++;
                            if (i - cnt < 0) {
                                t = 0;
                                break;
                            }
                        }
                        if (i - cnt >= 0) {
                            t = map[i - cnt][j];
                        }
                    }
                    map[i][j] = (k + t) % 20170805;
                }

            }

        }
        int answer = map[m - 1][n - 1];

        return answer;
    }
}