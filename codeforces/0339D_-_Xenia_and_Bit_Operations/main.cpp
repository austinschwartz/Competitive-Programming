#include <bits/stdc++.h>

using namespace std;

#define MAX 131072

int a[MAX];

struct segtree {
  int level, val;
} tree[4 * MAX];

typedef long long int ll;

void build(int node, int l, int r) {
  if (l == r) {
    tree[node].val = a[l];
    tree[node].level = 0;
    return;
  }

  int mid = l + (r - l)/2;
  build(node * 2, l, mid);
  build(node * 2 + 1, mid + 1, r);
  tree[node].level = tree[2 * node].level + 1;
  if (tree[node].level % 2 != 0) {
    tree[node].val = tree[2 * node].val | tree[2 * node + 1].val;
  } else {
    tree[node].val = tree[2 * node].val ^ tree[2 * node + 1].val;
  }
}

void update(int node, int l, int r, int id, int val) {
  if (l == r) {
    tree[node].val = val;
    return;
  }

  int mid = l + (r - l)/2;
  if (id <= mid)
    update(node * 2, l, mid, id, val);
  else
    update(node * 2 + 1, mid + 1, r, id, val);

  if (tree[node].level % 2 != 0) {
    tree[node].val = tree[2 * node].val | tree[2 * node + 1].val;
  } else {
    tree[node].val = tree[2 * node].val ^ tree[2 * node + 1].val;
  }
}

int main() {
  int n, m;
  cin >> n >> m;

  n = 1 << n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  build(1, 0, n - 1);

  for (int i = 0; i < m; i++) {
    int pi, bi;
    cin >> pi >> bi;
    update(1, 0, n - 1, pi - 1, bi);
    cout << tree[1].val << "\n";
  }
  return 0;
}
