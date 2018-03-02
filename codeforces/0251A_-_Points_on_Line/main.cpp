#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAXN = 1e5 + 7;

ll nums[MAXN];

int main() {
  int n, d;
  cin >> n;
  cin >> d;
  for (int i = 0; i < n; i++) {
    cin >> nums[i];
  }

  ll ans = 0;
  int j = 0;
  for (int i = 0; i < n; i++) {
    while (j < n && nums[j] <= nums[i] + d) {
      j++;
    }
    j -= 1;
    ll p = j - i;
    ans += (p * (p - 1) / 2);
  }
  cout << ans << "\n";
  return 0;
}
