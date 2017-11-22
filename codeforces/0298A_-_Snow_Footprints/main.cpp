#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int main() {
  int n;
  string s;
  cin >> n;
  cin >> s;
  int Ls = 0;
  int Rs = 0;
  int firstR = -1;
  int firstL = -1;
  int lastR = -1;
  int lastL = -1;
  for (int i = 0; i < n - 1; i++) {
    if (s[i] == 'L') {
      Ls += 1;
      if (firstL == -1)
        firstL = i + 1;
      lastL = i + 1;
    }
    if (s[i] == 'R') {
      Rs += 1;
      if (firstR == -1)
        firstR = i + 1;
      lastR = i + 1;
    }
  }
  if (Ls == 0) {
    cout << firstR << " " << lastR + 1 << "\n";
  } else if (Rs == 0) {
    cout << lastL << " " << firstL - 1 << "\n";
  } else if (firstR < firstL) {
    cout << firstR << " " << firstL - 1 << "\n";
  } else {
    cout << firstL << " " << firstR - 1 << "\n";
  }
  return 0;
}
