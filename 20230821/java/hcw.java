import java.util.*;
import java.io.*;
class Solution {
    static LinkedList<Integer> li = new LinkedList<Integer>();
    static LinkedList<Integer> fin = new LinkedList<Integer>();
    static LinkedList<Integer> f = new LinkedList<Integer>();
    public LinkedList<Integer> solution(int[][] edges, int[] target) {
        Arrays.sort(edges, (el1, el2) -> {
           if(el1[0] == el2[0]){
               return el1[1] - el2[1];
           }else{
               return el1[0] - el2[0];
           }
        });
        
        int max_node = edges[edges.length-1][1];
        int[] lines = new int[max_node+1];
        
        
        ArrayList<Integer>[] list = new ArrayList[max_node+1];
        for(int i =0; i< list.length; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i =0; i< edges.length; i++){
            if(lines[edges[i][0]] == 0){
                lines[edges[i][0]] = edges[i][1]; 
            }else if(edges[i][1] < lines[edges[i][0]]){
                lines[edges[i][0]] = edges[i][1]; 
            }
            list[edges[i][0]].add(edges[i][1]);
        }
        
        
        // for(int i =0;i < edges.length; i++){
            // System.out.println(Arrays.toString(edges[i]));
            // System.out.println("list" + list[i]);
        // }
        // System.out.println(Arrays.toString(lines));
        
        int[] lines_temp = Arrays.copyOf(lines, lines.length);
        boolean flag = true;
        while(flag){
            down(1, lines, list);
            for(int i =0;i < lines.length; i++){
                if(lines_temp[i] != lines[i]){
                    flag = true;
                    break;
                }else{
                    flag = false;
                }
            }
        }


        int[] result = new int[target.length];
        int[] count = new int[target.length];
        for(int i =0; i< li.size(); i++){
            count[li.get(i)-1] ++;
        }
        
        
        
//         
        dfs(0, target, result);
//      
        System.out.println(li);
        System.out.println(Arrays.toString(target));
        System.out.println(Arrays.toString(count));
        
        // return f;
        return f.size() == 0? new LinkedList<>(Arrays.asList(-1)) : f;
        
    }
    
    public void down(int node, int[] lines, ArrayList<Integer>[] list){
        if(lines[node] != 0){
            down(lines[node], lines, list);
            int index = list[node].indexOf(lines[node]);
            if(index + 1 < list[node].size()){ //size안에 있다면
                lines[node] = list[node].get(index+1);
            }else{ //넘어간다면
                lines[node] = list[node].get(0);
            }
        }else{
            li.add(node);
        }
    }
    
    public void dfs(int count, int[] target, int[] result){
        
        boolean flag = false;
        for(int i = 0;i < target.length; i++){
            if(target[i] == result[i]) flag = true;
            else if(target[i] < result[i]) return;
            else{
                flag = false;
                break;
            }
        }
        
        if(flag){
            if(f.isEmpty()) f = (LinkedList)fin.clone();
            else if(f.size() > fin.size()){
                  f = (LinkedList)fin.clone();
            }
            return;
        }

        if(count == li.size()) count = 0;
        
        for(int i = 1; i <= 3; i++){
            result[li.get(count)-1] += i;
            fin.add(i);
            dfs(count+1, target, result);
            result[li.get(count)-1] -= i;
            fin.remove(fin.size()-1);
        }
        
    }
    
    
}
