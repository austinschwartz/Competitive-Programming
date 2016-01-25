using namespace std;
#include <bits/stdc++.h>
#define inf (1<<30)
#define eps 1e-9
typedef long long i64;
typedef unsigned long long ui64;
typedef string st;
typedef vector<int> vi;
typedef vector<st> vs;
typedef map<int,int> mii;
typedef map<st,int> msi;
typedef set<int> si;
typedef set<st> ss;
typedef pair<int,int> pii;
typedef vector<pii> vpii;
#define mx 0

int R, C, x, y;
char o;
string i;

char newDir(char oldDir, char turn) {
  switch (oldDir)
  {
    case 'N':
      if (turn == 'L') return 'W';
      if (turn == 'R') return 'E';
      break;
    case 'E':
      if (turn == 'L') return 'N';
      if (turn == 'R') return 'S';
      break;
    case 'S':
      if (turn == 'L') return 'E';
      if (turn == 'R') return 'W';
      break;
    case 'W':
      if (turn == 'L') return 'S';
      if (turn == 'R') return 'N';
      break;
  }
  return 'X';
}

bool lost(int[][] grid, int x, int y)
{
  if (grid[x][y] == true)
    return true;
}

int main()
{
  scanf("%d %d\n", &R, &C);
  bool grid[R + 1][C + 1];
  while (scanf("%d %d %c", &x, &y, &o) != EOF)
  {
    cin >> i;
    bool lost = false;
    for (char& chr : i)
    {
      printf("%d %d %c\n", x, y, o);
      switch (chr)
      {
        case 'L':
        case 'R':
          o = newDir(o, chr);
          break;
        case 'F':
          if (o == 'N') { y++; if (lost(grid, x, y)) y--; }
          if (o == 'E') { x++; if (lost(grid, x, y)) x--; }
          if (o == 'S') { y--; if (lost(grid, x, y)) y++; }
          if (o == 'W') { x--; if (lost(grid, x, y)) x++; }
          break;
      }
    }
    printf("\n");
  }
  return 0;
}
