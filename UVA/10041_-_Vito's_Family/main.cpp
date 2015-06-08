#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  int N;
  scanf("%d\n", &N);
  for (int i = 0; i < N; i++) {
    int M;
    scanf("%d", &M);
    int x[M], m = 0, sum = 0;
    for (int i = 0; i < M; i++) {
      scanf("%d", &x[i]);
      sum += x[i];
    }
    sort(x, x + M);
    int median = x[M/2];
    for (int i = 0; i < M; i++) {
      m += abs(median - x[i]);
    }
    printf("%d\n", m);
  }
}
