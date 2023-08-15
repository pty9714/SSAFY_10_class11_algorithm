import java.util.*;
 
class Solution {
	static ArrayList<Integer>[] childs;
	static int[] Info;
	static int maxSheepCnt = 0;
    
    	private static void dfs(int idx, int sheepCnt, int wolfCnt, List<Integer> nextPos) {
		// 늑대/양 수, 양의 최대값 최신화
		if (Info[idx] == 0) sheepCnt++;
		else wolfCnt++;
 
		if (wolfCnt >= sheepCnt) return;
		maxSheepCnt = Math.max(sheepCnt, maxSheepCnt); //계속 갱신
   
		// 다음 탐색 위치 갱신
		List<Integer> list = new ArrayList<>();
		list.addAll(nextPos);
		// 다음 탐색 목록중 현재 위치 제거
		list.remove(Integer.valueOf(idx));
        
		if (childs[idx] != null) { //자식있을때
			for (int child : childs[idx]) { // 자식 노드들을 넣어줌
				list.add(child);
			}
		}
        
		// 갈수 있는 모든 Node Dfs
		for (int next : list) {
			dfs(next, sheepCnt, wolfCnt, list);
		}
	}
 
	public static int solution(int[] info, int[][] edges) {
		Info = info;
		childs = new ArrayList[info.length];
		for (int[] l : edges) {
			int parent = l[0];
			int child = l[1];
			if (childs[parent] == null) {
				childs[parent] = new ArrayList<>();
			}
			childs[parent].add(child);
		}
 
		List<Integer> list = new ArrayList<>();
		list.add(0);
		dfs(0, 0, 0, list);
		return maxSheepCnt;
	}
 

}
