#include <bits/stdc++.h>

using namespace std;

#define max(a,b) ((a) > (b) ? (a) : (b))

typedef long long int ll;

string s;
ll nb, ns, nc;
ll pb, ps, pc;
ll r;
ll cb, cs, cc;

ll rubles(ll x) {
  return max(0, cb * x - nb) * pb +
         max(0, cs * x - ns) * ps + 
         max(0, cc * x - nc) * pc;
}

int main() {
  cin >> s;
  cin >> nb >> ns >> nc;
  cin >> pb >> ps >> pc;
  cin >> r;

  for (int i = 0; i < s.length(); i++) {
    if (s[i] == 'B') cb++;
    if (s[i] == 'S') cs++;
    if (s[i] == 'C') cc++;
  }

  ll low = 0;
  ll high = (ll)1e15;
  while (low < high) {
    ll mid = low + (high - low)/2;
    if (rubles(mid) > r) {
      high = mid;
    } else {
      low = mid + 1;
    }
  }
  
  cout << low - 1 << "\n";
  return 0;
}
