#include <bits/stdc++.h>

using namespace std;

#define ll long long

int main() {
  ios_base::sync_with_stdio(0);
  int ans[4] = {8, 4, 2, 6};
  int n;
  scanf("%d", &n);
  if (n == 0)
    printf("1\n");
  else
    printf("%d\n", ans[(n - 1) % 4]);
  return 0;
}
