#include <iostream>
#include <algorithm>

using namespace std;
int max_arr[3] = { 0, };
int min_arr[3] = { 0, };

int main() {
	int n;
	cin >> n;
	int a, b, c;
	int mx[3];
	int mn[3];
	for (int i = 0; i < n; i++) {
		cin >> a >> b >> c;
		mx[0] = max(max_arr[0], max_arr[1]) + a;
		mn[0] = min(min_arr[0], min_arr[1]) + a;
		mx[1] = max(max_arr[0], max(max_arr[1], max_arr[2])) + b;
		mn[1]= min(min_arr[0], min(min_arr[1], min_arr[2])) + b;
		mx[2] = max(max_arr[1], max_arr[2]) + c;
		mn[2] = min(min_arr[1], min_arr[2]) + c;
		for (int j = 0; j < 3; j++) {
			max_arr[j] = mx[j];
			min_arr[j] = mn[j];
		}
	}
	cout << max(max_arr[0], max(max_arr[1], max_arr[2])) << ' ' << min(min_arr[0], min(min_arr[1], min_arr[2]));

	return 0;
}
