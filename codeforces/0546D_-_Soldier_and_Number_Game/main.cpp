#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

#define MAX 5000007

int lowest_prime[MAX];
int primefactors[MAX];
ll pp[MAX];

void sieve() {
  bool prime[MAX];
  memset(prime, true, sizeof(prime));
  for (int i = 4; i < MAX; i+= 2)
    prime[i] = false;
  for (int i = 3; i * i < MAX; i++) {
    if (prime[i]) {
      for (int j = i * i; j < MAX; j += i) {
        prime[j] = false;
      }
    }
  }
  for (int i = 2; i < MAX; i++) {
    if (prime[i] == true) {
      lowest_prime[i] = i;
      continue;
    }
    for (int j = 2; j < MAX; j++) {
      if (prime[j] == false)
        continue;
      if (i % j == 0) {
        lowest_prime[i] = j;
        break;
      }
    }
  }
}

int main() {
  int t;
  sieve();
  primefactors[2] = 1;
  pp[2] = 1;
  for (int i = 3; i < MAX; i++) {
    primefactors[i] = primefactors[i / lowest_prime[i]] + 1;
    pp[i] = pp[i-1] + (ll)primefactors[i];
  }
  scanf("%d", &t);
  for (int i = 1; i <= t; i++){
    int a, b;
    scanf("%d %d", &a, &b);
    printf("%d\n", pp[a] - pp[b]);
  }
  return 0;
}
