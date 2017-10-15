#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

int main() {
  int T, a, b;
  cin >> T;
  for (int i = 1; i <= T; i++) {
    cin >> a >> b;
    printf("Case %d: %d\n", i, a + b);
  }
  return 0;
}
