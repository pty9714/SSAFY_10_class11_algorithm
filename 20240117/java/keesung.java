package stock.chart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //
        int K = Integer.parseInt(st.nextToken()); //

        ArrayList<Jual> juals = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            juals.add(new Jual(br.readLine()));
        }

        ArrayList<Bag> bags = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            bags.add(new Bag(Integer.parseInt(br.readLine())));
        }

        juals.sort(Jual::compareToValue);
        juals.sort(Jual::compareToWeight);
        bags.sort(Bag::compareToWeight);
        int jualIndex = 0;
        int bagNumber = 0;
        // PriorityQueue<Jual> pq = new PriorityQueue<>((o1, o2) -> o1.value -
        // o2.value);
        PriorityQueue<Jual> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        Long answer = 0L;
        while (bagNumber < bags.size() && jualIndex < juals.size()) {
            Jual jual = juals.get(jualIndex);
            Bag bag = bags.get(bagNumber);
            if (bag.weight < jual.weight) {
                bagNumber++;
                continue;
            }
            if (pq.size() == bagNumber + 1) {
                if (pq.peek().value > jual.value) {
                    jualIndex++;
                    continue;
                }
                if (pq.peek().value < jual.value) {
                    if (bagNumber < bags.size()) {
                        bagNumber++;
                    } else {
                        pq.poll();
                    }
                    pq.add(jual);
                    jualIndex++;
                    continue;
                }
            }
            if (pq.size() < bagNumber + 1) {
                pq.add(jual);
                jualIndex++;
                continue;
            }
        }

        System.out.println("=====");
        for (Jual jual : pq) {
            answer += jual.value;
            System.out.println(jual.value);
        }
        System.out.println("=====");
        System.out.println(answer);
    }

    public static class Jual {

        int index;
        int weight;
        int value;

        public Jual(String text) {
            StringTokenizer st = new StringTokenizer(text);
            this.weight = Integer.parseInt(st.nextToken());
            this.value = Integer.parseInt(st.nextToken());
        }

        public int compareToValue(Jual o) {
            float a = (float) this.value / this.weight;
            float b = (float) o.value / o.weight;
            return Float.compare(b, a);
        }

        public int compareToWeight(Jual o) {
            return this.weight - o.weight;
        }
    }

    public static class Bag {

        int weight;

        public Bag(int weight) {
            this.weight = weight;
        }

        public int compareToWeight(Bag o) {
            return this.weight - o.weight;
        }

    }
}