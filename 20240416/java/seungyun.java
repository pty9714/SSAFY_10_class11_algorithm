import java.util.*;
class Solution {
    
    static class Node{
        String name;
        int start;
        int time;
        public Node(String name, int start, int time){
            this.name = name;
            this.start = start;
            this.time = time;
        }
        public Node(String name, int time){
            this.name = name;
            this.time = time;
        }
    }
    
    public ArrayList<String> solution(String[][] plans) {
        String[] answer = {};
        
        // 1. 시작시간 순으로 정렬
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (o1,o2) -> (o1.start - o2.start)
        );
        
        for(int i=0; i<plans.length; i++){
            String name = plans[i][0];
            String[] str = plans[i][1].split(":");
            int hour = Integer.parseInt(str[0]);
            int min = Integer.parseInt(str[1]);
            int start = hour*60 + min;
            int time = Integer.parseInt(plans[i][2]);
            
            pq.add(new Node(name, start, time));
        }
        // 멈춘과제 저장
        Stack<Node> stack = new Stack<>();
        ArrayList<String> answerList = new ArrayList<>();
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            String name = node.name;
            int start = node.start;
            int time = node.time;
            
            int curTime = start;
            
            if(!pq.isEmpty()){
                Node nextNode = pq.peek();
                // 다음 꺼 시작 시간보다 아래면
                if(curTime + time <= nextNode.start){ // 현재시간 + 걸린시간 < 다음시작시간
                    answerList.add(name); // 답에 추가
                    curTime += time;
                    
                    // 멈춘 과제 진행
                    while(!stack.isEmpty()){
                        Node stopNode = stack.pop();
                        
                        // 다음 시간 전까지 실행가능하면
                        if(curTime + stopNode.time <= nextNode.start){
                            curTime += stopNode.time;
                            answerList.add(stopNode.name);
                            continue;
                        } else{ // 초과되면 다시 추가
                            // 
                            int gap = stopNode.time - (nextNode.start - curTime);
                            stack.push(new Node(stopNode.name, gap));
                            break;
                        }
                    }
                } else{ // 못끝내는 경우 // 현재시간 + 걸린시간 > 다음시작시간
                    int gap = nextNode.start - start;
                    stack.add(new Node(name, time - gap));
                }
            }
            // 과제가 비어있을때
            else {
                // 멈춘 과제가 있을때
                if(!stack.isEmpty()) {
                    answerList.add(name);
                    
                    // 남아있는 과제들을 정해진 순서대로 끝내면 됨
                    while(!stack.isEmpty()) {
                        Node stopNode = stack.pop();
                        answerList.add(stopNode.name);
                    }
                }
                // 남아있는 과제는 있는 경우
                else {
                    curTime += time;
                    answerList.add(name);
                }
            }
        }
        
       
        
        return answerList;
    }
}