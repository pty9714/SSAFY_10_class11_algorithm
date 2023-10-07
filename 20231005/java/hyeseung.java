import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int rows, int columns, int[][] queries) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 배열 인덱스 전환
        int dx[] = { 0, 1, 0, -1 };
        int dy[] = { 1, 0, -1, 0 };
        // 행렬 초기화
        int matrix[][] = new int[rows][columns];
        int number = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = ++number;
            }
        }
        // 우선순위 큐에 바뀐 숫자들을 넣어 가장 작은 숫자 먼저 poll 하도록 함.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int[] query : queries) {
            pq.clear();
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];
            int cnt = (x2 - x1 + 1) * (y2 - y1 + 1) - (x2 - x1 - 1) * (y2 - y1 - 1); // 회전에 의해 바꿀 숫자 개수 (테두리 개수)
            int index = 0; // 방향 전환을 위한 index
            int x = x1 - 1, y = y1 - 1; // 시작 위치
            int before = matrix[x][y]; // 이전 숫자

            for (int i = 0; i < cnt; i++) {
                x += dx[index];
                y += dy[index];
                pq.offer(before);
                // 행렬 숫자 이동
                int temp = matrix[x][y];
                matrix[x][y] = before;
                before = temp;
                if (x + dx[index] < x1 - 1 || x + dx[index] > x2 - 1 || y + dy[index] < y1 - 1
                        || y + dy[index] > y2 - 1) // 방향 전환
                    index = (index + 1) % 4;
            }
            // 가장 작은 숫자 poll해서 answer 배열에 넣음
            answer.add(pq.poll());
        }
        return answer;
    }
}
/*
 * 테스트 1 〉 통과 (0.48ms, 76.1MB)
 * 테스트 2 〉 통과 (0.47ms, 74.1MB)
 * 테스트 3 〉 통과 (68.13ms, 109MB)
 * 테스트 4 〉 통과 (44.33ms, 94.4MB)
 * 테스트 5 〉 통과 (65.69ms, 106MB)
 * 테스트 6 〉 통과 (65.90ms, 91MB)
 * 테스트 7 〉 통과 (67.26ms, 104MB)
 * 테스트 8 〉 통과 (49.43ms, 92.3MB)
 * 테스트 9 〉 통과 (55.97ms, 107MB)
 * 테스트 10 〉 통과 (65.56ms, 90.1MB)
 * 테스트 11 〉 통과 (60.68ms, 102MB)
 */