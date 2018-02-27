#include <bits/stdc++.h>

using namespace std;

#define ll long long
#define MAX 20005

int x[MAX];
ll p[MAX];
ll pk[MAX];

int main() {
  int n, k;
  scanf("%d %d", &n, &k);
  for (int i = 0; i < n; i++) {
    scanf("%d", &x[i]);
  }

  ll sum = 0;
  for (int i = 0; i < k - 1; i++) {
    sum += x[i];
  }

  for (int i = k - 1; i < n; i++) {
    sum += x[i];
    p[i - k + 1] = sum;
    sum -= x[i - k + 1];
  }

  vector<pair<ll, int> > P;
  P.resize(n, make_pair(-1, -1));
  ll maxi = 0;
  int pos = -1;
  for (int i = k - 1; i < n; i++) {
    if (maxi < p[i - k + 1]) {
      maxi = p[i - k + 1];
      pos = i - k + 1;
    }
    P[i] = make_pair(maxi, pos);
  }

  int a = -1;
  int b = -1;
  maxi = 0;
  for (int i = k; i < n - k + 1; i++) {
    if (p[i] + P[i - 1].first > maxi) {
      maxi = p[i] + P[i - 1].first;
      a = P[i - 1].second;
      b = i;
    }
  }
  printf("%d %d\n", a, b);
  
}
