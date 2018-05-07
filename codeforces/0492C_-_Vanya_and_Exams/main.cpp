#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAXN = 1e5;

pair<int, int> p[MAXN];

int main() {
  int n, r, avg;
  scanf("%d %d %d", &n, &r, &avg);

  int points = 0;
  for (int i = 0; i < n; i++) {
    int a, b;
    scanf("%d %d", &b, &a);
    points += a;
    p[i] = {a, b};
  }

  sort(p, p + n);

  int essays = 0;
  int i = 0;
  printf("%d %d\n", points, avg * n);
  while (points < avg * n) {
      int t = min(avg * n - points, r - p[i].second);
      essays += t * p[i].first;
      points += t;
      i += 1;
  }

  printf("%d\n", essays);
}
