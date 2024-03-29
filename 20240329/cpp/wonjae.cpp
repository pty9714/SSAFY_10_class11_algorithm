#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

typedef pair<int, int> pii;

int main() {
	int n;
	cin >> n;

	int dp[101] = { 1, };
	vector<pii> v;

	for (int i = 0; i < n;i++) {
		int a, b;
		cin >> a >> b;
		v.emplace_back(a, b);
	}

	sort(v.begin(), v.end());
	int result = 0;

	for (int i = 1; i < n; i++) {
		dp[i] = 1;
		for (int j = 0; j < i; j++) {
			if (v[i].second > v[j].second && dp[i] <= dp[j]) dp[i] = dp[j] + 1;
			result = max(result, dp[i]);
		}
	}
	cout << n - result;
}
