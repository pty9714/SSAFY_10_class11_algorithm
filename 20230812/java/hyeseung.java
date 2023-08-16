import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
    public static int result = 0, animal[];
    public int solution(int[] info, int[][] edges) {
        for(int i = 0; i < info.length; i++) {
            tree.add(new ArrayList<Integer>());
        }
        boolean visited[] = new boolean[info.length];
        animal = info;
        for(int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        dfs(0, 0, 0, visited);
        
        return result;
    }
    
    public static void dfs(int parent, int sheep, int wolf, boolean[] list) {
        if(animal[parent] == 0) {
            sheep++;
        }
        else if(animal[parent] == 1) {
            wolf++;
        }
        if(sheep <= wolf) return;
        boolean visited[] = list.clone();
        result = Math.max(result, sheep);
        visited[parent] = true;
        
        for(int i = 0; i < visited.length; i++) {
            if(visited[i]) {
                for(int child : tree.get(i)) {
                    if(!visited[child]) dfs(child, sheep, wolf, visited);
                }       
            }
        }
    }    
}