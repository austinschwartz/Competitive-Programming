#include <bits/stdc++.h>

using namespace std;

#define ll long long
#define MAX 100005

int m[MAX];
int h[MAX];
int n;

int main() {
  ios_base::sync_with_stdio(0);
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &h[i]);
  }
  for (int i = n - 1; i >= 0; i--) {
    if (i == n - 1)
      m[i] = h[i];
    else
      m[i] = max(h[i], m[i + 1]);
  }
  for (int i = 0; i < n; i++) {
    if (i != 0)
      printf(" ");
    if (i == n - 1)
      printf("0");
    else
      printf("%d", max(0, m[i + 1] + 1 - h[i]));
  }
  printf("\n");
  return 0;
}
