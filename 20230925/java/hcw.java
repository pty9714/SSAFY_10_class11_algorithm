import java.util.*;
class Solution {
    static int[] parents;
    static class Node{
        public int sales;
        public LinkedList<Integer> li = new LinkedList<>();
        public Node(int sales){
            this.sales = sales;
        }
    }
    void make(){
        for(int i =1; i< parents.length; i++){
            parents[i] = i;
        }
    }
    
    
    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        Node[] nodes = new Node[sales.length+1];
        
        for(int i = 0; i < sales.length; i++){
            nodes[i+1] = new Node(sales[i]);
        }
        for(int i = 0; i < links.length; i++){
            nodes[links[i][0]].li.add(links[i][1]);
        }
        parents = new int[sales.length+1];
        make();
        for(int i =0 ; i< links.length; i++){
            parents[links[i][1]] = links[i][0];
        }
        System.out.println(Arrays.toString(parents));
        
        
        return answer;
    }
}
