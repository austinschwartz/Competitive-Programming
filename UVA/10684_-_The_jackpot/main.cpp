#include <cstdio>
#define max(a, b) a >= b ? a : b
using namespace std;

int main() {
  int N;
  while (true) {
    scanf("%d\n", &N);
    if (N == 0)
      break;
    int x[N], s[N], sum = 0, max_sum = 0, min_sum = 0;
    for (int i = 0; i < N; i++) {
      scanf("%d", &x[i]);
    }
    for (int i = 0; i < N; i++) {
      sum += x[i];
      if (sum < min_sum)
        min_sum = sum;
      if (sum - min_sum > max_sum) {
        max_sum = sum - min_sum;
      }
    }
    if (max_sum == 0)
      printf("Losing streak.\n");
    else
      printf("The maximum winning streak is %d.\n", max_sum);
  }
}
