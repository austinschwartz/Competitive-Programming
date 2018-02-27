#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int main() {
  int m, n;
  double mm, nn;
  scanf("%d %d", &m, &n);
  mm = m;
  nn = n;
  double ans = 0;
  for (int i = 1; i <= m; i++) {
    double ii = i;
    ans += ii * (pow(ii / mm, nn) - pow((ii - 1.) / mm, nn));
  }
  printf("%.12lf\n", ans);
  return 0;
}
