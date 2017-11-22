#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int N = 1e5 + 107;
const int P = 11;
const int DIM = 101;

int n, q, c;
int cnt[P][DIM][DIM];

int main() {
  cin >> n >> q >> c;
  for (int i = 0; i < n; i++) {
    int x, y, s;
    cin >> x >> y >> s;
    cnt[s][x][y] += 1;
  }

  for (int p = 0; p <= c; p++) {
    for (int i = 1; i < DIM; i++) {
      for (int j = 1; j < DIM; j++) {
        cnt[p][i][j] += cnt[p][i - 1][j] + 
                        cnt[p][i][j - 1] - 
                        cnt[p][i - 1][j - 1];
      }
    }
  }

  for (int i = 0; i < q; i++) {
    int t, x1, y1, x2, y2;
    cin >> t >> x1 >> y1 >> x2 >> y2;
    int ans = 0;
    for (int p = 0; p <= c; p++) {
      int b = (p + t) % (c + 1);
      int amount = cnt[p][x2][y2]
                 - cnt[p][x1 - 1][y2]
                 - cnt[p][x2][y1 - 1]
                 + cnt[p][x1 - 1][y1 - 1];
      ans += (b * amount);
    }
    cout << ans << "\n";
  }


  return 0;
}
