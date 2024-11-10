#include <iostream>
#include <vector>
using namespace std;
#define MAX 101

int N;
int x, y, d, g, cnt;
int map[MAX][MAX];
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, -1, 0, 1 };
vector<int> dir;

void Curve()
{
    int size = dir.size();
    for (int i = size - 1; i >= 0; i--)
    {
        int temp = (dir.at(i) + 1) % 4;
        x += dx[temp];
        y += dy[temp];
        map[x][y] = 1;
        dir.push_back(temp);
    }
}

void Count()
{
    for (int i = 0; i < MAX; i++)
    {
        for (int j = 0; j < MAX; j++)
        {
            if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] && map[i + 1][j] == 1)
                cnt++;
        }
    }
}

void Solution()
{
    cin >> N;

    while (N--)
    {
        dir.clear();
        cin >> x >> y >> d >> g;

        map[x][y] = 1;

        x += dx[d];
        y += dy[d];
        map[x][y] = 1;
        dir.push_back(d);

        while (g--)
        {
            Curve();
        }
    }

    Count();
    cout << cnt << endl;
}

int main()
{
    Solution();
}
