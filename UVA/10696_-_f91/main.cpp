#include <cstdio>

using namespace std;

static unsigned table[2 << 19];

int f91(int N) {
  if (table[N])
    return table[N];
  else {
    if (N <= 100)
      table[N] = f91(f91(N + 11));
    else
      table[N] = N - 10;
    return table[N];
  }
}

int main() {
  int N;
  while (scanf("%u", &N) && N != 0) {
    printf("f91(%u) = %u\n", N, f91(N));
  }
  return 0;
}
