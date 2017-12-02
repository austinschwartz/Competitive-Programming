#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAX = 1e5 + 7;

int main() {
  int n, k;
  cin >> n;
  ll a[MAX];
  memset(a, -1, sizeof(a));
  for (k = 0; k < MAX; k++) {
    a[k] = k * (k + 1) / 2;
    if (a[k] > n)
      break;
  }
  set<int> s;
  for (int i = 0; i <= k; i++) {
    if (n - a[i] < 1 || a[i] < 1)
      continue;
    s.insert(n - a[i]);
    if (s.find(a[i]) != s.end()) {
      cout << "YES\n";
      return 0;
    }
  }
  cout << "NO\n";
  return 0;
}
