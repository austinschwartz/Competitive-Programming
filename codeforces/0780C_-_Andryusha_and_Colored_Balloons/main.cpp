#include <bits/stdc++.h>

using namespace std;

#define MAX 200005

typedef long long int ll;

vector<int> adj[MAX];

int n;
int maxcolor;
int color[MAX];

void dfs(int u, int prev) {
  int i = 1;
  for (int v : adj[u]) {
    if (v != prev) {
      while (i == color[u] || i == color[prev])
        i += 1;
      color[v] = i++;
      maxcolor = max(maxcolor, color[v]);
    }
  }
  for (int v : adj[u]) {
    if (v != prev) {
      dfs(v, u);
    }
  }
}

int main() {
  scanf("%d", &n);
  int root = -1;
  for (int i = 1; i <= n - 1; i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    adj[u].push_back(v);
    adj[v].push_back(u);
    if (root == -1)
      root = u;
  }
  color[root] = 1;
  dfs(root, -1);
  printf("%d\n", maxcolor);
  for (int i = 1; i <= n; i++) {
    if (i != 1)
      printf(" ");
    printf("%d", color[i]);
  }

  return 0;
}
