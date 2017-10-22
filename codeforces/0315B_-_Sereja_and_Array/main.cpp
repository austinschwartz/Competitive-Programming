#include <algorithm>
#include <cstdio>
#include <vector>

using namespace std;

int a[100001];
int n, m;

int main() {
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  int add = 0;
  for (int i = 0; i < m; i++) {
    int t, v, x, y, q;
    scanf("%d", &t);
    if (t == 1) {
      scanf("%d %d", &v, &x);
      a[v - 1] = x - add;
    } else if (t == 2) {
      scanf("%d", &y);
      add += y;
    } else if (t == 3) {
      scanf("%d", &q);
      printf("%d\n", a[q - 1] + add);
    }
  }
}
