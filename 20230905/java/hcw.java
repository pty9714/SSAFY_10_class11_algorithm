import java.util.*;
class Solution {
    public int solution(int N, int number) {
        
        int[] arr = new int[32000];
        
        Set<Integer>[] set = new HashSet[9];
        int n = 0;
        for (int i = 1; i < 9; i++) {
            n = (n * 10) + N;
            set[i] = new HashSet<>();
            set[i].add(n);
        }

        for(int i =1; i< 8; i++){
            for(Integer el : set[i]){
                set[i+1].add(el/N);
                set[i+1].add(el*N);
                set[i+1].add(el+N);
                set[i+1].add(el-N);
                if(el != 0)
                set[i+1].add(N/el);
            }
        }

        
         for(int i =2; i<= 8; i++){
            for(int j = 1; j < i; j++){
                for(Integer el : set[i-j]){ //i에 있는 것
                    for(Integer el1 : set[j]){ //j에 있는것
                        set[i].add(el + el1);
                        set[i].add(el * el1);
                        if(el1 != 0)
                        set[i].add(el / el1);
                        set[i].add(el - el1);
                        if(el != 0)
                        set[i].add(el1 / el);
                    }
                }
            }
             
        }
        
       
        
        for(int i =1; i< 9; i++){
            if(set[i].contains(number)){
                return i;
            }
        }
        return -1;

    }
}

테스트 1 〉	통과 (31.28ms, 93.8MB)
테스트 2 〉	통과 (7.44ms, 75.2MB)
테스트 3 〉	통과 (15.68ms, 87.2MB)
테스트 4 〉	통과 (34.92ms, 81.4MB)
테스트 5 〉	통과 (23.32ms, 76.5MB)
테스트 6 〉	통과 (25.56ms, 87.9MB)
테스트 7 〉	통과 (40.35ms, 83.6MB)
테스트 8 〉	통과 (40.50ms, 90.6MB)
테스트 9 〉	통과 (22.58ms, 79.8MB)
