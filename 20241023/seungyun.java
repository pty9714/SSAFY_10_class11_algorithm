import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static class Node{
        int time;
        int finishTime;
        ArrayList<Integer> frontNodes;
        public Node(int time){
            this.time = time;
            frontNodes = new ArrayList<>();
        }
    }

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Node[] nodeList = new Node[N+1];

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            nodeList[i] = new Node(time);
            int M = Integer.parseInt(st.nextToken());
            for(int j = 0; j < M; j++){
                int nodeNum = Integer.parseInt(st.nextToken());
                nodeList[i].frontNodes.add(nodeNum);
            }
        }

        // 1번 노드는 항상 time이 끝난 시각
        nodeList[1].finishTime = nodeList[1].time;

        // finish 시각 저장
        for(int i = 2; i <= N; i++){
            int max = 0;
            for(int j = 0; j < nodeList[i].frontNodes.size(); j++){
                int idx = nodeList[i].frontNodes.get(j); // 선행 노드 번호
                max = Math.max(max, nodeList[idx].finishTime);
            }
            nodeList[i].finishTime = max + nodeList[i].time;
            answer = Math.max(answer, nodeList[i].finishTime);
        }
        System.out.println(answer);
    }
}
