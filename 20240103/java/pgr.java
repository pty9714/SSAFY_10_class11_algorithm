class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[] dpPos = new long[n];
        long[] dpNeg = new long[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) {
                sequence[i] = -1 * sequence[i];
            }
        }
        dpPos[0] = sequence[0];
        dpNeg[0] = sequence[0];
        long answer = Math.max(dpPos[0], Math.abs(dpNeg[0]));
        //dpPos의 최대는 dpNeg의 최소와 같다.
        //dpPos[i]의 값은 dpPos[i-1] + sequence[i]와 sequence[i]의 값 중 최대
        for (int i = 1; i < n; i++) {
            dpPos[i] = Math.max(dpPos[i-1] + sequence[i], sequence[i]);
            dpNeg[i] = Math.min(dpNeg[i-1] + sequence[i], sequence[i]);
            answer = Math.max(answer, Math.max(dpPos[i], Math.abs(dpNeg[i])));
        }
        return answer;
    }
}
