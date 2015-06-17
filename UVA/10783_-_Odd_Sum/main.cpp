#include <cstdio>

using namespace std;

int main() {
  int T, a, b, i, j;
  scanf("%d\n", &T);
  for (i = 1; i <= T; i++) {
    scanf("%d\n%d\n", &a, &b);
    int sum = 0;
    for (j = a; j <= b; j++) {
      if (j % 2 == 1) sum += j;
    }
    printf("Case %d: %d\n", i, sum);
  }
}
