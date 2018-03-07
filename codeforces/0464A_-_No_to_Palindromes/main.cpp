#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int main() {
  int n, p;
  string s;
  cin >> n >> p;
  cin >> s;

  int i = n - 1;
  s[i] += 1;

  while (i >= 0 && i < n) {
    if (s[i] >= 'a' + p) {
      s[i] = 'a';
      i--;
      s[i]++;
    } else if (i > 0 && s[i] == s[i - 1]) {
      s[i]++;
    } else if (i > 1 && s[i] == s[i - 2]) {
      s[i]++;
    } else {
      i++;
    }
    //cout << s << "\n";
  }

  if (i < 0) {
    cout << "NO";
  } else {
    cout << s << endl;
  }

  return 0;
}
