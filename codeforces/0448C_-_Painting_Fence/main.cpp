#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int n;
int a[5001];

int f(int l, int r, int h) {
  for (int i = l; i <= r; i++)
    a[i] -= h;

  int m = *min_element(a + l, a + r + 1);
  vector< pair<int, int> > v;
  int ret = m;
  for (int i = l; i <= r; i++) {
    if (a[i] == m)
      continue;
    int j = i;
    while (j <= r && a[j] > m) {
      j += 1;
    }
    v.push_back(make_pair(i, j - 1));
    i = j - 1;
  }

  for (pair<int, int> p : v) {
    ret += f(p.first, p.second, m);
  }

  return min(ret, r - l + 1);
}

int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  printf("%d\n", f(0, n - 1, 0));
  return 0;
}
