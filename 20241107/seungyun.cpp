#include <iostream>
#include <vector>
#include <queue>

#define endl "\n"
#define MAX 1010
#define INF 987654321
using namespace std;

int N, M, Start, End;
int dist[MAX];
int route[MAX];

vector<pair<int, int>> V[MAX];
vector<int> Route_V;

void Input() {
	cin >> N >> M;
	// 거리값 초기화
	for (int i = 1; i <= N; i++) {
		dist[i] = INF;
	}
	for (int i = 0; i < M; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		V[a].push_back(make_pair(b, c));
	}
	cin >> Start >> End;
}

void Solution() {
	priority_queue<pair<int, int>> pq;
	pq.push(make_pair(0, Start));
	dist[Start] = 0;

	while (pq.empty() == 0) {
		int cost = -pq.top().first;
		int cur = pq.top().second;
		pq.pop();

		for (int i = 0; i < V[cur].size(); i++) {
			int next = V[cur][i].first;
			int nCost = V[cur][i].second;

			if (dist[next] > cost + nCost) {
				route[next] = cur;
				dist[next] = cost + nCost;
				pq.push(make_pair(-dist[next], next));
			}
		}
	}

	cout << dist[End] << endl;
	int tmp = End;
	while (tmp) {
		Route_V.push_back(tmp);
		tmp = route[tmp];
	}
	cout << Route_V.size() << endl;
	for (int i = Route_V.size() - 1; i >= 0; i--) {
		cout << Route_V[i] << " ";
	}
	cout << endl;
}
void Solve() {
	Input();
	Solution();
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	Solve();

	return 0;
}
