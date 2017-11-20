#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int p, q, l, r;
int a[1001], b[1001], c[1001], d[1001];

bool f(int t) {
  for (int i = 0; i < p; i++)
    for (int j = 0; j < q; j++)
      if (t + c[j] <= b[i] && d[j] + t >= a[i])
        return true;
  return false;
}

int main() {
  cin >> p >> q >> l >> r;
  for (int i = 0; i < p; i++)
    cin >> a[i] >> b[i];
  for (int i = 0; i < q; i++)
    cin >> c[i] >> d[i];

  int ret = 0;
  for (int t = l; t <= r; t++)
    if (f(t))
      ret += 1;

  cout << ret << "\n";
  return 0;
}
