import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (o1, o2) -> {
			if (o1[0].equals(o2[0]))
				return o1[1].compareTo(o2[1]);
			return o1[0].compareTo(o2[0]);
		});

		int[][] book_min = new int[book_time.length][2];
		for (int i = 0; i < book_time.length; i++) {
			for (int j = 0; j < book_time[i].length; j++) {
				int hour = Integer.parseInt(book_time[i][j].substring(0, 2));
				int minute = Integer.parseInt(book_time[i][j].substring(3, 5));
				book_min[i][j] = hour * 60 + minute;
			}
		}
		ArrayList<Integer> room_count = new ArrayList<Integer>();

		room_count.add(book_min[0][1] + 10);
		for (int i = 1; i < book_min.length; i++) {
			boolean flag = false;
			for (int j = 0; j < room_count.size(); j++) {
				if (room_count.get(j) <= book_min[i][0]) {
					room_count.set(j, book_min[i][1] + 10);
					flag = true;
					break;
				}
			}
			if(!flag) {
				room_count.add(book_min[i][1] + 10);
			}
		}

		return room_count.size();
    }
}
