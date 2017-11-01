#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

ll ans = 0;
int n;

int digs(int num) {
  bool dig[10];
  for (int i = 0; i < 10; i++)
    dig[i] = false;
  while (num > 0) {
    dig[num % 10] = true;
    num /= 10;
  }

  int count = 0;
  for (int i = 0; i < 10; i++) {
    if (dig[i]) {
      count += 1;
    }
  }
  return count;
}

void dfs(int num) {
  if (num > 0 && num <= n)
    ans += 1LL;
  if (num > 1e9)
    return;
  for (int i = 0; i <= 9; i++) {
    int m = num * 10 + i;
    if (m > 0 && digs(m) <= 2) {
      dfs(m);
    }
  }
}

int main() {
  cin >> n;
  dfs(0);
  cout << ans << "\n";
  return 0;
}
