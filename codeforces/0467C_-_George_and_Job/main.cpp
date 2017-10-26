#include <cstdio>
#include <algorithm>

using namespace std;

#define ll long long
#define MAX 5001

int n, m, k;
int p[MAX];
ll pp[MAX];
ll dp[MAX][MAX];


int main() {
  scanf("%d %d %d", &n, &m, &k);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &p[i]);
  }
  for (int i = 1; i <= n; i++) {
    pp[i] = pp[i - 1] + p[i];
  }

  for (int i = 1; i <= k; i++) {
    for (int j = (i * m); j <= n; j++) {
      dp[i][j] = max(dp[i][j - 1], dp[i - 1][j - m] + (pp[j] - pp[j-m]));
    }
  }
  printf("%lld\n", dp[k][n]);
}
