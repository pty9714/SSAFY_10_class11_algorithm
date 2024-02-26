#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, int s) {
    vector<int> answer;
    if(s/n < 1){
        answer.push_back(-1);
    }
    else{
        int div = s/n;
        int rest = s%n;
        
        for(int i = 0; i<n - rest; i++){
            answer.push_back(div);
        }
        for(int i = 0; i<rest;i++){
            answer.push_back(div+1);
        }
    }
    return answer;
}
