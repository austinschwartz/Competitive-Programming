#include <bits/stdc++.h>

using namespace std;

#define MAXN (101)
#define MAXK (11)
#define MOD ((int)1e8)

typedef long long int ll;

int dp[MAXN][MAXN][2];
int k1, k2;

int f(int n1, int n2, int flag) {
  if (dp[n1][n2][flag] != -1)
    return dp[n1][n2][flag];

  int ret = 0;
  if (flag == 0)
    for (int i = 1; i <= k1 && n1 - i >= 0; i++)
      ret = (ret + f(n1 - i, n2, !flag)) % MOD;
  else
    for (int i = 1; i <= k2 && n2 - i >= 0; i++)
      ret = (ret + f(n1, n2 - i, !flag)) % MOD;

  return dp[n1][n2][flag] = ret;
}

int main() {
  int n1, n2;
  cin >> n1 >> n2 >> k1 >> k2;
  memset(dp, -1, sizeof(dp));
  dp[0][0][0] = 1;
  dp[0][0][1] = 1;

  cout << ((f(n1, n2, 0) + f(n1, n2, 1)) % MOD) << "\n";

  return 0;
}
