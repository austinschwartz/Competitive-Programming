#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int id[100002];

int main() {
  int n, k;
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    cin >> id[i];
  }
  for (int i = 1; i <= n; i++) {
    if (i < k) {
      k -= i;
    } else {
      cout << id[k] << "\n";
      return 0;
    }
  }
  return 0;
}
