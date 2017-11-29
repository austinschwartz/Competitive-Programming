#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

#define MAXN 200001

bool cmp(pair<int, int> a, pair<int, int> b) {
  return a.second < b.second;
}

int main() {
  int n;
  cin >> n;
  pair<int, int> v[MAXN];
  for (int i = 0; i < n; i++) {
    int x, w;
    cin >> x >> w;
    v[i] = make_pair(x - w, x + w);
  }
  sort(v, v + n, cmp);
  int ans = 0;
  int last = -1e9;
  for (int i = 0; i < n; i++) {
    if (v[i].first >= last) {
      ans += 1;
      last = v[i].second;
    }
  }
  cout << ans << "\n";
  return 0;
}
