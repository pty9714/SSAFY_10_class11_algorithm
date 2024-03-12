#include <iostream>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(NULL);
	cin.tie(NULL);

	int n;
	cin >> n;
	vector<int> num;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		num.push_back(a);
	}

	vector<vector<bool>> table(n, vector<bool>(n, true));

	for (int i = 1; i < n; i++) {
		for (int j = 0; j < i; j++) {
			if (num[i] != num[j] || !table[i - 1][j + 1]) table[i][j] = false;
		}
	}

	int m, s, e;
	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> s >> e;
		if (table[e - 1][s - 1]) cout << 1 << "\n";
		else cout << 0 << "\n";
	}

	return 0;
}
