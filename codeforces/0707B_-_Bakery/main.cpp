#include <algorithm>
#include <cstdio>
#include <vector>
#include <set>

#ifdef ONLINE_JUDGE
#define LL "%I64d"
#else
#define LL "%lld"
#endif

#define MAX 100001
#define ll long long

using namespace std;

vector< pair< int, ll > > adj[MAX];
int a[MAX];

int main() {
  int n, m, k;
  scanf("%d %d %d", &n, &m, &k);
  for (int i = 0; i < m; i++) {
    int u, v;
    ll l;
    scanf("%d %d", &u, &v);
    scanf(LL, &l);
    adj[u - 1].push_back(make_pair(v - 1, l));
    adj[v - 1].push_back(make_pair(u - 1, l));
  }
  set<int> warehouses;
  ll cost = (1e15);
  for (int i = 0; i < k; i++) {
    scanf("%d", &a[i]);
    a[i] -= 1;
    warehouses.insert(a[i]);
  }

  for (int i = 0; i < k; i++) {
    for (pair<int, ll> v : adj[a[i]]) {
      if (warehouses.find(v.first) == warehouses.end()) {
        cost = min(cost, v.second);
      }
    }
  }
  if (cost == (1e15)) {
    cost = -1;
  }
  printf(LL, cost);
  printf("\n");
}
