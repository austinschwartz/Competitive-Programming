#include <algorithm>
#include <cstdio>
#include <vector>

using namespace std;

vector<int> adj[100001];
double ans[100001];

int n;

double dfs(int par, int u) {
  if (ans[u] != -1.0)
    return ans[u];
  double ret = 0;
  int k = 0;
  for (int v : adj[u]) {
    if (v != par) {
      ret += dfs(u, v);
      k += 1;
    }
  }
  if (k == 0)
    return 0.0;
  return ans[u] = (1 + ret / k);
}

int main() {
  fill_n(ans, 100001, -1.0);
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    adj[u].push_back(v);
    adj[v].push_back(u);
  }
  printf("%0.15lf\n", dfs(0, 1));
}
