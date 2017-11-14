#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

vector<string> v;
char s[3];
char e[3];

void dfs(char x1, char y1, char x2, char y2) {
  if (x1 == x2 && y1 == y2)
    return;

  if (x1 == x2) {
    if (y1 < y2) {
      v.push_back("U");
      dfs(x1, y1 + 1, x2, y2);
      return;
    } else if (y2 < y1) {
      v.push_back("D");
      dfs(x1, y1 - 1, x2, y2);
      return;
    }
  }
  
  if (y1 == y2) {
    if (x1 < x2) {
      v.push_back("R");
      dfs(x1 + 1, y1, x2, y2);
      return;
    } else if (x2 < x1) {
      v.push_back("L");
      dfs(x1 - 1, y1, x2, y2);
      return;
    }
  }

  if (y1 < y2 && x1 < x2) {
    v.push_back("RU");
    dfs(x1 + 1, y1 + 1, x2, y2);
    return;
  }

  if (y1 < y2 && x1 > x2) {
    v.push_back("LU");
    dfs(x1 - 1, y1 + 1, x2, y2);
    return;
  }

  if (y1 > y2 && x1 < x2) {
    v.push_back("RD");
    dfs(x1 + 1, y1 - 1, x2, y2);
    return;
  }

  if (y1 > y2 && x1 > x2) {
    v.push_back("LD");
    dfs(x1 - 1, y1 - 1, x2, y2);
    return;
  }

}

int main() {
  cin >> s;
  cin >> e;
  dfs(s[0], s[1], e[0], e[1]);
  cout << v.size() << "\n";
  for (auto l : v) {
    cout << l << "\n";
  }
  return 0;
}
