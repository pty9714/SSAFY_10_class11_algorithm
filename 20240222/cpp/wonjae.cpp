#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int dp[1002][3];
int rgb[1002][3];

int main() {
	int n;
	int answer = 99999999;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> rgb[i][0] >> rgb[i][1] >> rgb[i][2];
	}

	dp[0][0] = rgb[0][0];
	dp[0][1] = dp[0][2] = 9999999;
	for (int i = 1; i < n; i++) {
		dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
		dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
		dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
	}
	answer = min(answer, min(dp[n - 1][1], dp[n - 1][2]));

	memset(dp, 0, sizeof(dp));

	dp[0][1] = rgb[0][1];
	dp[0][0] = dp[0][2] = 9999999;
	for (int i = 1; i < n; i++) {
		dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
		dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
		dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
	}
	answer = min(answer, min(dp[n - 1][0], dp[n - 1][2]));

	memset(dp, 0, sizeof(dp));

	dp[0][2] = rgb[0][2];
	dp[0][0] = dp[0][1] = 9999999;
	for (int i = 1; i < n; i++) {
		dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
		dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
		dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
	}
	answer = min(answer, min(dp[n - 1][0], dp[n - 1][1]));

	cout << answer;

}
