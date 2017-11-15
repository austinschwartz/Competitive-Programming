#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

#define MAX 200007

int n, m, k;
int color[MAX];
int par[MAX];

vector<int> c[MAX];

int find(int i) {
  if (par[i] == i)
    return i;
  return par[i] = find(par[i]);
}

void merge(int a, int b) {
  int p = find(a);
  int q = find(b);
  if (p == q)
    return;
  par[q] = par[p];
}

int main() {
  scanf("%d %d %d", &n, &m, &k);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &color[i]);
    par[i] = i;
  }

  for (int i = 0; i < m; i++) {
    int l, r;
    scanf("%d %d", &l, &r);
    merge(l, r);
  }

  int ret = 0;
  for (int i = 1; i <= n; ++i) {
    c[find(i)].push_back(color[i]);
  }

  for (int i = 1; i <= n; ++i) {
    sort(c[i].begin(), c[i].end());
    int maxx = 0, count = 0, prev = -1;
    for (int x: c[i]) {
      if (x != prev) {
        count = 0;
      }
      count += 1;
      maxx = max(maxx, count);
      prev = x;
    }
    ret += int(c[i].size()) - maxx;
  }

  printf("%d\n", ret);
  return 0;
}
