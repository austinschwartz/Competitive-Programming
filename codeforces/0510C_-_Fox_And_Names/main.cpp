#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int MAXN = 101;

set<int> adj[MAXN];
vector<int> l;
int vis[27];
bool flag = false;

string names[MAXN];
int n;

void dfs(int u) {
  if (vis[u] == 2)
    return;
  if (vis[u] == 1) {
    flag = true;
    return;
  }
  vis[u] = 1;
  for (int v : adj[u])
    dfs(v);
  vis[u] = 2;
  l.push_back(u);
}

int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> names[i];
  }
  for (int i = 0; i < n; i++) {
    string a = names[i];
    for (int j = i + 1; j < n; j++) {
      string b = names[j];
      bool finished = false;
      for (int k = 0; k < min(a.length(), b.length()); k++) {
        int aa = a[k] - 'a';
        int bb = b[k] - 'a';
        if (aa != bb) {
          adj[aa].insert(bb);
          finished = true;
          break;
        }
      }
      if (!finished && a.length() > b.length())
        flag = true;
    }
  }

  memset(vis, 0, sizeof(vis));  
  for (int i = 0; i < 26; i++)
    if (vis[i] == 0)
      dfs(i);

  if (flag) {
    cout << "Impossible\n";
    return 0;
  }

  for (int i = l.size() - 1; i >= 0; i--)
    cout << (char)(l[i] + 'a');

  cout << "\n";

  return 0;
}
