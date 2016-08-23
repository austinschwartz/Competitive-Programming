#include <cstdio>
#include <cstdlib>

#define ll long long

int hh(unsigned ll x) {
    x = (x & 0x5555555555555555ULL) + ((x >> 1) & 0x5555555555555555ULL);
    x = (x & 0x3333333333333333ULL) + ((x >> 2) & 0x3333333333333333ULL);
    x = (x & 0x0F0F0F0F0F0F0F0FULL) + ((x >> 4) & 0x0F0F0F0F0F0F0F0FULL);
    return (x * 0x0101010101010101ULL) >> 56;
}

unsigned ll b[10000][10000][55];

int main() {
  int n = 0, m = 0, q = 0, r = 0;
  int maxxx = 55;
  int mi = 1000 / maxxx;
  scanf("%d %d %d\n", &n, &m, &q);
  
  for (int t = 0; t < q + 1; t++)
    for (int y = 0; y < n; y++)
      for (int u = 0; u < maxxx + 1; u++)
        b[t][y][u] = 0LU;

  for (r = 1; r <= q; r++) {
    int op = 0;
    int i = 0, j = 0, k = 0;
    for (i = 0; i < n; i++)
      for (j = 0; j < n; j++)
        b[r][i][j] = b[r-1][i][j];

    scanf("%d", &op);
    switch (op) {
      case 1:
        scanf("%d %d\n", &i, &j);
        b[r][i][j/mi] |= (1 << (j % mi));
        break;
      case 2:
        scanf("%d %d\n", &i, &j);
        b[r][i][j/mi] &= ~(1 << (j % mi));
        break;
      case 3:
        scanf("%d\n", &i);
        for (j = 0; j < m; j++)
          b[r][i][j/mi] ^= (1 << (j % mi));
        break;
      case 4:
        scanf(" -%d\n", &k);
        for (i = 0; i < n; i++)
        for (j = 0; j < maxxx; j++)
        b[r][i][j] = b[k][i][j];
        break;
    }
    int ret = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < maxxx; j++)
        ret += hh(b[r][i][j]);
    printf("%d\n", ret);
  }
}

