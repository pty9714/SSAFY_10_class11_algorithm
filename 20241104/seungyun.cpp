#include <iostream>
#include <cmath>
using namespace std;
int road1[101][101];
int road2[101][101];
int n, l;
int result = 0;
void PassCnt(int road[][101]) {
    for (int i = 0; i < n; i++) {
        bool slope[101] = { 0 }; // 경사로 여부
        bool possible = true; // 가능한 길인지 확인
        for (int h = 0; h < n - 1; h++) {
            if (abs(road[i][h] - road[i][h + 1]) > 1) {
                possible = false;
                break;
            }

            if (road[i][h] == road[i][h + 1] + 1) {
                int cur_hight = road[i][h + 1];
                for (int k = h + 2; k < h + 1 + l; k++) {
                    if (k >= n || road[i][k] != cur_hight) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    slope[h + l] = true;
                }
                else {
                    break;
                }
            }

            if (road[i][h] == road[i][h + 1] - 1) {
                int cur_hight = road[i][h];
                for (int k = h; k > h - l; k--) {
                    if (k < 0 || road[i][k] != cur_hight || slope[k]) {
                        possible = false;
                        break;
                    }
                }
                if (!possible) {
                    break;
                }
            }
        }
        if (possible) {
            result++;
        }
    }
}

int main() {
    cin >> n >> l; // 입력
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> road1[i][j]; 
            road2[j][i] = road1[i][j]; 
        }
    }
    PassCnt(road1); 
    PassCnt(road2);
    cout << result << endl;

    return 0;
}
