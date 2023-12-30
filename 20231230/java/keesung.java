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

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            people.add(new Person(st));
        }
        int length = Integer.parseInt(br.readLine());
        people.sort(Comparator.comparingInt(o -> o.end));
        PriorityQueue<Person> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
        int count = 0;
        for (Person person : people) {
            pq.add(person);
            while (!pq.isEmpty()) {
                Person peek = pq.peek();
                if (peek.start < person.end - length) {
                    pq.poll();
                } else {
                    break;
                }
            }
            count = Math.max(count, pq.size());
        }
        System.out.println(count);

    }

    public static class Person {
        int start;
        int end;

        public Person(StringTokenizer st) {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            this.start = Math.min(a, b);
            this.end = Math.max(a, b);
        }
    }

}
