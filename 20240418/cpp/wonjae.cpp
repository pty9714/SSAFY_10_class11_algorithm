#include <iostream>

#define INF 999999
using namespace std;


int n, s;
int arr[100001];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);
	cin >> n >> s;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	int l = 0, r = 0;
	int sum = arr[0];
	int min = INF;

	while (r <= n) {
		if (sum < s) {
			r++;
			sum += arr[r];
		}
		else if (sum >= s) {
			if ((r - l + 1) < min) min = (r - l + 1);
			sum -= arr[l];
			l++;
		}
	}
	if (min == INF) cout << 0;
	else cout << min;
}
