import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 441284KB, 2696ms
public class B7662 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			TreeMap<Integer, Integer> Q = new TreeMap<Integer, Integer>(); // 이중 우선순위 큐로 사용할 TreeMap
			int k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if(op.equals("I")) { // 정수 n을 Q에 삽입 (I n)
					if(Q.containsKey(num)) { // 동일한 정수가 삽입되는 경우
						Q.put(num, Q.get(num) + 1);
					}
					else {
						Q.put(num, 1);
					}
				}
				else if(op.equals("D")){
					if(Q.isEmpty()) continue; // Q가 비어있는데 적용할 연산이 'D'라면 연산 무시
					if(num == -1) { // 최솟값 삭제 연산 (D -1)
						int key = Q.firstKey();
						if(Q.get(key) > 1) { // 최솟값이 둘 이상인 경우
							Q.put(Q.firstKey(), Q.get(key) - 1);
						}
						else {
							Q.pollFirstEntry();
						}
					}
					else if(num == 1) { // 최댓값 삭제 연산 (D 1)
						int key = Q.lastKey();
						if(Q.get(key) > 1) { // 최댓값이 둘 이상인 경우
							Q.put(Q.lastKey(), Q.get(key) - 1);
						}
						else {
							Q.pollLastEntry();
						}
					}
				}
			}
			// Q가 비어있다면 Empty 출력
			bw.write(Q.isEmpty()? "EMPTY\n" : Q.lastKey() + " " + Q.firstKey() + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
/*
 같은 값이 삽입될 수 있으므로 개수를 세기 위해 Map 사용
 TreeMap 자료구조 사용 : 내부의 값들을 key값을 기준으로 정렬하여 가짐 (레드블랙 트리 자료구조 가짐) -> 삽입 삭제, 순회 시에 O(logN) 만족
 */
