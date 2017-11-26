#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAX = 101;

int a[MAX];
vector<int> v[MAX];

int main() {
  int n, k;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  int mi = *min_element(a, a + n);
  int ma = *max_element(a, a + n);

  if (mi + k < ma) {
    cout << "NO\n";
    return 0;
  }

  cout << "YES\n";

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < a[i]; j++) {
      v[i].push_back(((j % k) + 1));
    }
  }

  for (int i = 0; i < n; i++) {
    sort(v[i].begin(), v[i].end());
    for (int j = 0; j < v[i].size(); j++) {
      if (j != 0)
        cout << " ";
      cout << v[i][j];
    }
    cout << "\n";
  }
  return 0;
}
