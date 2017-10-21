#include <algorithm>
#include <string>
#include <cstdio>
#include <vector>

#define MAX 300000007

using namespace std;

vector<bool> bs (MAX, 1);

int main() {
  int l, r;
  scanf("%d %d", &l, &r);
  for (int i = 3; i*i <= r; i += 2) {
    if (bs[i]) {
      for (int j = i * i; j <= r && j > 0; j += (2 * i)) {
        bs[j] = false;
      }
    }
  }
  int ret = 0;
  if (l <= 2 && r >= 2)
    ret++;
  for (int i = 5; i <= r; i += 4) {
    if (i >= l && bs[i] == 1) {
      ret += 1;
    }
  }
  printf("%d\n", ret);
}
