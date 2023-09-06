import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            
            System.out.println(Arrays.toString(com));
            
             for(int p =0; p< 5; p++){
                for(int j = 0; j < 5; j++){
                    System.out.print(arr[p][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            for(int t = 0; t < 5; t++){
                for(int j = 0; j < 5; j++){
                    System.out.print(p[t][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        
        

        
        for(int i =0; i< 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
        

        return answer;
    }
    
    
    
}
