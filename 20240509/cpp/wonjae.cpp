#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

vector<vector<pair<int, int>>> tree;

int dist[100001];
bool visited[100001] = { false };

int far = 0;
int far_node = 0;

int bfs(int index) {
	memset(dist, 0, sizeof(dist));
	memset(visited, false, sizeof(visited));
	far = far_node = 0;
	queue<int> q;
	visited[index] = true;
	dist[index] = 0;
	q.push(index);
	int cur;
	while (!q.empty()) {
		cur = q.front();
		q.pop();
		for (pair<int, int> p : tree[cur]) {
			if (visited[p.first]) continue;
			visited[p.first] = true;
			dist[p.first] = dist[cur] + p.second;
			if (dist[p.first] > far) { 
				far = dist[p.first]; far_node = p.first; 
			}
			q.push(p.first);
		}
	}
	return far_node;
}

int main() {
	int v;
	cin >> v;
	tree.assign(v+1, vector<pair<int, int>>());

	for (int i = 0; i < v; i++) {
		int index;
		cin >> index;
		while (true) {
			int p, d;
			cin >> p;
			if (p == -1) break;
			cin >> d;
			
			tree[index].push_back(make_pair(p, d));
		}
	}

	int far_point = bfs(1);
	cout << dist[bfs(far_point)];

	return 0;
}
