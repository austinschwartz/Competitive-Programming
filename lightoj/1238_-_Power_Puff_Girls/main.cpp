#include <algorithm>
#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <queue>

#define INF 0x3f3f3f3f;

using namespace std;

char grid[21][21];
bool vis[21][21];
int dist[21][21];
int coords[4][2] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

void bfs(int x, int y, int m, int n) {
  for (int i = 0; i < 21; i++) {
    for (int j = 0; j < 21; j++) {
      dist[i][j] = INF;
      vis[i][j] = false;
    }
  }

  dist[x][y] = 0;
  vis[x][y] = true;
  queue< pair<int, int> > q;
  int px, py;
  q.push(make_pair(x, y));
  while (!q.empty()) {
    px = q.front().first;
    py = q.front().second;
    q.pop();
    for (int i = 0; i < 4; i++) {
      int nx = px + coords[i][0];
      int ny = py + coords[i][1];
      if (nx >= 0 && ny >= 0 && nx < m && ny < n &&
          grid[nx][ny] != '#' && grid[nx][ny] != 'm' &&
          vis[nx][ny] == false) {
        dist[nx][ny] = min(dist[px][py] + 1, dist[nx][ny]);
        vis[nx][ny] = true;
        q.push(make_pair(nx, ny));
      }
    }
  }
}

int main() {
  int T;
  scanf("%d", &T);
  for (int t = 1; t <= T; t++) {
    int n, m;
    scanf("%d %d", &m, &n);
    for (int i = 0; i < m; i++) {
      cin >> grid[i];
    }

    int ai, aj, bi, bj, ci, cj, hi, hj;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 'h') {
          hi = i;
          hj = j;
        } else if (grid[i][j] == 'a') {
          ai = i;
          aj = j;
        } else if (grid[i][j] == 'b') {
          bi = i;
          bj = j;
        } else if (grid[i][j] == 'c') {
          ci = i;
          cj = j;
        }
      }
    }
    
    bfs(hi, hj, m, n);

    int ret = max(max(dist[ai][aj],
                      dist[bi][bj]),
                      dist[ci][cj]);
    printf("Case %d: %d\n", t, ret);
  }
}
