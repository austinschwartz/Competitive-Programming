#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main() {
  while (1) {
    string x;
    cin >> x;
    if (x.compare("#") == 0)
      break;
    int count = next_permutation(x.begin(), x.end());
    if (count > 0) {
      cout << x;
    } else {
      cout << "No Successor";
    }
    cout << "\n";
  }
}
