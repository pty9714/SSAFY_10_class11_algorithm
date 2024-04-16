import java.util.*;


class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        Arrays.sort(plans,(a, b)->getNum(a[1])-getNum(b[1]));
        Stack<Subject> s = new Stack<>();
        LinkedList<String> ll = new LinkedList<>();
    
        String curr = plans[0][1];
        s.add(new Subject(plans[0][0], Integer.parseInt(plans[0][2])));
        
        for(int i = 1; i < plans.length; i++){
            int k = minus(plans[i][1], curr);
            curr = plans[i][1];
            while(k>0&&!s.isEmpty()){
                Subject c = s.pop();
                if(c.left > k) {
                    s.add(new Subject(c.name, c.left-k));
                    k = 0;
                }
                else{
                    ll.add(c.name);
                    k-=c.left;
                }
            }
            s.add(new Subject(plans[i][0], Integer.parseInt(plans[i][2])));
        }
        
        while(!s.isEmpty()){
            ll.add(s.pop().name);
        }
        
        answer = ll.toArray(new String[ll.size()]);
        
        return answer;
    }
    
    static int getNum(String num){
        int ans = (num.charAt(0)-'0') * 1000 + (num.charAt(1)-'0') * 100 + (num.charAt(3)-'0') * 10 + (num.charAt(4)-'0'); 
        return ans;
    }
    
    static int minus(String a, String b){
        int x = (a.charAt(0)-'0') * 10 + (a.charAt(1)-'0') - (b.charAt(0)-'0') * 10 - (b.charAt(1)-'0'); 
        int y = (a.charAt(3)-'0') * 10 + (a.charAt(4)-'0') - (b.charAt(3)-'0') * 10 - (b.charAt(4)-'0');
        return x*60 + y;
    }
    
    static class Subject{
        String name;
        int left;
        Subject(String name, int left){
            this.name = name;
            this.left = left;
        }
    }
}

/*
테스트 1 〉	통과 (0.81ms, 78.5MB)
테스트 2 〉	통과 (0.92ms, 73.3MB)
테스트 3 〉	통과 (0.84ms, 77.8MB)
테스트 4 〉	통과 (0.89ms, 77.7MB)
테스트 5 〉	통과 (0.87ms, 74MB)
테스트 6 〉	통과 (1.02ms, 78.2MB)
테스트 7 〉	통과 (1.07ms, 72.4MB)
테스트 8 〉	통과 (1.24ms, 76.8MB)
테스트 9 〉	통과 (1.58ms, 79.2MB)
테스트 10 〉	통과 (1.46ms, 77.7MB)
테스트 11 〉	통과 (2.37ms, 74.8MB)
테스트 12 〉	통과 (3.55ms, 74.9MB)
테스트 13 〉	통과 (4.83ms, 81.3MB)
테스트 14 〉	통과 (4.91ms, 94.9MB)
테스트 15 〉	통과 (4.71ms, 84.7MB)
테스트 16 〉	통과 (0.86ms, 78MB)
테스트 17 〉	통과 (0.85ms, 75.9MB)
테스트 18 〉	통과 (0.89ms, 86.7MB)
테스트 19 〉	통과 (0.82ms, 76.3MB)
테스트 20 〉	통과 (1.43ms, 74.4MB)
테스트 21 〉	통과 (1.64ms, 74MB)
테스트 22 〉	통과 (5.28ms, 88.9MB)
테스트 23 〉	통과 (4.94ms, 81.7MB)
테스트 24 〉	통과 (5.49ms, 77MB)
*/
