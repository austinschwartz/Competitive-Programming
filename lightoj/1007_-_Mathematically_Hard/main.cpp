#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <algorithm>
#include <vector>

#define ll long long
#define MAX 5000001

using namespace std;

int euler[MAX + 1];
ll p[MAX + 1];

void eulerSieve() {
  for (int i = 1; i <= MAX; i++) 
    euler[i] = i;
  for (int i = 2; i <= MAX; i++)
    if (euler[i] == i)
      for (int j = i; j <= MAX; j += i)
        euler[j] = (euler[j] / i) * (i - 1);
}

int main() {
  int T;
  eulerSieve();
  p[0] = euler[0] * euler[0];
  for (int i = 1; i < MAX; i++) {
    ll temp = euler[i];
    temp *= euler[i];
    p[i] = p[i-1] + temp;
  }
  int a, b;
  cin >> T;
  for (int i = 1; i <= T; i++) {
    scanf("%d", &a);
    scanf("%d", &b);
    if (a == 0)
      printf("Case %d: %llu\n", i, p[b]);
    else
      printf("Case %d: %llu\n", i, p[b] - p[a-1]);
  }
  return 0;
}
