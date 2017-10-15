#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

int main() {
  int T, a, b;
  cin >> T;
  for (int i = 1; i <= T; i++) {
    cin >> a;
    b = a / 2;
    a = a % 2 + a / 2;
    cout << a << " " << b << "\n";
  }

  return 0;
}
