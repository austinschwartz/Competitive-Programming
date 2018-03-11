#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAXN = 1e5 + 7;

pair<int, int> bombs[MAXN];

bool compare(pair<int, int> &a, pair<int, int> &b) {
  return abs(a.first) + abs(a.second) < abs(b.first) + abs(b.second);
}

int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int x, y;
    scanf("%d %d", &x, &y);
    bombs[i] = {x, y};
  }
  sort(bombs, bombs + n, compare);
  int k = 0;
  for (int i = 0; i < n; i++) {
    int x = bombs[i].first;
    int y = bombs[i].second;
    k += 2;
    if (x != 0)
      k += 2;
    if (y != 0)
      k += 2;
  }
  printf("%d\n", k);
  for (int i = 0; i < n; i++) {
    int x = bombs[i].first;
    int y = bombs[i].second;
    if (x > 0)
      printf("1 %d R\n", x);
    else if (x < 0)
      printf("1 %d L\n", abs(x));
    if (y > 0)
      printf("1 %d U\n", y);
    else if (y < 0)
      printf("1 %d D\n", abs(y));
    printf("2\n");
    if (x > 0)
      printf("1 %d L\n", x);
    else if (x < 0)
      printf("1 %d R\n", abs(x));
    if (y > 0)
      printf("1 %d D\n", y);
    else if (y < 0)
      printf("1 %d U\n", abs(y));
    printf("3\n");
  }
  return 0;
}
