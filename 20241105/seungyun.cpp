#include <iostream>
#include <queue>
#define MAX 51

using namespace std;
int map[MAX][MAX];
int N, L, R;
int dx[] = {-1,1,0,0,}; // 상하좌우
int dy[] = {0,0,-1,1};

bool visited[MAX][MAX];
queue<pair<int, int>> q;
vector<pair<int, int>> v;

bool flag = true; // 연합인지
int sum = 0;


void bfs(pair<int, int> start) {
	q.push(start);
	visited[start.first][start.second] = true;

	while (!q.empty()) {
		pair<int, int> tmp = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = tmp.first + dx[i];
			int ny = tmp.second + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
				if (abs(map[nx][ny] - map[tmp.first][tmp.second]) >= L
					&& abs(map[nx][ny] - map[tmp.first][tmp.second]) <= R) {
					q.push({ nx, ny });
					visited[nx][ny] = true;
					v.push_back({ nx, ny });
					sum += map[nx][ny];
				}
			}
		}
	}
}

// 방문 초기화
void vClear() {
	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			visited[i][j] = false;
}

int main() {
	int day = 0;
	cin >> N >> L >> R;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
		}
	}
	
	while (flag) {
		flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					v.clear();
					v.push_back({ i,j });
					sum = map[i][j];
					bfs({ i, j });
				}

				if (v.size() >= 2) {
					flag = true;
					for (int i = 0; i < v.size(); i++) {
						map[v[i].first][v[i].second] = sum / v.size();
					}
				}
			}
		}
		if (flag) day++;
		vClear();
	}

	cout << day;
	}
