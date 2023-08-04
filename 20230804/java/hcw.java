import java.io.*;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

	static StringBuilder sb = new StringBuilder();
	static Map<String, Integer> map = new HashMap<String, Integer>();

	static void combination(int count, int depth, Character[] arr, int index, String[] orders, int courseIndex, int[] max_arr) {
		if (count == depth) {
			int c = 0;
			for (int p = 0; p < orders.length; p++) {
				boolean flag = true;
				for (int j = 0; j < depth; j++) {
					if (!orders[p].contains(Character.toString(sb.charAt(j)))) {
						flag = false;
                        break;
					}
				}
				if (flag) c++;
			}

			if (c >= 2 && max_arr[courseIndex] <= c) {
				max_arr[courseIndex] = c;
				map.put(sb.toString(), c);
			}

			return;
		} else {
			for (int i = index; i < arr.length; i++) {
				sb.append(arr[i]);
				combination(count + 1, depth, arr, i + 1, orders, courseIndex, max_arr);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
    
    public List<String> solution(String[] orders, int[] course) {

		int[] max_arr = new int[course.length];
		HashSet<Character> hashset = new HashSet<>();

		for (int i = 0; i < orders.length; i++) {
			for (int j = 0; j < orders[i].length(); j++) {
				hashset.add(orders[i].charAt(j));
			}
		}

		Character[] arr = hashset.toArray(new Character[0]);

		for (int i = 0; i < course.length; i++) {
			combination(0, course[i], arr, 0, orders, i, max_arr);
		}

		Set<String> keySet = map.keySet();
		List<String> answer = new LinkedList<String>();
		
		
		for(int i =0 ; i< course.length; i++) {
			for (String key : keySet) {
				if(key.length() == course[i] && map.get(key) == max_arr[i]) {
					answer.add(key);
				}
			}
		}
		
		Collections.sort(answer);
		System.out.println(answer);
        return answer;
    }
}


// 테스트 1 〉	통과 (3.50ms, 77.8MB)
// 테스트 2 〉	통과 (3.01ms, 73.6MB)
// 테스트 3 〉	통과 (1.90ms, 80.5MB)
// 테스트 4 〉	통과 (4.71ms, 73.4MB)
// 테스트 5 〉	통과 (3.19ms, 77.3MB)
// 테스트 6 〉	통과 (4.30ms, 69.8MB)
// 테스트 7 〉	통과 (4.31ms, 73.9MB)
// 테스트 8 〉	통과 (6.69ms, 84.8MB)
// 테스트 9 〉	통과 (12.10ms, 84.5MB)
// 테스트 10 〉	통과 (96.87ms, 126MB)
// 테스트 11 〉	통과 (111.78ms, 143MB)
// 테스트 12 〉	통과 (127.55ms, 125MB)
// 테스트 13 〉	통과 (2715.62ms, 402MB)
// 테스트 14 〉	통과 (3194.46ms, 381MB)
// 테스트 15 〉	통과 (1411.38ms, 400MB)
// 테스트 16 〉	통과 (13.19ms, 90.2MB)
// 테스트 17 〉	통과 (39.04ms, 100MB)
// 테스트 18 〉	통과 (31.14ms, 101MB)
// 테스트 19 〉	통과 (4.26ms, 73.3MB)
// 테스트 20 〉	통과 (8.53ms, 82.9MB)
// 채점 결과
// 정확성: 100.0
// 합계: 100.0 / 100.0
