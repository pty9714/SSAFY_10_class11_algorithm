#include <iostream>
#include <cmath>

using namespace std;
pair<int,int> init[500];
long long mul[500][500];

long long min(int, int);

int main() {
	int n;
	cin >> n;
	int r, c;
	for (int i = 0; i < n; i++) {
		cin >> r >> c;
		init[i] = make_pair(r, c);
	}

	for (int i = 1; i < n; i++) {
		for (int j = 0; j < n - i; j++) {
			mul[i][j] = min(i, j);
		}
	}
	cout << mul[n - 1][0];
}

long long min(int a, int b) {
	long long m = pow(2, 32) - 1;
	long long t;
	for (int i = 0; i < a; i++) {
		t = mul[i][b] + mul[a - i - 1][b+i+1] + init[b].first * init[b + i].second * init[a+b].second;
		if (t < m) m = t;
	}
	return m;
}
