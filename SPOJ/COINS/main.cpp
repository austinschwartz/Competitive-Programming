#include <cstdio>
#include <map>
#include <algorithm>

using namespace std;

map<long long, long long> m;

long long dp(long long a) {
  if (a == 0)
    return 0;
  if (m[a] != 0)
    return m[a];
  else {
    m[a] = max(a, dp(a / 2) + dp(a / 3) + dp(a / 4));
  }
  return m[a];
}
 
int main() {
  long long N;
  while (scanf("%lld\n", &N) != EOF) {
    printf("%lld\n", dp(N));
  }
}
