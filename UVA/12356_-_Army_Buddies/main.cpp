#include <cstdio>

using namespace std;

int left[2000000];
int right[2000000];
int S, B, L, R;
int first = 1;

int main() {
  for (;;) {
    if (first == 0)
      printf("-\n");
    scanf("%d %d", &S, &B);
    if (S == 0 && B == 0) break;
    for (int i = 0; i < S + 1; i++) {
      left[i] = i - 1;
      right[i] = i + 1;
    }
    for (int i = 0; i < B; i++) {
      scanf("%d %d", &L, &R);
      if (left[L] < 1)
        printf("* ");
      else
        printf("%d ", left[L]);
      if (right[R] > S)
        printf("*\n");
      else
        printf("%d\n", right[R]);
      left[right[R]] = left[L];
      right[left[L]] = right[R];
    }
    first = 0;
  }
  return 0;
}
