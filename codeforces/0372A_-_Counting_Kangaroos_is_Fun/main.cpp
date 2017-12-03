#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAXN = 5 * 1e5 + 7;

int s[MAXN];

int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> s[i];
  }
  sort(s, s + n);
  int pos = n / 2;
  int ans = n;
  for (int i = 0; i < n / 2 && pos < n; i++) {
    while (pos < n) {
      if (s[i] * 2 <= s[pos]) {
        pos++;
        ans--;
        break;
      } else {
        pos++;
      }
    }
  }
  cout << ans << "\n";
  return 0;
}
