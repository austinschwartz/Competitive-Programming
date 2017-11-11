#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int f(int n) {
  return (n / 2) * 3; 
}

int main() {
  ios_base::sync_with_stdio(0);
  int n;
  cin >> n;
  printf("%d\n", f(n));
  return 0;
}
