#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int a[300005];

int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  sort(a, a + n);
  for (int i = 0; i < n - 2; i++) {
    int j = i + 1;
    int k = i + 2;
    if ((ll)a[i] + (ll)a[j] > a[k] && 
      (ll)a[i] + (ll)a[k] > a[j] && 
      (ll)a[j] + (ll)a[k] > a[i]) {
      printf("YES\n");
      return 0;
    }
  }
  printf("NO\n");
  return 0;
}
