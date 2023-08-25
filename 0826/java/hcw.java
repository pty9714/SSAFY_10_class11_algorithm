import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        
        String[] arr= play_time.split(":");
        int pt= Integer.parseInt(arr[0])*3600
                +Integer.parseInt(arr[1])*60+Integer.parseInt(arr[2]);
        arr = adv_time.split(":");
        int at= Integer.parseInt(arr[0])*3600
                +Integer.parseInt(arr[1])*60+Integer.parseInt(arr[2]);
        
        int[] count = new int[pt+1];
        
        for(int i = 0; i< logs.length; i++){
            String[] t = logs[i].split("-");
            String[] temp= t[0].split(":");
        int s = Integer.parseInt(temp[0])*3600
                +Integer.parseInt(temp[1])*60+Integer.parseInt(temp[2]);
        temp= t[1].split(":");
        int e = Integer.parseInt(temp[0])*3600
                +Integer.parseInt(temp[1])*60+Integer.parseInt(temp[2]);

            for(int j = s; j < e; j++){
                count[j]++;
                
            }
        }

        long max = 0;
        long c = 0;
        for(int j = 1; j < at; j++){
               max += count[j];
            }
        
        c = max;
        int time = 0;
        int start = 0;
        int end  = at;
        
        
        while(end != pt){
            c-=count[start];
            c+=count[end];
            
            start++;
            end++;
            if(c > max){
                time = start;
                max = c;
            }
        }
        
        String hh, mm, ss;
        hh= (time/3600)>9? (time/3600)+"":"0"+time/3600;
        time%=3600;
        mm= (time/60)>9? (time/60)+"":"0"+time/60;
        time%=60;
        ss= time>9? time+"":"0"+time;

        String answer = hh+":"+mm+":"+ss;
        return answer;
    }
}

테스트 1 〉	통과 (19.93ms, 83.4MB)
테스트 2 〉	통과 (31.86ms, 100MB)
테스트 3 〉	통과 (50.02ms, 109MB)
테스트 4 〉	통과 (128.95ms, 130MB)
테스트 5 〉	통과 (132.04ms, 140MB)
테스트 6 〉	통과 (33.65ms, 93.1MB)
테스트 7 〉	통과 (235.71ms, 235MB)
테스트 8 〉	통과 (2027.91ms, 197MB)
테스트 9 〉	통과 (1227.46ms, 298MB)
테스트 10 〉	통과 (1730.72ms, 307MB)
테스트 11 〉	통과 (480.19ms, 280MB)
테스트 12 〉	통과 (240.88ms, 283MB)
테스트 13 〉	통과 (1081.48ms, 282MB)
테스트 14 〉	통과 (401.75ms, 284MB)
테스트 15 〉	통과 (22.19ms, 85.9MB)
테스트 16 〉	통과 (266.60ms, 300MB)
테스트 17 〉	통과 (3950.84ms, 281MB)
테스트 18 〉	통과 (233.80ms, 300MB)
테스트 19 〉	통과 (19.26ms, 87.2MB)
테스트 20 〉	통과 (24.76ms, 78.7MB)
테스트 21 〉	통과 (117.00ms, 148MB)
테스트 22 〉	통과 (106.99ms, 149MB)
테스트 23 〉	통과 (700.92ms, 288MB)
테스트 24 〉	통과 (228.48ms, 286MB)
테스트 25 〉	통과 (17.70ms, 84.5MB)
테스트 26 〉	통과 (22.94ms, 88.3MB)
테스트 27 〉	통과 (21.27ms, 83.4MB)
테스트 28 〉	통과 (18.36ms, 80MB)
테스트 29 〉	통과 (23.63ms, 84.8MB)
테스트 30 〉	통과 (20.42ms, 73.1MB)
테스트 31 〉	통과 (22.39ms, 69.5MB)
