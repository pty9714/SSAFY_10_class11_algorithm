import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        ArrayList<Application> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(new Application(Integer.parseInt(st.nextToken())));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.get(i).setCost(Integer.parseInt(st.nextToken()));
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Set<Integer> keySet = map.keySet();
            ArrayList<Integer> keyList = new ArrayList<>(keySet);
            keyList.sort(Comparator.comparingInt(o -> o * -1));
            for (int j = 0; j < keyList.size(); j++) {
                int key = keyList.get(j);
                int value = map.get(key);
                int nextKey = key + list.get(i).memory;
                if (nextKey < m) {
                    Integer tmp = map.getOrDefault(nextKey, Integer.MAX_VALUE);
                    map.put(nextKey, Math.min(tmp, value + list.get(i).cost));
                } else {
                    answer = Math.min(answer, value + list.get(i).cost);
                }
            }
        }

        System.out.println(answer);

    }

    public static class Application {

        private int memory;
        private int cost;

        public Application(int memory) {
            this.memory = memory;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }
    }

}