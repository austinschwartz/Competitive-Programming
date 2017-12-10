#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAXN = 1e5 + 7;

int n;
vector<int> adj[MAXN];
vector<int> l;
vector<int> r;

void dfs(int u, int par, bool a) {
  if (u == par)
    return;
  if (a)
    l.push_back(u);
  else
    r.push_back(u);
  for (int v : adj[u]) {
    if (v == par)
      continue;
    dfs(v, u, a ^ 1);
  }
}

int main() {
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    int a = 0, b = 0;
    cin >> a >> b;
    a -= 1;
    b -= 1;
    adj[a].push_back(b);
    adj[b].push_back(a);
  }
  dfs(0, -1, true);
  cout << (l.size() * r.size() - n + 1) << "\n";
  return 0;
}
