import java.io.*;
import java.util.*;

// 	152732KB, 472ms
public class B1327 {
    public static int N, K;
    static class Sequence {
        String sequence;
        int cnt;
        Sequence(String sequence, int cnt) {
            this.sequence = sequence;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        String seqStr = "";
        String sortedSeqStr = "";
        for (int i = 0; i < N; i++) {
            seqStr += seq[i];
        }
        Arrays.sort(seq);
        for (int i = 0; i < N; i++) {
            sortedSeqStr += seq[i];
        }
        bw.write(bfs(seqStr, sortedSeqStr) + "");
        bw.flush();
        bw.close();
        br.close();
    }
    private static int bfs(String seq, String sortedSeq) {
        Queue<Sequence> q = new ArrayDeque<>();
        HashSet<String> hs = new HashSet<>();
        q.offer(new Sequence(seq, 0));
        hs.add(seq);
        while(!q.isEmpty()) {
            Sequence cur = q.poll();
            if(cur.sequence.equals(sortedSeq)) {
                return cur.cnt;
            }
            for (int i = 0; i <= N - K; i++) {
                String next = reverse(cur.sequence, i);
                if(!hs.contains(next)) {
                    q.offer(new Sequence(next, cur.cnt + 1));
                    hs.add(next);
                }
            }
        }
        return -1;
    }

    private static String reverse(String seq, int index) {
        String temp = "";
        for (int i = index + K - 1; i >= index; i--) {
            temp += String.valueOf(seq.charAt(i));
        }
        return seq.substring(0, index) + temp + seq.substring(index + K, N);
    }
}
