#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAXN = 1e5 + 7;

int dist[MAXN];
int vis[MAXN];
set<int> adj[MAXN];
vector<int> affected;
set<int> affected_set;


void dfs(int i, int par) {
  if (par != 0)
    dist[i] = dist[par] + 1;
  for (int j : adj[i]) {
    if (j != par) {
      dfs(j, i);
    }
  }
}

void dfs2(int i, int par, int d) {
  if (d < 0)
    return;
  vis[i] += 1;
  for (int j : adj[i]) {
    if (j != par) {
      dfs2(j, i, d - 1);
    }
  }
}

int main() {
  int n, m, d;
  scanf("%d %d %d", &n, &m, &d);
  for (int i = 0; i < m; i++) {
    int x;
    scanf("%d", &x);
    affected.push_back(x);
    affected_set.insert(x);
  }

  for (int i = 0; i < n; i++) {
    int a, b;
    scanf("%d %d", &a, &b);
    adj[a].insert(b);
    adj[b].insert(a);
  }
  
  // find diameter of tree d(a, b) where a and b are affected
  memset(dist, 0, sizeof(dist));
  dfs(affected[0], 0);
  int b = -1;

  for (int i : affected) {
    if (i == affected[0]) continue;
    if (b == -1 || dist[i] > dist[b]) {
      b = i;
    }
  }

  if (b == -1)
    b = affected[0];
  else {
    memset(dist, 0, sizeof(dist));
    dfs(b, 0);
    int a = -1;

    for (int i : affected) {
      if (i == b) continue;
      if (a == -1 || dist[i] > dist[a]) {
        a = i;
      }
    }
    dfs2(a, a, d);
  }

  dfs2(b, b, d);

  int count = 0;
  for (int i = 1; i <= n; i++) {
    if ((m > 1 && vis[i] == 2) || (m == 1 && vis[i] == 1)) {
      count += 1;
    }
  }

  printf("%d\n", count);

  return 0;
}
