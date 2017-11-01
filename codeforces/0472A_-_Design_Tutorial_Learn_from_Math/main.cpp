#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

#define MAX 1000005

bool prime[MAX];
unordered_set<int> composites;

void sieve(void) {
  for (int i = 0; i < MAX; i++)
    prime[i] = true;
  for (int i = 2; i * i < MAX; i++) {
    if (prime[i]) {
      for (int j = i * i; j < MAX; j += i) {
        prime[j] = false;
        composites.insert(j);
      }
    }
  }
}

void solve(int n) {
  int a = 0, b = 0;
  for (a = n - 2; a >= 1; a--) {
    b = n - a;
    if (composites.find(a) != composites.end() &&
        composites.find(b) != composites.end()) {
      printf("%d %d\n", a, b);
      return;
    }
  }
}

int main() {
  sieve();
  int n;
  cin >> n;
  solve(n);
  return 0;
}
