#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAXN = 1e5 + 7;
const int MOD = 537;
const int BASE = 37;

ll p[MAXN];
ll ha[MAXN];
ll hb[MAXN];

int main() {
  string a, b;
  cin >> a >> b;
  if (a.size() < b.size()) {
    string temp = a;
    a = b;
    b = temp;
  }

  int n = a.size();
  int m = b.size();

  int ans = 0;
  for (int i = 1; i <= min(n, m); i++) {
    if (n % i == 0 && m % i == 0) {
      bool flag = true;
      for (int j = 0; j < n && flag; j++)
        if (a[j] != a[j % i]) flag = false;
      for (int j = 0; j < m && flag; j++) 
        if (b[j] != b[j % i]) flag = false;
      for (int j = 0; j < i && flag; j++)
        if (a[j] != b[j]) flag = false;
      ans += flag;
    }
  }
  printf("%d\n",ans);

  return 0;
}
