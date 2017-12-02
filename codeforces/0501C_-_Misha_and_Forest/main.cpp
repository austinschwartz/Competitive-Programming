#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAXN = 1 << 16 + 1;

int main() {
  int n;
  scanf("%d", &n);
  int d[MAXN];
  int s[MAXN];
  queue<int> q;
  for (int i = 0; i < n; i++) {
    int a, b;
    scanf("%d %d", &a, &b);
    d[i] = a;
    s[i] = b;
    if (d[i] == 1) {
      q.push(i);
    }
  }
  vector<pair<int, int>> ans;
  while (q.size() != 0) {
    int u = q.front();
    q.pop();
    if (d[u] == 0)
      continue;
    int v = s[u];
    ans.push_back(make_pair(u, v));
    d[u] -= 1;
    s[v] ^= u;
    d[v] -= 1;
    if (d[v] == 1)
      q.push(v);
  }
  printf("%d\n", ans.size());
  for (pair<int, int> pair : ans) {
    printf("%d %d\n", pair.first, pair.second);
  }
  return 0;
}
