import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

// 14460KB, 100ms
public class B14226 {
	
	static class Emoticon {
		int clipBoard;
		int screen;
		int time;
		
		Emoticon(int clipBoard, int screen, int time) {
			this.clipBoard = clipBoard;
			this.screen = screen;
			this.time = time;
		}
	}

	public static int S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		S = Integer.parseInt(br.readLine());
		
		int ans = bfs(S);
		bw.write(ans + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int bfs(int s) {
		int time = 0;
		Queue<Emoticon> q = new ArrayDeque<>();
		q.offer(new Emoticon(0, 1, 0));
		boolean visited[][] = new boolean[S + 1][S + 1]; // 행 : 클립보드의 이모티콘 개수, 열 : 화면에 있는 이모티콘 개수
		while(!q.isEmpty()) {
			Emoticon emoticon = q.poll();
			// 이모티콘 개수 만들어졌으면 중단
			if(emoticon.screen == s) {
				time = emoticon.time;
				break;
			}
			// 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
			q.offer(new Emoticon(emoticon.screen, emoticon.screen, emoticon.time + 1));
			
			// 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다. (비어있으면 붙여넣기 X)
			if(emoticon.clipBoard != 0 && emoticon.clipBoard + emoticon.screen <= S && !visited[emoticon.clipBoard][emoticon.clipBoard + emoticon.screen]) {
				q.offer(new Emoticon(emoticon.clipBoard, emoticon.clipBoard + emoticon.screen, emoticon.time + 1));
				visited[emoticon.clipBoard][emoticon.clipBoard + emoticon.screen] = true;
			}
			
			// 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
			if(emoticon.screen > 0 && !visited[emoticon.clipBoard][emoticon.screen - 1]) {
				q.offer(new Emoticon(emoticon.clipBoard, emoticon.screen - 1, emoticon.time + 1));
				visited[emoticon.clipBoard][emoticon.screen - 1] = true;
			}
		}
		return time;
	}
}

/*
 bfs
 -> 접근 방법을 모르겠었음, 3가지 조건에 맞게 큐에 넣어 bfs 수행
*/