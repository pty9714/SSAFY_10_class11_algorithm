import java.util.*;
class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        ArrayList<String> al = new ArrayList<>();

        for(int i =0 ; i < info.length; i++){
            al.add(info[i]);
        }

        for(int i = 0; i< query.length; i++){
            ArrayList<String> al_temp = new ArrayList<>(al);
            String[] string = query[i].split(" ");
            if(!string[0].equals("-")){
                for(int j = 0; j < al_temp.size(); j++){ //첫번째 제거
                    if(!al_temp.get(j).contains(string[0])){
                        al_temp.remove(j);
                        j--;
                    }
                }
            }

            if(!string[2].equals("-")){
                 for(int j = 0; j < al_temp.size(); j++){ //두번째 제거
                     if(!al_temp.get(j).contains(string[2])){
                         al_temp.remove(j);
                         j--;
                        }
                    }
                }
                    if(!string[4].equals("-")){
                        for(int j = 0; j < al_temp.size(); j++){ //세번째 제거
                            if(!al_temp.get(j).contains(string[4])){
                                al_temp.remove(j);
                                j--;
                            }
                        }
                    }
                        if(!string[6].equals("-")){
                        for(int j = 0; j < al_temp.size(); j++){ //네번째 제거
                            if(!al_temp.get(j).contains(string[6])){
                                al_temp.remove(j);
                                j--;
                            }
                        }
                    }
            
                    int[] scoreArr = new int[al_temp.size()];
                    for(int j =0 ; j < scoreArr.length; j++){
                        scoreArr[j] = Integer.parseInt(al_temp.get(j).split(" ")[4]);
                    }
            
                    Arrays.sort(scoreArr);
            
                    int target = Integer.parseInt(string[7]);
                    int s = 0;
                    int e = scoreArr.length;
                    int m = (s+e) /2;
                    while(s < e){
                        m = (s + e) /2;
                        if(scoreArr[m] >= target){
                            e = m;
                        }else {
                            s = m + 1;
                        }
                    }
                    // System.out.println(Arrays.toString(scoreArr));
                    // System.out.println(s + " " + m + " " + e + " " + target);
                    
                    answer[i] = al_temp.size() - s;
        }

        return answer;
    }
}


정확성  테스트
테스트 1 〉	통과 (1.08ms, 74.3MB)
테스트 2 〉	통과 (1.03ms, 76.1MB)
테스트 3 〉	통과 (5.69ms, 73.9MB)
테스트 4 〉	통과 (18.86ms, 89.2MB)
테스트 5 〉	통과 (43.28ms, 104MB)
테스트 6 〉	통과 (73.65ms, 105MB)
테스트 7 〉	통과 (29.11ms, 102MB)
테스트 8 〉	통과 (141.42ms, 126MB)
테스트 9 〉	통과 (227.94ms, 106MB)
테스트 10 〉	통과 (187.19ms, 123MB)
테스트 11 〉	통과 (48.87ms, 101MB)
테스트 12 〉	통과 (67.08ms, 117MB)
테스트 13 〉	통과 (58.77ms, 89MB)
테스트 14 〉	통과 (181.81ms, 114MB)
테스트 15 〉	통과 (214.51ms, 115MB)
테스트 16 〉	통과 (52.87ms, 84.3MB)
테스트 17 〉	통과 (98.29ms, 115MB)
테스트 18 〉	통과 (160.85ms, 120MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
채점 결과
정확성: 40.0
효율성: 0.0
합계: 40.0 / 100.0
