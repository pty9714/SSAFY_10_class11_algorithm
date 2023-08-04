import java.util.*;

class Solution {
    public static Map<String, Integer> courses;
    public List<String> solution(String[] orders, int[] course) {
        
        List<String> answer = new ArrayList<>();
        
        // 후보 찾기
        for(int c : course) {
            // 후보 찾기
            courses = new HashMap<>();
            for(String order : orders) {
                order = sortString(order);
                getCandidate(0, 0, order, "", c);
            }
            // 코스 요리 주문 손님 수 찾기
            List<String> listKeySet = new ArrayList<>(courses.keySet());
            Collections.sort(listKeySet, (value1, value2) -> (courses.get(value2).compareTo(courses.get(value1))));
            int max = 0;
            for(String key : listKeySet) {
                if(courses.get(key) < 2) break;
                if(max > courses.get(key)) break;
                max = courses.get(key);
                answer.add(key);
            }
            
        }
        
        // 오름차순 정렬
        Collections.sort(answer);
        return answer;
    }
    
    // course 개수별 조합
    public static void getCandidate(int cnt, int start, String order, String result, int N) { 
		if(cnt == N) {
            if(courses.containsKey(result)) {
                courses.put(result, courses.get(result) + 1);
            }    
            else {
                courses.put(result, 1);
            }
			return;
		}
		for(int i = start; i < order.length(); i++) {
            result = result.substring(0, cnt) + order.charAt(i);
			getCandidate(cnt + 1, i + 1, order, result, N);
		}
	}
    
    // 문자열 정렬
    public String sortString(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}

// 40.17ms