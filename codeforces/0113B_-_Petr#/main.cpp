#include <bits/stdc++.h>

using namespace std;

const int MOD = 1e9 + 7;
const int BASE = 37;
const int MAX = 1e7;

typedef long long int ll;

ll h[MAX];
ll p[MAX];

int main() {
  string s, begin, end;
  cin >> s;
  cin >> begin;
  cin >> end;
  unordered_set<int> b;
  for (int i = 0; i < s.size(); i++) {
    int k;
    for (k = 0; s[k + i] && begin[k] && s[k + i] == begin[k]; ++k);
    if (k == begin.size())
      b.insert(i);
  }

  unordered_set<int> e;
  for (int i = 0; i < s.size(); i++) {
    int k;
    for (k = 0; s[k + i] && end[k] && s[k + i] == end[k]; ++k);
    if (k == end.size())
      e.insert(k + i - 1);
  }

  h[0] = s[0];
  p[0] = 1LL;

  for (int i = 1; i < s.size(); i++) {
    h[i] = (h[i - 1] * BASE) + s[i];
    p[i] = p[i - 1] * BASE;
  }

  unordered_set<ll> se;
  for (int i = 0; i < s.size(); i++) {
    if (b.find(i) == b.end()) continue;
    for (int j = i + max(begin.size(), end.size()) - 1; 
             j < s.size(); ++j) {
      if (e.find(j) != e.end()) {
        if (i == 0)
          se.insert(h[j]);
        else
          se.insert(h[j] - (h[i - 1] * p[j - i + 1]));
      }
    }
  }

  cout << se.size() << "\n";

  return 0;
}
