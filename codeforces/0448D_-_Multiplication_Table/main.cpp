#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int n, m;
ll k;

ll f(ll x) {
  ll count = 0;
  for (int i = 1; i <= m; i++) {
    count += min((ll)n, (x - 1) / i);
  }
  return count;
}

int main() {
  cin >> n >> m;
  cin >> k;

  ll low = 1LL;
  ll high = 1LL * n * m + 1;
  while (low < high) {
    ll mid = low + (high - low) / 2;
    if (f(mid) < k)
      low = mid + 1;
    else
      high = mid;
  }

  cout << low - 1 << "\n";
  
  return 0;
}
