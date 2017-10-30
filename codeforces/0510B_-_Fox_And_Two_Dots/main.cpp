#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int coord[4][2] = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
char g[51][51];
int n, m;
unordered_set<int> vis;

int s(int u, int v) {
  return (u * 0x1f1f1f1f) ^ v;
}

int dfs(int i, int j, int pi, int pj) {
  int ss = s(i, j);
  if (vis.find(ss) != vis.end()) {
    return 1;
  }
  vis.insert(ss);

  for (int x = 0; x < 4; x++) {
    int ni = i + coord[x][0];
    int nj = j + coord[x][1];
    if (ni < 0 || nj < 0 || ni >= n || nj >= m || (ni == pi && nj == pj)) {
      continue;
    }

    if (g[ni][nj] != g[i][j]) {
      continue;
    }

    if (dfs(ni, nj, i, j) != 0) {
      return 1;
    }
  }

  return 0;
}

int main() {
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; i++) {
    char line[51];
    scanf("%s", &line);
    for (int j = 0; j < m; j++) {
      g[i][j] = line[j];
    }
  }

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      vis.clear();
      if (dfs(i, j, -1, -1)) {
        printf("Yes\n");
        return 0;
      }
    }
  }
  printf("No\n");
  return 0;
}
