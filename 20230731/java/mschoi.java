import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class B2212 {

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int K = Integer.parseInt(bufferedReader.readLine());
        List<Integer> sensors = Arrays.stream(bufferedReader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.sort(sensors);
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < sensors.size() - 1; i++) {
            diff.add(sensors.get(i + 1) - sensors.get(i));
        }

        Collections.sort(diff);
        System.out.println(diff.subList(0, Math.max(0, N-K)).stream().mapToInt(Integer::intValue).sum());

    }
}

---
# 18524 KB  |	248 ms
