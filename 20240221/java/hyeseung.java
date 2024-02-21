import java.io.*;
import java.util.*;

// 	11972KB, 88ms
public class B1043 {
    public static HashSet<Integer> ans = new HashSet<>();
    public static ArrayList<ArrayList<Integer>> partyMember = new ArrayList<>(); // 각 파티당 구성원
    public static ArrayList<ArrayList<Integer>> participateParty = new ArrayList<>(); // 각 구성원 당 참여하는 파티
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N, M 초기화
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            participateParty.add(new ArrayList<>());
        }
        for (int i = 0; i <= M; i++) {
            partyMember.add(new ArrayList<>());
        }
        visited = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        // 진실을 말하는 사람들
        int truthCnt = Integer.parseInt(st.nextToken());
        Queue<Integer> truth = new LinkedList<>();
        for (int i = 0; i < truthCnt; i++) {
            truth.offer(Integer.parseInt(st.nextToken()));
        }
        // 파티 참여 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int peopleCnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < peopleCnt; j++) {
                int people = Integer.parseInt(st.nextToken());
                partyMember.get(i+1).add(people);
                participateParty.get(people).add(i+1);
            }
        }

        // 파티 개수의 최댓값 구하기
        while(!truth.isEmpty()) {
            int t = truth.poll();
            if(!visited[t])
                dfs(t);
        }

        bw.write((M - ans.size()) + "");
        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int truth) {
        visited[truth] = true;
        for (int party : participateParty.get(truth)) {
            if(ans.contains(party)) continue;
            ans.add(party);
            for (int member : partyMember.get(party)) {
                if(!visited[member]) dfs(member);
            }
        }
    }
}
