#include <cstdio>
#include <algorithm>

using namespace std;

int main() {
  int T;
  scanf("%d\n", &T);
  for (int i = 0; i < T; i++) {
    int N;
    scanf("%d\n", &N);
    if (N == 0) {
      printf("Case %d: %d\n", i + 1, 0);
      continue;
    }
    long long a[N];
    long long dp[N];
    for (int j = 0; j < N; j++) {
      scanf("%lld", &a[j]);
      dp[j] = -1;
    }

    dp[0] = a[0];
    dp[1] = max(a[0], a[1]);
    for (int j = 2; j < N; j++)
      dp[j] = max(dp[j-2] + a[j], dp[j-1]);

    printf("Case %d: %lld\n", i+1, dp[N-1]);
  }
}
