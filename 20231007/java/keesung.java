import java.io.*;
import java.util.*;
class Solution {

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(1 << 11);
//        System.out.println(1 << 10);
//        System.out.println();
//        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
//        int[] result = s.solution(5, info);
//        for(int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + " ");
//        }
//    }

    public int[] solution(int n, int[] info) {
        // 비용으로 DP 하면 풀릴 것 같은데?
        //


        // 가능한 경우의 수 HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 1 << 11; i++) {
            // i : 비트마스킹
            int cnt = 0;
            for (int j = 0; j < 11; j++) {
                if ((i & (1 << j)) != 0) {
                    cnt += info[j] + 1;
                }
            }
            if (cnt > n) {
                continue;
            }
            set.add(i);
        }

//        System.out.println(set);

        Score[] scores = new Score[11];
        for(int i = 10; i >= 0; i--) {
            Score score = new Score(i, info[10 - i]+1);
            scores[i] = score;
        }
        Arrays.sort(scores);

//        for (Score score : scores) {
//            System.out.println(score);
//        }


        // 비트마스킹 활용 디피

        int[][] dp = new int[1 << 11][n+1];
        for(int i = 0; i < 1 << 11; i++) {
            for(int j = 0; j < n+1; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;

        for(int i = 0; i < 1 << 11; i++) {
            if (!set.contains(i)) {
                continue;
            }
            for(int j = 0; j < n+1; j++) {
                if(dp[i][j] == -1) {
                    continue;
                }
                for(int k = 0; k < 11; k++) {
                    Score score = scores[k];
                    if (j + score.need > n) {
                        continue;
                    }
                    int next = i | (1 << k);
                    dp[next][j + score.need] = Math.max(dp[next][j + score.need], dp[i][j] + score.score);
                }
            }
        }

        int result = -1;
        int[] answer = new int[11];
        for (int i = 0; i < 1 << 11; i++) {
            if (!set.contains(i)) {
                continue;
            }
            for (int j = 0; j < n + 1; j++) {
                int[] arr = new int[11];
                for (int k = 0; k < 11; k++) {
                    if ((i & (1 << k)) != 0) {
                        arr[k] = info[k] + 1;
                    }
                }

                int[] sum = new int[2];
                for (int k = 0; k < 11; k++) {
                    if (arr[k] == 0 && info[k] == 0) {
                        continue;
                    }

                    if (arr[k] > info[k]) {
                        sum[0] += 10 - k; // 라이언 승
                    } else {
                        sum[1] += 10 - k; // 어피치 승
                    }
                }


                if (sum[0] > sum[1]) {
                    if (result < sum[0]) {
                        result = sum[0];
                        answer = arr;
//                        System.out.println("result : " + result + " / " + sum[0] + " / " + Arrays.toString(arr));
//                        for(int m = 0; m < answer.length; m++) {
//                            System.out.print(answer[m] + " ");
//                        }
//                        System.out.println("====================================");
                    } else if (result == sum[0]) {
                        for (int k = 10; k >= 0; k--) {
                            int[] cnts = new int[2];
                            for (int m = 0; m < 11; m++) {
                                cnts[0] += answer[m]; // 라이언 기존
                                cnts[1] += arr[m]; // 라이언 new
                            }

                            if (cnts[0] > cnts[1]) {
                                answer = arr;
                                break;
                            } else if (cnts[0] < cnts[1]) {
                                break;
                            }

                            if (answer[k] > arr[k]) {
                                break;
                            } else if (answer[k] < arr[k]) {
                                answer = arr;
//                                System.out.println("result : " + result + " /=======/ " + Arrays.toString(arr));
//                                for(int m = 0; m < answer.length; m++) {
//                                    System.out.print(answer[m] + " ");
//                                }
//                                System.out.println("====================================");
                                break;
                            }
                        }
                    }
                }

            }
        }

        if (result == -1) {
            return new int[] {-1};
        }

        for (int i = 0; i < 11; i++) {
            n -= answer[i];
        }
        answer[10] += n;
        return answer;
    }

    public class Score implements Comparable<Score>{
        int score;
        int need;
        float comp;

        Score(int score, int need) {
            this.score = score;
            this.need = need;
            this.comp = (float) score / need;
        }

        @Override
        public int compareTo(Score o) {
            return (int) (this.comp - o.comp);
        }

        public String toString() {
            return "score : " + this.score + " / need " + this.need;
        }

    }
}