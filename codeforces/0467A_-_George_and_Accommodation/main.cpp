#include <cstdio>
#include <algorithm>

int main() {
  int n;
  scanf("%d", &n);
  int ret = 0, pi, qi;
  for (int i = 0; i < n; i++) {
    scanf("%d %d", &pi, &qi);
    if (qi - pi >= 2) {
      ret += 1;
    }
  }
  printf("%d\n", ret);
}
