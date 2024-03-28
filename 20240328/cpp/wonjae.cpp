#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int n, m, k, maxprofit;
vector<int> candy;
vector<bool> visited;
vector<vector<int>> relations;
vector<pair<int, int>> group;
int dp[3001];


void connect_relations(int i) {
	queue<int> q;
	q.push(i);
	visited[i] = true;
	int curr;
	int cnt = 0;
	int sum = 0;
	while (!q.empty()) {
		curr = q.front();
		q.pop();
		sum += candy[curr];
		cnt++;
		for (auto conn : relations[curr]) {
			if (!visited[conn]) {
				visited[conn] = true;
				q.push(conn);
			}
		}
	}
	group.push_back(make_pair(cnt, sum));
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n >> m >> k;
	candy = vector<int>(n + 1, 0);
	visited = vector<bool>(n + 1, false);
	relations = vector<vector<int>>(n + 1, vector<int>());
	for (int i = 1; i <= n; i++) {
		cin >> candy[i];
	}

	int a, b;


	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		relations[a].push_back(b);
		relations[b].push_back(a);
	}

	for (int i = 1; i <= n; i++) {
		if (!visited[i]) connect_relations(i);
	}

	for (auto g : group) {
		for (int i = k; i >= g.first; i--) {
			if (dp[i] < dp[i - g.first] + g.second) dp[i] = dp[i - g.first] + g.second;
		}
	}

	cout << dp[k-1];
}
