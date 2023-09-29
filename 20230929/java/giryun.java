public class giryun {
    public static int solution(int[][] scores) {
        int answer = 1;
        int[] wanho = scores[0];

        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });

        int wanhoPoint = Arrays.stream(wanho).sum();
        int peerPoint = 0;
        for (int[] score : scores) {
            if (score[1] < peerPoint) {
                if (Arrays.equals(score, wanho)) return -1;
            }
            else {
                peerPoint = score[1];
                if (wanhoPoint < Arrays.stream(score).sum()) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] input = {{2,2},{1,4},{3,2},{3,2},{2,1}};
        System.out.println(solution(input));
    }
}

/*
테스트 1 〉	통과 (1.49ms, 76.5MB)
테스트 2 〉	통과 (2.43ms, 70.9MB)
테스트 3 〉	통과 (1.30ms, 73.7MB)
테스트 4 〉	통과 (1.80ms, 72.7MB)
테스트 5 〉	통과 (1.82ms, 77.5MB)
테스트 6 〉	통과 (1.68ms, 71.2MB)
테스트 7 〉	통과 (1.68ms, 82.6MB)
테스트 8 〉	통과 (1.40ms, 72.4MB)
테스트 9 〉	통과 (1.78ms, 73.4MB)
테스트 10 〉	통과 (2.02ms, 71.8MB)
테스트 11 〉	통과 (2.11ms, 75.4MB)
테스트 12 〉	통과 (1.78ms, 71.8MB)
테스트 13 〉	통과 (4.16ms, 77.9MB)
테스트 14 〉	통과 (2.90ms, 77.9MB)
테스트 15 〉	통과 (6.78ms, 94.4MB)
테스트 16 〉	통과 (10.13ms, 83.7MB)
테스트 17 〉	통과 (16.70ms, 84.4MB)
테스트 18 〉	통과 (20.56ms, 80.2MB)
테스트 19 〉	통과 (48.42ms, 91.8MB)
테스트 20 〉	통과 (32.38ms, 104MB)
테스트 21 〉	통과 (26.83ms, 116MB)
테스트 22 〉	통과 (142.63ms, 120MB)
테스트 23 〉	통과 (100.02ms, 111MB)
테스트 24 〉	통과 (173.59ms, 112MB)
테스트 25 〉	통과 (127.82ms, 123MB)
*/
