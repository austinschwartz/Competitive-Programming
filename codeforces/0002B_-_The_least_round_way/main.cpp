#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

int grid[1000][1000];
int a[1000][1000][2] = {(int)1e9}; 
char d[1000][1000][2] = {'\0'};
 
int n;

int get(int i, int n) {
  int c = 0;
  while ((i > 0) && ((i % n) == 0)) {
    c ++;
    i /= n;
  }
  return c;
}

void print(int i, int j, int k) {
  if ((i >= 0) && (j >= 0)) {
    if (d[i][j][k] == 'D') {
      print(i - 1, j, k);
    } else {
      print(i, j - 1, k);
    }
    if (d[i][j][k] != '\0') {
      printf("%c", d[i][j][k]);
    }     
  } 
} 

int main() {
  scanf("%d", &n);
  bool zero = false;
  int x, y;
  for (int i = 0; i < n; i ++) {
    for (int j = 0; j < n; j ++) {             
      scanf("%d", &grid[i][j]);
      if (grid[i][j] == 0) {
        zero = true;
        grid[i][j] = 10;
        x = i;
        y = j;
      }
    }
  }
  a[0][0][0] = get(grid[0][0], 2);
  a[0][0][1] = get(grid[0][0], 5);

  for (int i = 1; i < n; i ++) {
    a[i][0][0] += get(grid[i][0], 2) + a[i - 1][0][0];
    a[i][0][1] += get(grid[i][0], 5) + a[i - 1][0][1];
    a[0][i][0] += get(grid[0][i], 2) + a[0][i - 1][0];
    a[0][i][1] += get(grid[0][i], 5) + a[0][i - 1][1];
    d[i][0][0] = 'D';
    d[i][0][1] = 'D';
    d[0][i][0] = 'R';
    d[0][i][1] = 'R';
  }

  for (int i = 1; i < n; i ++) {
    for (int j = 1; j < n; j ++) {
      int prev_two1 = a[i][j - 1][0];
      int prev_five1 = a[i][j - 1][1];
      int prev_two2 = a[i - 1][j][0];
      int prev_five2 = a[i - 1][j][1];
      int c2 = get(grid[i][j], 2);
      int c5 = get(grid[i][j], 5);
      prev_two1 += c2;
      prev_two2 += c2;
      prev_five1 += c5;
      prev_five2 += c5;
      if (prev_two1 < prev_two2) {
        a[i][j][0] = prev_two1;
        d[i][j][0] = 'R';
      } else {
        a[i][j][0] = prev_two2;
        d[i][j][0] = 'D';
      }
      if (prev_five1 < prev_five2) {                 
        a[i][j][1] = prev_five1;                 
        d[i][j][1] = 'R';             
      } else {                 
        a[i][j][1] = prev_five2;                 
        d[i][j][1] = 'D';             
      }         
    }     
  }     
  int cost = min(a[n - 1][n - 1][0], a[n - 1][n - 1][1]);     
  int k = 0;     
  if (a[n - 1][n - 1][0] > a[n - 1][n - 1][1]) {
    k = 1;
  }
  if (zero && (cost > 0)) {
    printf("1\n");
    for (int k = 0; k < x; k ++)
      printf("D");
    for (int k = 0; k < y; k ++)
      printf("R");
    for (int k = 0; k < n - y - 1; k ++)
      printf("R");
    for (int k = 0; k < n - x - 1; k ++)
      printf("D");
  } else {
    printf("%d\n", cost);
    print(n - 1, n - 1, k);
  }
  return 0;

}
