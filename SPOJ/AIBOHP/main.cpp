#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

#define MAX 6105

string str;
string rev;
int dp[MAX][MAX];

int ans() {
  memset(dp, 0, sizeof(dp));
  int n = str.length();

  for (int i = 0; i <= n; i++) {
    for (int j = 0; j <= n; j++) {
      if (i == 0 || j == 0) {
        dp[i][j] = 0;
      } else if (str[i - 1] == rev[j - 1]) {
        dp[i][j] = 1 + dp[i - 1][j - 1];
      } else {
        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
  }

  return n - dp[n][n];
}

int main() {
  int t;
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> str;
    rev = str;
    reverse(rev.begin(), rev.end());
    printf("%d\n", ans());
  }
  return 0;
}
