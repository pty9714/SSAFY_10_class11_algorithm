#include <vector>
#include <map>
#include <algorithm>

using namespace std;

vector<int> coun(100002, 0);
map<int,int> m;

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    int cnt = 1;
    for(auto t : tangerine){
        if(m[t] == 0){
            m[t] = cnt;
            coun[cnt++]++;
        }
        else{
            coun[m[t]]++;
        }
    }
    sort(coun.rbegin(), coun.rend());
    for(auto a : coun){
        k -= a;
        answer++;
        if(k <= 0) break;
    }
    return answer;
}
