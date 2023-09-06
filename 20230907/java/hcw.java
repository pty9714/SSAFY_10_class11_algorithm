import java.util.*;
import java.awt.*;
class Solution {
    static Point[][] p = new Point[51][51]; 
    private static void make(){
        for(int i =1; i< 51; i++){
            for(int j = 1; j < 51; j++){
                p[i][j] = new Point(j, i); //  x , y로 넣어줌
            }
        }
    }
    
    private static Point find(int r, int c){
        Point t = p[r][c];
        int tx = t.x;
        int ty = t.y;
        
        if(ty == r && tx == c){
            return t;
        }else{
            return p[r][c] = find(ty, tx);
        }
    }
    
    private static boolean union(int r, int c, int r1, int c1){
        Point t = find(r, c);
        Point t1 = find(r1, c1);
        
        if(t.x == t1.x && t.y == t1.y){
            return false;
        }else{
            p[t1.y][t1.x] = t;
            return true;
        }
    }
    
    public static LinkedList<String> solution(String[] commands) {
        LinkedList<String> answer = new LinkedList<>();
        
        String[][] arr = new String[51][51];
        for(int r = 1; r <51; r++){
                        for(int c = 1; c <51; c++){
                           arr[r][c] = "EMPTY";
                        }
                    }
         make();
        for(int i =0 ; i< commands.length; i++){
            String[] com = commands[i].split(" ");
            if(com[0].equals("UPDATE")){ //update
                if(com.length == 4){ //직접 값 입력
                    int r = Integer.parseInt(com[1]);
                    int c = Integer.parseInt(com[2]);
                    Point t = find(r, c);
                    arr[t.y][t.x] = com[3];
                }else if(com.length == 3){ //값을 붙여넣기 한다.
                    for(int r = 1; r <51; r++){
                        for(int c = 1; c <51; c++){
                            if(arr[r][c].equals(com[1])){
                                 arr[r][c] = com[2];
                            }
                        }
                    }
                }
            }
            else if(com[0].equals("MERGE")){ //merge
                union(Integer.parseInt(com[1]), Integer.parseInt(com[2]), Integer.parseInt(com[3]), Integer.parseInt(com[4]));
            }
            else if(com[0].equals("UNMERGE")){ //unmerge
                LinkedList<Point> list = new LinkedList<>();
                Point ct = find(Integer.parseInt(com[1]), Integer.parseInt(com[2])); //부모를 우선 찾음
                arr[Integer.parseInt(com[1])][Integer.parseInt(com[2])] = arr[ct.y][ct.x]; //현재 꼭대기에 있는 값 넣어줌
                
                for(int r = 1; r <51; r++){
                        for(int c = 1; c <51; c++){
                            Point t = find(r, c); //루트의 point 가져옴
                            
                            if(t.x == ct.x && t.y == ct.y){ // 같다면 셀이 병합되어있다는 뜻
                                if(r == Integer.parseInt(com[1]) && c == Integer.parseInt(com[2])) continue;
                                else list.add(new Point(c, r)); //병합되어 있는 곳 좌표
                            }
                        }
                 }
                
                 for(int j = 0; j < list.size(); j++){
                        Point temp = list.get(j);
                        p[temp.y][temp.x] = new Point(temp.x, temp.y); //제자리 포인터를 넣어준다.
                        arr[temp.y][temp.x] = "EMPTY"; //현재에는 EMPTY를 넣어준다.
                 }
                p[Integer.parseInt(com[1])][Integer.parseInt(com[2])] = new Point(Integer.parseInt(com[2]), Integer.parseInt(com[1]));
            }else if(com[0].equals("PRINT")){ //merge
                Point tt = find(Integer.parseInt(com[1]), Integer.parseInt(com[2]));
                answer.add(arr[tt.y][tt.x]);
            }
        
        

        return answer;
    }
    
    
    
}



// 테스트 1 〉	통과 (1.68ms, 80.7MB)
// 테스트 2 〉	통과 (1.37ms, 73.9MB)
// 테스트 3 〉	통과 (0.88ms, 80MB)
// 테스트 4 〉	통과 (0.70ms, 77.1MB)
// 테스트 5 〉	통과 (1.26ms, 73.9MB)
// 테스트 6 〉	실패 (0.71ms, 78.7MB)
// 테스트 7 〉	통과 (1.21ms, 76.3MB)
// 테스트 8 〉	통과 (1.03ms, 76.1MB)
// 테스트 9 〉	통과 (2.69ms, 84MB)
// 테스트 10 〉	통과 (3.45ms, 79.8MB)
// 테스트 11 〉	실패 (5.07ms, 80.7MB)
// 테스트 12 〉	통과 (6.34ms, 73.8MB)
// 테스트 13 〉	실패 (11.87ms, 84.4MB)
// 테스트 14 〉	실패 (9.22ms, 92.5MB)
// 테스트 15 〉	실패 (13.00ms, 80.6MB)
// 테스트 16 〉	실패 (7.96ms, 79.7MB)
// 테스트 17 〉	통과 (20.49ms, 86.2MB)
// 테스트 18 〉	통과 (21.05ms, 94.1MB)
// 테스트 19 〉	통과 (19.89ms, 69.6MB)
// 테스트 20 〉	통과 (4.47ms, 77.4MB)
// 테스트 21 〉	통과 (4.20ms, 80.1MB)
// 테스트 22 〉	통과 (19.52ms, 85.1MB)

채점 결과
정확성: 72.7
합계: 72.7 / 100.0
