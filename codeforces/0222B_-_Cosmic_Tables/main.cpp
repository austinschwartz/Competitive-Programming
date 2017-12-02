#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

#define MAXN 1001

int T[MAXN][MAXN];
int c[MAXN];
int r[MAXN];

int main() {
  int n, m, k;
  scanf("%d %d %d", &n, &m, &k);
  for (int i = 0; i < n; i++)
    r[i] = i;
  for (int j = 0; j < m; j++)
    c[j] = j;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      int x;
      scanf("%d", &x);
      T[i][j] = x;
    }
  }
  for (int i = 0; i < k; i++) {
    char s;
    int x, y;
    scanf(" %c %d %d", &s, &x, &y);
    if (s == 'c') {
      int temp = c[x - 1];
      c[x - 1] = c[y - 1];
      c[y - 1] = temp;
    } else if (s == 'r') {
      int temp = r[x - 1];
      r[x - 1] = r[y - 1];
      r[y - 1] = temp;
    } else {
      printf("%d\n", T[r[x - 1]][c[y - 1]]);
    }
  }
  return 0;
}
