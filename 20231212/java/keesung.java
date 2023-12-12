import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Backjoon {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            int k = Integer.parseInt(br.readLine());
            MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().split(" ");
                if (input[0].equals("I")) {
                    myPriorityQueue.add(Integer.parseInt(input[1]));
                } else if (input[0].equals("D")) {
                    if (myPriorityQueue.getSize() == 0) {
                        continue;
                    }
                    if (input[1].equals("1")) {
                        myPriorityQueue.pollMax();
                    } else if (input[1].equals("-1")) {
                        myPriorityQueue.pollMin();
                    }
                }
            }
            System.out.println(myPriorityQueue.getResult());
        }
    }

    public static class MyPriorityQueue {

        private PriorityQueue<Node> maxQueue = new PriorityQueue<>();
        private PriorityQueue<Node> minQueue = new PriorityQueue<>();
        private Map<Integer, Integer> visited = new HashMap<>();
        private int size = 0;

        public void add(int num) {
            maxQueue.add(new Node(-num));
            minQueue.add(new Node(num));
            visited.put(num, visited.getOrDefault(num, 0) + 1);
            size++;
        }

        public int pollMax() {
            while (true) {
                int num = maxQueue.poll().getNum() * -1;
                if (visited.get(num) > 0) {
                    visited.put(num, visited.get(num) - 1);
                    size--;
                    return num;
                }
            }
        }

        public int pollMin() {
            while (true) {
                int num = minQueue.poll().getNum();
                if (visited.get(num) > 0) {
                    visited.put(num, visited.get(num) - 1);
                    size--;
                    return num;
                }
            }
        }

        public Integer getSize() {
            return size;
        }

        public String getResult() {
            if (size == 0) {
                return "EMPTY";
            }
            int maxValue = pollMax();
            if (size == 0) {
                return maxValue + " " + maxValue;
            }
            int minValue = pollMin();
            return maxValue + " " + minValue;
        }

    }

    public static class Node implements Comparable<Node> {

        private int num;

        public Node(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        @Override
        public int compareTo(Node o) {
            return this.num > o.num ? 1 : -1;
        }
    }

}

// 93%에서 계속 에러남, 찾아보니 오버플로우라 해서 수정했는데도 계속 에러남