#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAXN = 1e5 + 7;

int a[MAXN];
int b[MAXN];

int main() {
  int n, k;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    b[i % k] += a[i];
  }
  int min_index = 0;
  for (int i = 0; i < k; i++) {
    if (b[i] < b[min_index])
      min_index = i;
  }
  cout << (min_index + 1) << "\n";
  return 0;
}
