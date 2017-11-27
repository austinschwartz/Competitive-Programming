#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAX = 1e5 + 7;

vector<int> adj[MAX];
ll V[MAX];
bool vis[MAX];
pair<ll, ll> s[MAX];

void dfs(int u) {
  vis[u] = true;
  ll incr = 0, decr = 0;
  for (int v : adj[u]) {
    if (!vis[v]) {
      dfs(v);
      incr = max(incr, s[v].first);
      decr = max(decr, s[v].second);
    }
  }
  V[u] += (incr - decr);
  if (V[u] >= 0)
    decr += V[u];
  else
    incr -= V[u];
  s[u] = make_pair(incr, decr);
}

int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    int a, b;
    cin >> a >> b;
    adj[a - 1].push_back(b - 1);
    adj[b - 1].push_back(a - 1);
  }

  for (int i = 0; i < n; i++) {
    cin >> V[i];
    vis[i] = false;
    s[i] = make_pair(0, 0);
  }

  dfs(0);
  cout << s[0].first + s[0].second << "\n";

  return 0;
}
