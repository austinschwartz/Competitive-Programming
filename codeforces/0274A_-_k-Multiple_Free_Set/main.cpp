#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAX = 1e5 + 7;

int a[MAX];

int main() {
  int n, k;
  cin >> n >> k;
  for (int i = 0; i < n; i++)
    cin >> a[i];
  sort(a, a + n);
  set<int> s;
  for (int i = 0; i < n; i++)
    if (a[i] % k != 0 || s.find(a[i] / k) == s.end())
      s.insert(a[i]);
  cout << s.size() << "\n";
  return 0;
}
