#include <bits/stdc++.h>

using namespace std;

#define MAX 100007

int a[MAX];
int tree[4 * MAX];

typedef long long int ll;

void build(int node, int l, int r) {
  if (l == r) {
    tree[node] = a[l];
    return;
  }
  int mid = l + (r - l)/2;
  build(2 * node, l, mid);
  build(2 * node + 1, mid + 1, r);
  tree[node] = min(tree[2 * node], tree[2 * node + 1]);
}

int query(int node, int l, int r, int ql, int qr) {
  if (ql > r || qr < l)
    return (int)1e9;
  if (l >= ql && r <= qr)
    return tree[node];
  int mid = l + (r - l)/2;
  int left = query(2 * node, l, mid, ql, qr);
  int right = query(2 * node + 1, mid + 1, r, ql, qr);
  return min(left, right);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  memset(tree, (int)1e9, sizeof(tree));
  int t;
  scanf("%d", &t);
  for (int i = 1; i <= t; i++) {
    printf("Case %d:\n", i);
    int n, q;
    scanf("%d %d", &n, &q);
    for (int i = 0; i < n; i++) {
      scanf("%d", &a[i]);
    }
    build(1, 0, n - 1);
    for (int j = 0; j < q; j++) {
      int l, r;
      scanf("%d %d", &l, &r);
      printf("%d\n", query(1, 0, n - 1, l - 1, r - 1));
    }
  }
  return 0;
}
