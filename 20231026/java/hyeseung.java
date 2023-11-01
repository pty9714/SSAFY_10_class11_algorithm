import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 57528KB, 712ms
public class B1374 {
	// 강의 클래스
	static class Lecture implements Comparable<Lecture> {
		int startTime; // 시작시간
		int endTime; // 종료시간
		
		public Lecture(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		@Override
		public int compareTo(Lecture o) { // 시작시간, 종료시간 순으로 오름차순 정렬
			if(this.startTime == o.startTime) {
				return this.endTime - o.endTime;
			}
			return this.startTime - o.startTime;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		PriorityQueue<Lecture> lectures = new PriorityQueue<>();
		PriorityQueue<Integer> endTime = new PriorityQueue<>(); // 종료시간만 저장
		// 입력 받기
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			lectures.offer(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		// 시작시간, 종료시간 순으로 정렬된 입력값들을 순서대로 뽑으면서 
		// 종료시간만 저장된 우선순위 큐에 현재 뽑은 강의의 시작시간보다 작거나 같으면 종료시간 poll 후 현재 뽑은 강의의 종료시간 offer
		// -> 한 강의실에서 현재 진행 중인 강의 종료 후 다음 강의 시작할 수 있으니까
		for (int i = 0; i < N; i++) {
			Lecture curLecture = lectures.poll();
			if(!endTime.isEmpty() && endTime.peek() <= curLecture.startTime) {
				endTime.poll();
			}
			endTime.offer(curLecture.endTime);
		}
		
		// 종료시간 개수 출력
		bw.write(endTime.size() + "");
		bw.flush();
		bw.close();
		br.close();		
	}
}
