#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

#define MAX 16

int n, l, r, x;
int c[MAX];

int main() {
  scanf("%d %d %d %d", &n, &l, &r, &x);
  for (int i = 0; i < n; i++) {
    scanf("%d", &c[i]);
  }
  int ways = 0;
  for (int i = 0; i < pow(2, n); i++) {
    int mi = (1e9);
    int ma = -1;
    int tot = 0;
    int count = 0;
    for (int j = 0; j < n; j++) {
      if ((i & (1 << j)) != 0) {
        tot += c[j];
        count++;
        ma = max(ma, c[j]);
        mi = min(mi, c[j]);
      }
    }
    if (count < 2)
      continue;
    if (abs(ma - mi) >= x && tot >= l && tot <= r) {
      ways += 1;
    }
  }
  printf("%d\n", ways);
  return 0;
}
