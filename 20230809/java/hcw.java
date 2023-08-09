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



// 	통과 (0.55ms, 76.8MB)
// 테스트 2 〉	통과 (2.76ms, 77.5MB)
// 테스트 3 〉	통과 (18.32ms, 85.2MB)
// 테스트 4 〉	통과 (6.59ms, 84.2MB)
// 테스트 5 〉	통과 (0.48ms, 69.6MB)
// 테스트 6 〉	통과 (9.85ms, 79.6MB)
// 테스트 7 〉	통과 (10.36ms, 75.1MB)
// 테스트 8 〉	통과 (3.90ms, 73.5MB)
// 테스트 9 〉	통과 (2.76ms, 73.6MB)
// 테스트 10 〉	통과 (6.65ms, 71.6MB)
// 테스트 11 〉	통과 (11.90ms, 69.2MB)
// 테스트 12 〉	통과 (12.05ms, 79.4MB)
// 테스트 13 〉	통과 (2.51ms, 78.1MB)
// 테스트 14 〉	통과 (15.73ms, 88.3MB)
// 테스트 15 〉	통과 (10.28ms, 76.5MB)
// 테스트 16 〉	통과 (3.92ms, 79.3MB)
// 테스트 17 〉	통과 (11.66ms, 76.2MB)
// 테스트 18 〉	통과 (7.31ms, 79.8MB)
// 테스트 19 〉	통과 (16.71ms, 80.3MB)
