import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Stream;
public class keesung {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int height = Integer.parseInt(input[0]);
        int width = Integer.parseInt(input[1]);
        int[] waters = Stream.of(br.readLine().split(" ")).limit(width).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        HashSet set = new HashSet();
        int max = 0;
        int index = 0;
        int startIndex = 0;
        for (int i = 0; i < width; i++) {
            if (waters[i] >= max) {
                index = i;
                max = waters[index];
                if (set.size() == 0) {
                    startIndex = index;
                }
                set.add(index);
            }
        }
        max = 0;
        int rightIndex = width-1;
        for (int j = width-1; j >= 0; j--) {
            if (max <= waters[j]) {
                rightIndex = j;
                max = waters[rightIndex];
                set.add(rightIndex);
            }
        }
//        System.out.println(set.toString());
        while (true) {
            int tmpIndex = startIndex + 1;
            if (tmpIndex >= width) {
                break;
            }
            while (true) {
                if (set.contains(tmpIndex)) {
                    for (int i = startIndex+1; i < tmpIndex; i++) {
                        sum -= waters[i];
                    }
//                    System.out.printf("%d %d %d", (tmpIndex - startIndex - 1), tmpIndex, startIndex);
                    sum += Math.min(waters[tmpIndex], waters[startIndex]) * (tmpIndex - startIndex - 1);
                    startIndex = tmpIndex;
                    break;
                } else {
                    tmpIndex++;
                    if (tmpIndex >= width) {
                        startIndex = tmpIndex;
                        break;
                    }
                }

            }
        }
        System.out.println(sum);

    }

}


// 시간 240ms
// 접근법 : 앞 뒤로 가장 Max인 값들을 Set에 넣어둔다.
// 해당 Max값에 해당하는 것들의 사이 값들을 모두 빼준 다음, Max값 두개중 작은 것을 곱해서 더해준다.