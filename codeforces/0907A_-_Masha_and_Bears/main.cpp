#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

bool climb(int a, int b) {
  return a <= b;
}

bool likes(int a, int b) {
  return climb(a, b) && 2 * a >= b;
}

int main() {
  int papa, mother, son, martha;
  cin >> papa >> mother >> son >> martha;
  for (int car3 = 1; car3 <= 300; car3++) {
    if (!likes(son, car3) || !likes(martha, car3))
      continue;
    for (int car2 = car3 + 1; car2 <= 300; car2++) {
      if (!likes(mother, car2) || !climb(martha, car2) || likes(martha, car2))
        continue;
      for (int car1 = car2 + 1; car1 <= 300; car1++) {
        if (!likes(papa, car1) || !climb(martha, car1) || likes(martha, car1))
          continue;
        cout << car1 << "\n" << car2 << "\n" << car3 << "\n";
        return 0;
      }
    }
  }
  cout << "-1\n";
  return 0;
}
