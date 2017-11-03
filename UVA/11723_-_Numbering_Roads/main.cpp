#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int main() {
  int i = 1;
  while (1) {
    int N, R;
    scanf("%d %d", &N, &R);
    if (N == 0 && R == 0)
      break;
    int g = (int)((double)(N - 1) / (double)R);
    if (g > 26)
      printf("Case %d: impossible\n", i);
    else
      printf("Case %d: %d\n", i, g);
    i += 1;
  }
  return 0;
}
