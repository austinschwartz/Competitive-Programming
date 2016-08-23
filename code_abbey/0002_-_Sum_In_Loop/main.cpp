#include <cstdio>

using namespace std;

int main() {
  int n, sum, x;
  sum = 0;
  scanf("%d\n", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &x);
    sum += x;
  }
  printf("%d\n", sum);
}

