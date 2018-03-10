#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAXK = 1e9 + 7;
const int MAXN = 1e5 + 7;

int a[MAXN], b[MAXN];
int n, k;

bool f(int x) {
  ll used = 0;
  for (int i = 0; i < n; i++) {
    if ((ll)a[i] * x > (ll)b[i]) {
      used += (x * (ll)a[i] - (ll)b[i]);
      if (used > (ll)MAXK)
        return 0;
    }
  }
  return used <= k;
}

int main() {
  cin >> n >> k;
  for (int i = 0; i < n; i++)
    cin >> a[i];
  for (int i = 0; i < n; i++)
    cin >> b[i];

  int l = 0, h = 2 * MAXK;
  while (l < h) {
    int mid = l + (h - l) / 2;
    if (l == mid) break;
    bool x = f(mid);
    if (!x) {
      h = mid;
    } else {
      if (!f(mid + 1)) {
        cout << mid << endl;
        return 0;
      }
      l = mid;
    }
  }
  cout << l << endl;
  return 0;
}
