#include <iostream>
#include <vector>
#include <queue>

using namespace std;

#define INF 999999

vector<vector<pair<int, int>>> graph;
vector<int> dist;
bool visited[20001] = { false };

struct cmp {
	bool operator()(pair<int, int> a, pair<int, int> b) {
		return a.first > b.first;
	}
};

void dijkstra(int start) {
	priority_queue<pair<int, int>, vector<pair<int, int>>, cmp> pq;
	pq.push(make_pair(0, start));
	dist[start] = 0;
	int curr;
	while (!pq.empty()) {
		curr = pq.top().second;
		pq.pop();
		if (visited[curr]) continue;
		visited[start] = true;
		for (pair<int, int> p : graph[curr]) {
			int f = p.first;
			int s = p.second;
			if (dist[f] > dist[curr] + s) {
				dist[f] = dist[curr] + s;
				pq.push(make_pair(dist[f], f));
			}
		}
	}
}

int main() {
	int v, e, start;
	cin >> v >> e;
	cin >> start;

	graph.assign(v+1, vector<pair<int, int>>());
	dist.assign(v+1, INF);

	for (int i = 0; i < e; i++) {
		int u, v, w;
		cin >> u >> v >> w;
		graph[u].push_back(make_pair(v, w));
	}

	dijkstra(start);

	for (int i = 1; i <= v; i++) {
		int d = dist[i];
		if (d != INF) cout << d << '\n';
		else cout << "INF" << '\n';
	}

	return 0;
}
