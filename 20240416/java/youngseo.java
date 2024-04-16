import java.util.*;
class Solution {
    
    static class Task implements Comparable<Task> {
        private String name;
        private int start;
        private int playtime;
        
        public Task(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
        
        @Override
        public int compareTo(Task o){
            return this.start - o.start;
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        List<Task> tasks = new ArrayList<>();
        for(int i=0; i<plans.length; i++){
            String name = plans[i][0];
            String[] start = plans[i][1].split(":");
            int hour = Integer.parseInt(start[0]);
            int min = Integer.parseInt(start[1]);
            int time = Integer.parseInt(plans[i][2]);
            
            tasks.add(new Task(name, hour*60 + min, time));
        }
        
        Collection.sort(tasks);
        
        Stack<task> work = new Stack<>();
        for(int i=0; i<tasks.size()-1; i++){
            Task curTask = tasks.get(i);
            Task nextTask = tastks.get(i+1);
            
            
            
        }
        
        return answer;
    }
    
    
}
