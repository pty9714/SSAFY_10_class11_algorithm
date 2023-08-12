import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
    public static int result = 0;
    public static int[] node;

    public int solution(int[] info, int[][] edges) {
         
        boolean[] visited = new boolean[info.length];
        node = info;
        for(int i = 0; i < info.length; i++) {
            map.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        dfs(0, 0, 0, visited);

        return result;
    }
    
    public static void dfs(int num, int sheep, int wolf, boolean[] list) {
        if(node[num] == 0) {
            sheep++;
        }
        
        else if(node[num] == 1) {
            wolf++;
        }
        
        if(wolf >= sheep) {
            return;
        }

        boolean[] newList = list.clone();
        newList[num] = true;
        result = Math.max(result, sheep);

        for(int i = 0; i < newList.length; i++) {
            if(newList[i] == true) {
                for(int j = 0; j < map.get(i).size(); j++) {
                    int temp = map.get(i).get(j);
                    if(newList[temp] == false) {
                        dfs(temp, sheep, wolf, newList);
                    }
                }
            }
        }
    }
}