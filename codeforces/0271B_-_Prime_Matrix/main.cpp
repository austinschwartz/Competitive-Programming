#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int DIM = 501;
const int MAX = 1e5 + 7;

int M[DIM][DIM];
int nextPrime[MAX];
int m, n;

bool is_prime[MAX];

void sieve() {
  memset(is_prime, true, sizeof(is_prime));
  for (int i = 2; i * i <= MAX; i++) {
    if (is_prime[i]) {
      for (int j = i * 2; j <= MAX; j += i) {
        is_prime[j] = false;
      }
    }
  }
  int j = 0;
  for (int i = 2; i < MAX; i++) {
    if (is_prime[i]) {
      while (j <= i) {
        nextPrime[j] = i;
        j++;
      }
    }
  }
}


int main() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cin >> M[i][j];
    }
  }
  sieve();
  int minRow = 1e9 + 7;
  for (int i = 0; i < n; i++) {
    int sum = 0;
    for (int j = 0; j < m; j++) {
      sum += (nextPrime[M[i][j]] - M[i][j]);
    }
    minRow = min(minRow, sum);
  }

  int minCol = 1e9 + 7;
  for (int j = 0; j < m; j++) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += (nextPrime[M[i][j]] - M[i][j]);
    }
    minCol = min(minCol, sum);
  }

  cout << min(minCol, minRow) << "\n";
  return 0;
}
