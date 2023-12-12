package stock.chart;

import java.io.BufferedReader;
import java.io.IOException;
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
            if (myPriorityQueue.getSize() == 0) {
                System.out.println("EMPTY");
            } else {
                System.out.println(myPriorityQueue.pollMax() + " " + myPriorityQueue.pollMin());
            }
        }
    }

    public static class MyPriorityQueue {

        private PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        private PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        private int size = 0;

        public void add(int num) {
            maxQueue.add(-num);
            minQueue.add(num);
            size++;
        }

        public int pollMax() {
            size--;
            // minQueue.remove(maxQueue.peek() * -1);
            return maxQueue.poll() * -1;
        }

        public int pollMin() {
            size--;
            // maxQueue.remove(minQueue.peek() * -1);
            return minQueue.poll();
        }

        public int getSize() {
            return size;
        }

    }

}
