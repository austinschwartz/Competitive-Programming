#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAXN = 1e5 + 7;

int a[MAXN], b[MAXN];

int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    b[i] = a[i];
  }
  
  sort(b, b + n);
  
  int c = 0;
  for (int i = 0; i < n && c < 3; i++) {
    if (a[i] != b[i]) {
      c += 1;
    }
  }

  if (c > 2)
    cout << "NO\n";
  else
    cout << "YES\n";
  
  return 0;
}
