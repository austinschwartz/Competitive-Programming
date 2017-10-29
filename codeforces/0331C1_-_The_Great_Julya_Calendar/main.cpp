#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

unordered_map<ll, ll> ma;
bool dig[10];

int f(ll n) {
  if (ma[n])
    return ma[n];
  if (n == 0)
    return ma[n] = 0;
  if (n < 0) 
    return (int)1e9;
  if (n < 10 && n > 0)
    return ma[n] = 1;

  memset(dig, false, sizeof(dig));
  ll m = n;
  while (m > 0) {
    dig[m % 10] = 1;
    m /= 10;
  }

  int mi = (int)1e9;
  for (int i = 9; i > 0; i--) {
    if (dig[i]) {
      mi = 1 + f(n - i);
      break;
    }
  }
  return ma[n] = mi;
}

int main() {
  ll n;
  cin >> n;
  cout << f(n) << "\n";
  return 0;
}
