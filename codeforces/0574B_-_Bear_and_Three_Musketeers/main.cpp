#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

#define MAX 4001

int n, m;
set<int> adj[MAX];
int degree[MAX];

int main() {
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    adj[a - 1].insert(b - 1);
    adj[b - 1].insert(a - 1);
    degree[a - 1]++;
    degree[b - 1]++;
  }

  int ans = (int)2e9;
  for (int i = 0; i < n; i++) {
    for (int j : adj[i]) {
      if (i == j) continue;
      set<int> common;
      set_intersection(adj[i].begin(), adj[i].end(), 
                       adj[j].begin(), adj[j].end(), 
                       inserter(common, common.begin()));
      for (auto k : common) {
        if (i == k or j == k) continue;
        int r = degree[i] - 2 + degree[j] - 2 + degree[k] - 2;
        ans = min(r, ans);
      }
    }
  }

  if (ans == (int)2e9)
    ans = -1;
  cout<< ans << "\n";
  return 0;
}
