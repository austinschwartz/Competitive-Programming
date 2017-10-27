#include <bits/stdc++.h>

using namespace std;

#define ll long long

vector<int> adj[101];
int color[101] = {0};
int ans[101] = {0};
int n, m, mi;

void dfs(int i, int wc) {
  if (i > n) {
    if (wc < mi) {
      mi = wc;
      for (int i = 0; i < 101; i++) {
        ans[i] = color[i];
      }
    }
  } else {
    bool black = true;
    for (int j : adj[i])
      black = black && color[j] != 2;
    if (black) {
      color[i] = 2;
      dfs(i + 1, wc);
      color[i] = 0;
    }
    color[i] = 1;
    dfs(i + 1, wc + 1);
    color[i] = 0;
  }
}


int main() {
  ios_base::sync_with_stdio(0);
  int T;
  scanf("%d", &T);
  for (int t = 1; t <= T; t++) {
    scanf("%d %d", &n, &m);
    memset(ans, 0, sizeof(ans));
    memset(color, 0, sizeof(color));
    memset(adj, 0, sizeof(adj));
    for (int i = 0; i < m; i++) {
      int u, v;
      scanf("%d %d", &u, &v);
      adj[u].push_back(v);
      adj[v].push_back(u);
    }
    mi = n;
    dfs(1, 0);
    vector<int> anss;
    for (int i = 0; i < 101; i++)
      if (ans[i] == 2)
        anss.push_back(i);
    printf("%d\n", anss.size());
    for (int i = 0; i < anss.size(); i++) {
      if (i != 0)
        printf(" ");
      printf("%d", anss[i]);
    }
    printf("\n");
  }
  return 0;
}
