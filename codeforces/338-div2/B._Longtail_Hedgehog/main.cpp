#include <iostream>
#include <vector>

using namespace std;
typedef long long ll;

const int maxN = 1 << 17;
vector<int> adj[maxN];
int dp [maxN];

int main() {
  int n, m;
  cin >> n >> m;
  while (m--) {
    int u, v;
    cin >> u >> v;
    adj[v].push_back(u);
    adj[u].push_back(v);
  }
  ll ans = -1ll;
  for (int v = 1; v <= n; v++) {
    dp[v] = 1;
    for (auto u : adj[v]) {
      if (u < v) {
        dp[v] = max(dp[v], dp[u] + 1);
      }
    }
    ans = max(ans, dp[v] * (ll)adj[v].size());
  }
  cout << ans << endl;
  return 0;
}
