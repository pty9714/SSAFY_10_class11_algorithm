package stock.chart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    public static Country[][] map;
    public static int L;
    public static int R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new Country[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                map[i][j] = new Country(i, j, Integer.parseInt(st.nextToken()));
                j++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Country country = map[i][j];
                if (i > 0) {
                    Country neighbor = map[i - 1][j];
                    country.neighbors.add(neighbor);
                }
                if (j > 0) {
                    Country neighbor = map[i][j - 1];
                    country.neighbors.add(neighbor);
                }
                if (i < N - 1) {
                    Country neighbor = map[i + 1][j];
                    country.neighbors.add(neighbor);
                }
                if (j < N - 1) {
                    Country neighbor = map[i][j + 1];
                    country.neighbors.add(neighbor);
                }
            }
        }

        int result = 0;
        boolean isChanged = true;
        while (isChanged) {
            isChanged = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Country country = map[i][j];
                    if (country.visited) {
                        continue;
                    }
                    ArrayList<Country> visited = new ArrayList<>();
                    IntWrapper sum = new IntWrapper(0);
                    IntWrapper count = new IntWrapper(0);
                    country.go(visited, sum, count);
                    if (visited.size() > 1) {
                        isChanged = true;
                        int population = sum.value / count.value;
                        for (Country c : visited) {
                            c.population = population;
                        }
                    }
                }
            }
            if (isChanged) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        Country country = map[i][j];
                        country.visited = false;
                    }
                }
                result++;
            }
        }

        System.out.println(result);

    }

    public static class Country {

        int x;
        int y;
        int population;
        ArrayList<Country> neighbors = new ArrayList<>();
        boolean visited = false;

        public Country(int x, int y, int population) {
            this.x = x;
            this.y = y;
            this.population = population;
        }

        public void go(ArrayList<Country> countries, IntWrapper sum, IntWrapper count) {
            if (this.visited) {
                return;
            }
            this.visited = true;
            countries.add(this);
            sum.add(this.population);
            count.add(1);
            for (Country neighbor : neighbors) {
                if (Math.abs(this.population - neighbor.population) >= L
                    && Math.abs(this.population - neighbor.population) <= R) {
                    neighbor.go(countries, sum, count);
                }
            }
        }

    }

    public static class IntWrapper {
        int value;

        public IntWrapper(int value) {
            this.value = value;
        }

        public void add(int value) {
            this.value += value;
        }
    }
}

// 처음에 int를 go에 전달해줬더니 값이 바뀌지 않았다. 그래서 IntWrapper를 만들어서 전달해주니 값이 바뀌었다.
// 코드가 좀 복잡해서 별로인 것 같다.
// bfs 코드이다 결국 한 지점에서 주변 지점 모두 방문하고 한번에 더해주는 방식을 채택하고 있다.
// 모든 점을 다 확인해서 비효율 적일 수 있다.