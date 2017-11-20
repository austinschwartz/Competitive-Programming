#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

#define MAX 200001

int n, q;
int a[MAX], b[MAX], v[MAX];

int main() {
  cin >> n >> q;
  for (int i = 0; i < n; i++)
    cin >> a[i];
  sort(a, a + n);
  for (int i = 0; i < q; i++) {
    int li, ri;
    cin >> li >> ri;
    v[li - 1] += 1;
    if (ri < n)
      v[ri]--;
  }

  int cur = 0;
  for (int i = 0; i < n; i++) {
    cur += v[i];
    b[i] = cur;
  }

  sort(b, b + n);

  ll ret = 0;
  for (int i = 0; i < n; i++)
    ret += (a[i] * 1ll * b[i]);
  cout << ret << "\n";
  return 0;
}
