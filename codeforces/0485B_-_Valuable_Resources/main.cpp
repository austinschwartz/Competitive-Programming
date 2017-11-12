#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int main() {
  int n;
  cin >> n;
  ll xmin = (int)2e9, xmax = (int)(-2e9);
  ll ymin = (int)2e9, ymax = (int)(-2e9);
  for (int i = 0; i < n; i++) {
    ll x, y;
    cin >> x >> y;
    xmin = min(x, xmin);
    xmax = max(x, xmax);
    ymin = min(y, ymin);
    ymax = max(y, ymax);
  }
  ll f = max(abs(ymax - ymin), abs(xmax - xmin));
  cout << f * f << "\n";
  return 0;
}
