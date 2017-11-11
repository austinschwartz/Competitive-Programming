#include <cstdio>

#define MAX 200001

int main() {
  int n;
  scanf("%d", &n);
  int x[MAX], y[MAX], h[MAX], a[MAX];
  for (int i = 0; i < n; i++) {
    scanf("%d %d", &x[i], &y[i]);
    x[i] -= 1;
    y[i] -= 1;
    h[x[i]]++;
  }
  for (int i = 0; i < n; i++) {
    int home = n - 1 + h[y[i]];
    int away = 2 * (n - 1) - home;
    printf("%d %d\n", home, away);
  }
}
