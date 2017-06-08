#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 2048
#define MOD 1000000007LL

long long dp[SIZE][SIZE];

int n, k;
int main() {
  scanf("%d %d\n", &n, &k);
  memset(dp, 0, sizeof(dp));

  for (int i = 1; i <= n; i++)
    dp[i][0] = 1;

  for (int i = 1; i < k; i++)
    for (int j = 1; j <= n; j++)
      for (int m = 1; j * m < SIZE; m++)
        dp[j * m][i] = (dp[j * m][i] + dp[j][i - 1]) % MOD;

  long long ans = 0LL;
  for (int i = 1; i <= n; i++)
    ans = (ans + dp[i][k - 1]) % MOD;

  printf("%lld\n", ans);
}
