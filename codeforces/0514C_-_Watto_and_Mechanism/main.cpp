#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;
typedef unsigned long long int ull;

const int MAXN = 1000001;
const int BASE = 137;

map<ull, string> hashes;
ull powers[MAXN];

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);

  powers[0] = 1;
  for (int i = 0; i < MAXN; i++) {
    powers[i + 1] = BASE * powers[i];
  }

  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    ull h = 0;
    for (int j = 0; j < s.size(); j++) {
      h += (powers[j] * ((int)s[j]));
    }
    hashes[h] = s;
  }

  for (int k = 0; k < m; k++) {
    string s;
    cin >> s;
    ull h = 0;
    for (int j = 0; j < s.size(); j++) {
      h += (powers[j] * ((int)s[j]));
    }

    bool found = false;
    for (int i = 0; i < s.length() && !found; i++) {
      ull ch = h - (powers[i] * (int)s[i]);
      for (int j = 0; j < 3; j++) {
        char c = 'a' + j;
        if (s[i] == c)
          continue;
        ull nh = ch + (powers[i] * (int)c);
        if (hashes.find(nh) != hashes.end()) {
          string ss = hashes[nh];
          int diff = 0;
          for (int l = 0; l < ss.size(); l++)
            if (ss[l] != s[l])
              diff += 1;
          if (diff == 1) {
            found = true;
            break;
          }
        }
      }
    }
    if (!found)
      cout << "NO\n";
    else
      cout << "YES\n";
  }
  return 0;
}
