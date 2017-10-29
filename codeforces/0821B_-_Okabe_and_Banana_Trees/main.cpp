#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

ll s(ll n) {
  return n * (n + 1) / 2;
}

int main() {
  int m, b;
  scanf("%d %d", &m, &b);
  ll ret = 0;
  for (int y = b; y >= 0; y--) {
    ll x = m * (b - y);
    ll t = (x + 1) * s(y) + (y + 1) * s(x);
    ret = max(ret, t);
  }
  printf("%lld\n", ret);
  return 0;
}
