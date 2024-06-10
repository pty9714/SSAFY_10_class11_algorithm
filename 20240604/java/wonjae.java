import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static room top = new room();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		room current;
		top.down = new room();

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			current = top;
			for(int j = 0; j < k; j++) {
				String name = st.nextToken();
				current = current.down;
				while(true) {
					if(current.next == null) {
						current.next = new room();
						current.next.name = name;
						current.next.down = new room();
						current = current.next;
						break;
					}
					if(current.next.name.equals(name)) {
						current = current.next;
						break;
					}
					if(current.next.name.compareTo(name) > 0) {
						room temp = new room();
						temp.down = new room();
						temp.next = current.next;
						temp.name = name;
						current.next = temp;
						current = current.next;
						break;
					}
					current = current.next;
				}
			}
		}
		print(top, 0);
		System.out.println(sb);
	}
	
	static void print(room curr, int depth) {
		curr = curr.down;
		
		while(curr.next!=null) {
			for(int i =0; i < depth;i++) {
				sb.append("--");
			}
			sb.append(curr.next.name+"\n");
			print(curr.next, depth+1);
			curr = curr.next;
		}
	}

	static class room{
		String name;
		room next = null;
		room down = null;
	}
	
}
