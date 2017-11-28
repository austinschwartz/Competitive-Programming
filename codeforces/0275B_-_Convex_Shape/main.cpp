#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAX = 51;

bool grid[MAX][MAX];
int n, m;
set<pair<int, int>> blacks;

const int cards[4][2] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

bool dfs(int i, int j, int ii, int jj) {
  bool a = true;
  bool b = true;
  for (int x = min(i, ii); x <= max(i, ii); x++) {
    a &= (grid[x][j] == false);
    b &= (grid[x][jj] == false);
  }
  for (int y = min(j, jj); y <= max(j, jj); y++) {
    a &= (grid[ii][y] == false);
    b &= (grid[i][y] == false);
  }
  return a || b;
}

bool ans() {
  for (pair<int, int> a : blacks) {
    int i = a.first;
    int j = a.second;
    for (pair<int, int> b : blacks) {
      int ii = b.first;
      int jj = b.second;
      if (i == ii && j == jj)
        continue;
      if (!dfs(i, j, ii, jj)) {
        return false;
      }
    }
  }
  return true;
}

int main() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    for (int j = 0; j < m; j++) {
      if (s[j] == 'W') {
        grid[i][j] = true;
      } else {
        grid[i][j] = false;
        blacks.insert(make_pair(i, j));
      }
    }
  }

  cout << (ans() ? "YES" : "NO") << "\n";
  return 0;
}
