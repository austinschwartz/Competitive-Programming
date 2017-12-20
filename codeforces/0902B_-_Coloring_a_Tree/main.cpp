#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAXN = 1e5 + 7;

vector<int> adj[MAXN];
int c[MAXN];

int dfs(int i, int par) {
  int ret = 0;
  if (par == -1 or c[i - 1] != c[par - 1])
    ret += 1;
  for (int j : adj[i]) {
    if (j != par) {
      ret += dfs(j, i);
    }
  }
  return ret;
}

int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n - 1; i++) {
    int p;
    scanf("%d", &p);
    adj[p].push_back(i + 2);
    adj[i + 2].push_back(p);
  }
  for (int i = 0; i < n; i++) {
    scanf("%d", &c[i]);
  }

  printf("%d\n", dfs(1, -1));
  return 0;
}
