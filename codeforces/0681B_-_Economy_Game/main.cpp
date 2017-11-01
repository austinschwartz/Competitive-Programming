#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int main() {
  ll n;
  cin >> n;
  for (ll a = 0; a < 811; a++) {
    for (ll b = 0; b < 8200; b++) {
      ll ret = (a * 1234567LL) + (b * 123456LL) - (ll)n;
      ll c = ret / -1234LL;
      if (c < 0)
        continue;
      if (a * 1234567LL + b * 123456LL + c * 1234LL == n) {
        printf("YES\n");
        return 0;
      }
    }
  }
  printf("NO\n");
  return 0;
}
