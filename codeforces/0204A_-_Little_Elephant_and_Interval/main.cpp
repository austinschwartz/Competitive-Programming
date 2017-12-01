#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int firstDigit(ll x) {
  if (x < 10)
    return x;
  return firstDigit(x / 10);
}

ll f(ll x) {
  if (x < 10)
    return x;
  return 9 + (x / 10 - 1) + 
    (firstDigit(x) <= (x % 10) ? 1 : 0);
}

int main() {
  ll l, r;
  cin >> l >> r;
  cout << f(r) - f(l - 1) << "\n";
  return 0;
}
