#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

ll f(ll l, ll r) {
  if (r == l)
    return l;

  ll b = 0;
  for (int i = 0; i < 256; i++) {
    if ((1LL << i) > r) {
      break;
    } else {
      b = i;
    }
  }

  if ((1LL << b) <= l) {
    return f(l - (1LL << b), r - (1LL << b)) + (1LL << b);
  } else if ((1LL << (b + 1LL)) - 1LL <= r) {
    return (1LL << (b + 1LL)) - 1LL;
  } else {
    return (1LL << b) - 1LL;
  }

  return 0;
}

int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    ll r, l;
    scanf("%lld %lld", &l, &r);
    printf("%lld\n", f(l, r));
  }
  return 0;
}
