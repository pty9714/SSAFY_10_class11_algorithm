class Solution {
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        int max = 0;
        int ap = 0;
        int ri = 0;
        for(int a = 0; a < n+1; a++){
            if(info[0] < a) ri += 10;
            else if(info[0] > 0) ap += 10;
            for(int b = 0; b < n+1 - a; b++){
                if(info[1] < b) ri += 9;
                else if(info[1] > 0) ap += 9;
                for(int c = 0; c < n+1 - a - b; c++){
                    if(info[2] < c) ri += 8;
                    else if(info[2] > 0) ap += 8;
                    for(int d = 0; d < n+1 - a - b - c; d++){
                        if(info[3] < d) ri += 7;
                        else if(info[3] > 0) ap += 7;
                        for(int e = 0; e < n+1 - a - b - c - d; e++){
                            if(info[4] < e) ri += 6;
                            else if(info[4] > 0) ap += 6;   
                            for(int f= 0; f < n+1 - a - b - c - d - e; f++){
                                if(info[5] < f) ri += 5;
                                else if(info[5] > 0) ap += 5;
                                for(int g = 0; g < n+1 - a - b - c - d - e-f; g++){
                                    if(info[6] < g) ri += 4;
                                    else if(info[6] > 0) ap += 4;
                                    for(int h = 0; h < n+1 - a - b - c - d - e-f - g; h++){
                                        if(info[7] < h) ri += 3;
                                        else if(info[7] > 0) ap += 3;
                                        for(int i = 0; i < n+1 - a - b - c - d - e-f - g- h; i++){
                                            if(info[8] < i) ri += 2;
                                            else if(info[8] > 0) ap += 2;
                                            for(int j = 0; j < n+1 - a - b - c - d - e-f - g- h - i; j++){
                                                if(info[9] < j) ri += 1;
                                                else if(info[9] > 0) ap += 1;
                                                    if(ri - ap == max){
                                                        if(answer[10] < n - a - b - c - d - e - f - g - h - i - j){
                                                            answer[0] = a;
                                                            answer[1] = b;
                                                            answer[2] = c;
                                                            answer[3] = d;
                                                            answer[4] = e;
                                                            answer[5] = f;
                                                            answer[6] = g;
                                                            answer[7] = h;
                                                            answer[8] = i;
                                                            answer[9] = j;
                                                            answer[10] = n - a - b - c - d - e - f - g - h - i - j;
                                                        }else if(answer[10] == n - a - b - c - d - e - f - g - h - i - j){
                                                            if(answer[9] < j){
                                                                answer[0] = a;
                                                                answer[1] = b;
                                                                answer[2] = c;
                                                                answer[3] = d;
                                                                answer[4] = e;
                                                                answer[5] = f;
                                                                answer[6] = g;
                                                                answer[7] = h;
                                                                answer[8] = i;
                                                                answer[9] = j;
                                                            }else if(answer[9] == j){
                                                                if(answer[8] < i){
                                                                    answer[0] = a;
                                                                    answer[1] = b;
                                                                    answer[2] = c;
                                                                    answer[3] = d;
                                                                    answer[4] = e;
                                                                    answer[5] = f;
                                                                    answer[6] = g;
                                                                    answer[7] = h;
                                                                    answer[8] = i;
                                                                }else if(answer[8] == i){
                                                                    if(answer[7] < h){
                                                                        answer[0] = a;
                                                                        answer[1] = b;
                                                                        answer[2] = c;
                                                                        answer[3] = d;
                                                                        answer[4] = e;
                                                                        answer[5] = f;
                                                                        answer[6] = g;
                                                                        answer[7] = h;
                                                                    }else if(answer[7] == h){
                                                                        if(answer[6] < g){
                                                                            answer[0] = a;
                                                                            answer[1] = b;
                                                                            answer[2] = c;
                                                                            answer[3] = d;
                                                                            answer[4] = e;
                                                                            answer[5] = f;
                                                                            answer[6] = g;
                                                                        }else if(answer[6] == g){
                                                                            if(answer[5] < f){
                                                                                answer[0] = a;
                                                                                answer[1] = b;
                                                                                answer[2] = c;
                                                                                answer[3] = d;
                                                                                answer[4] = e;
                                                                                answer[5] = f;
                                                                            }else if(answer[5]== f){
                                                                                if(answer[4] < e){
                                                                                    answer[0] = a;
                                                                                    answer[1] = b;
                                                                                    answer[2] = c;
                                                                                    answer[3] = d;
                                                                                    answer[4] = e;
                                                                                }else if(answer[4] == e){
                                                                                    if(answer[3] < d){
                                                                                        answer[0] = a;
                                                                                        answer[1] = b;
                                                                                        answer[2] = c;
                                                                                        answer[3] = d;
                                                                                    }else if(answer[3] == d){
                                                                                        if(answer[2] < c){
                                                                                            answer[0] = a;
                                                                                            answer[1] = b;
                                                                                            answer[2] = c;
                                                                                        }else if(answer[2] == c){
                                                                                            if(answer[1] < b){
                                                                                                answer[0] = a;
                                                                                                answer[1] = b;
                                                                                            }else if(answer[1] == b){
                                                                                                if(answer[0] < a){
                                                                                                    answer[0] = a;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
    
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                }else if(ri - ap > max){
                                                    max = ri - ap;
                                                    answer[0] = a;
                                                    answer[1] = b;
                                                    answer[2] = c;
                                                    answer[3] = d;
                                                    answer[4] = e;
                                                    answer[5] = f;
                                                    answer[6] = g;
                                                    answer[7] = h;
                                                    answer[8] = i;
                                                    answer[9] = j;
                                                    answer[10] = n - a - b - c - d - e - f - g - h - i - j;
                                                }
                                                if(info[9] < j) ri -= 1;
                                                else if(info[9] > 0) ap -= 1;
                                            }
                                            if(info[8] < i) ri -= 2;
                                            else if(info[8] > 0) ap -= 2;
                                        }
                                        if(info[7] < h) ri -= 3;
                                        else if(info[7] > 0) ap -= 3;
                                    }
                                    if(info[6] < g) ri -= 4;
                                    else if(info[6] > 0) ap -= 4;
                                }
                                if(info[5] < f) ri -= 5;
                                else if(info[5] > 0) ap -= 5;
                            }
                            if(info[4] < e) ri -= 6;
                            else if(info[4] > 0) ap -= 6;  
                        }
                        if(info[3] < d) ri -= 7;
                        else if(info[3] > 0) ap -= 7;
                    }
                    if(info[2] < c) ri -= 8;
                    else if(info[2] > 0) ap -= 8;
                }
                if(info[1] < b) ri -= 9;
                else if(info[1] > 0) ap -= 9;
            }
            if(info[0] < a) ri -= 10;
            else if(info[0] > 0) ap -= 10;
        }
        if(max == 0){
            int[] ans = {-1};
            return ans;
        }
        return answer;
    }
}


테스트 1 〉	통과 (0.05ms, 76.2MB)
테스트 2 〉	통과 (14.13ms, 79.8MB)
테스트 3 〉	통과 (9.61ms, 75MB)
테스트 4 〉	통과 (0.60ms, 75.7MB)
테스트 5 〉	통과 (11.79ms, 77.4MB)
테스트 6 〉	통과 (12.17ms, 78.4MB)
테스트 7 〉	통과 (0.69ms, 73.4MB)
테스트 8 〉	통과 (0.13ms, 76.8MB)
테스트 9 〉	통과 (0.93ms, 69.8MB)
테스트 10 〉	통과 (0.16ms, 78.3MB)
테스트 11 〉	통과 (0.42ms, 82.2MB)
테스트 12 〉	통과 (0.27ms, 82.1MB)
테스트 13 〉	통과 (3.99ms, 83.6MB)
테스트 14 〉	통과 (10.85ms, 83.1MB)
테스트 15 〉	통과 (8.28ms, 78MB)
테스트 16 〉	통과 (1.42ms, 83.5MB)
테스트 17 〉	통과 (0.63ms, 74.4MB)
테스트 18 〉	통과 (0.04ms, 66.4MB)
테스트 19 〉	통과 (0.04ms, 79.4MB)
테스트 20 〉	통과 (18.59ms, 84.7MB)
테스트 21 〉	통과 (9.60ms, 78.7MB)
테스트 22 〉	통과 (13.05ms, 77.4MB)
테스트 23 〉	통과 (0.10ms, 75.1MB)
테스트 24 〉	통과 (15.46ms, 76.1MB)
