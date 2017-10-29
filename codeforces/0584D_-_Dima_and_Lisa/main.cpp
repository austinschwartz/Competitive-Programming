#include <bits/stdc++.h>

using namespace std;

#define MAX 110000

typedef long long int ll;

set<int> primes;

void sieve() {
  bool prime[MAX];
  memset(prime, 1, sizeof(prime));
  for (int i = 2; i * i < MAX; i++) {
    if (prime[i]) {
      primes.insert(i);
      for (int j = 2 * i; j < MAX; j += i) {
        prime[j] = false;
      }
    }
  }
}

bool is_prime(int n) {
  if (n <= 330) {
    return (primes.find(n) != primes.end());
  }
  for (int i = 2; i * i <= n; i++) {
    if (n % i == 0) {
      return false;
    }
  }
  return true;
}

int main() {
  sieve();
  int n;
  scanf("%d", &n);
  if (n == 3) {
    printf("1\n3\n");
    return 0;
  }
  int a = n - 1, b = 0, c = 0;
  while (!is_prime(a)) { a--; }
  while (!is_prime(a)) { a--; }
  if (n - a < 5) {
    if (is_prime(n - a)) {
      printf("2\n%d %d\n", a, n - a);
      return 0;
    }
  }
  for (b = 2; b <= 300; b++) {
    if (!is_prime(b)) {
      continue;
    }
    c = n - a - b;
    if (is_prime(c)) {
      break;
    }
  }
  printf("3\n");
  printf("%d %d %d\n", a, b, c);
  return 0;
}
