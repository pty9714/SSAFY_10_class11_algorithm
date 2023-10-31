import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int temp = 1;
        HashSet<String> hs = new HashSet<>(Arrays.asList(gems));
        
      
        ArrayList<String> al = new ArrayList<>();
        HashSet<String> cs = new HashSet<>();
        
        
        int count = 0;
        int totalCount = hs.size();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < gems.length; i++){
            if(!al.isEmpty() && al.get(0).equals(gems[i])){ //같다면 뺀다.
                temp++;
                al.remove(0);
                while(al.size() >= 2 && al.get(0).equals(al.get(1))){
                    if(al.get(0).equals(al.get(1))){
                        temp++;
                        al.remove(0);
                    }else{
                        if(!cs.contains(gems[i])){ //cs에 없다면
                            cs.add(gems[i]); //add
                        }
            
                        if(cs.size() == totalCount){ //같다면 전체 보석을 샀다는 뜻
                            if(min > al.size()){
                                min = al.size() + 1;
                                temp++;
                                answer[0] = temp;
                                answer[1] = i+1;
                            }
                        }
                        break;
                    }
                }
            }
            if(al.size() >= 2 && al.get(0).equals(al.get(al.size()-1))){
                al.remove(0);
                temp++;
            }
            
            al.add(gems[i]);
            if(!cs.contains(gems[i])){ //cs에 없다면
                cs.add(gems[i]); //add
            }
            
             if(cs.size() == totalCount){ //같다면 전체 보석을 샀다는 뜻
                if(min > al.size()){
                    min = al.size();
                    answer[0] = temp;
                    answer[1] = i+1;
                 }
               }
        }
        
        
        return answer;
    }
}
