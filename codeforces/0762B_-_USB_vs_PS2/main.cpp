#include <bits/stdc++.h>

using namespace std;

#define ll long long

ll ps2[1100001];
ll usb[1100001];
int p, q;
int a, b, c, m;
char s[10];

int main() {
  scanf("%d %d %d", &a, &b, &c);
  scanf("%d", &m);
  for (int i = 0; i < m; i++) {
    ll x = 0LL;
    scanf("%lld %s", &x, s);
    if (s[0] == 'U')
      usb[p++] = x;
    else
      ps2[q++] = x;
  }
  sort(usb, usb + p);
  sort(ps2, ps2 + q);

  ll cost = 0LL;
  int pp, uu;
  for (uu = 0; uu < min(a, p);) {
    cost += usb[uu++];
  }

  for (pp = 0; pp < min(b, q);) {
    cost += ps2[pp++];
  }

  while (c > 0 && pp < q && uu < p) {
    if (ps2[pp] < usb[uu]) {
      cost += ps2[pp++];
    } else {
      cost += usb[uu++];
    }
    c--;
  }

  while (c > 0 && pp < q) {
    cost += ps2[pp++];
    c--;
  }

  while (c > 0 && uu < p) {
    cost += usb[uu++];
    c--;
  }

  printf("%d %lld\n", uu + pp, cost);
  return 0;
}
