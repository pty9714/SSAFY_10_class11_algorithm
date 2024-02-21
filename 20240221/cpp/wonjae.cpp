#include <iostream>
#include <vector>
#include <set>
#include <queue>

using namespace std;

vector<int> fact;
vector<int> fact_list;
vector<vector<int>> party(51, vector<int>());
vector<set<int>> connect(51, set<int>());
bool visited[51] = { false };

void visit_check(int start) {
	queue<int> q;
	if (visited[start]) return;
	visited[start] = true;
	q.push(start);
	while (!q.empty()){
		int curr = q.front();
		q.pop();
		fact_list.push_back(curr);
		for (int i : connect[curr]) {
			if (!visited[i]) {
				visited[i] = true;
				q.push(i);
			}
		}
	}
	return;
}

int main() {
	int n, m;
	cin >> n >> m;
	int fact_num;
	cin >> fact_num;
	for (int i = 0; i < fact_num; i++) {
		int f;
		cin >> f;
		fact.push_back(f);
	}
	for (int i = 0; i < m; i++) {
		int member_num;
		cin >> member_num;
		for (int j = 0; j < member_num; j++) {
			int member;
			cin >> member;
			party[i].push_back(member);
		}
	}

	for (vector<int> v : party) {
		for (int i : v) {
			for (int j : v) {
				connect[i].insert(j);
			}
		}
	}

	for (int i : fact) {
		visit_check(i);
	}

	int cnt = 0;

	for (vector<int> v : party) {
		bool flag = false;
		for (int i : v) {
			for (int j : fact_list) {
				if (i == j) {
					flag = true;
					break;
				}
			}
			if (flag) break;
		}
		if (!flag && v.size()!=0) cnt++;
	}
	cout << cnt;

	return 0;
}
