#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int dp[102][102];
vector<int> a;
vector<int> b;
int n, m;

int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int ai;
    scanf("%d", &ai);
    a.push_back(ai);
  }

  scanf("%d", &m);
  for (int i = 0; i < m; i++) {
    int bi;
    scanf("%d", &bi);
    b.push_back(bi);
  }
  
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= m; j++) {
      dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
      if (abs(a[i - 1] - b[j - 1]) <= 1) {
        dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + 1);
      }
    }
  }

  printf("%d\n", dp[n][m]);
  return 0;
}
