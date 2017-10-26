#include <algorithm>
#include <cstdio>
#include <vector>
#include <math.h>

using namespace std;

int s(int x) {
  int ret = 0;
  while (x > 0) {
    ret += (x % 10);
    x /= 10;
  }
  return ret;
}

int main() {
  int a, b, c;
  scanf("%d %d %d", &a, &b, &c);
  vector<int> ans;
  for (int sa = 1; sa <= 81; sa++) {
    int x = b * pow(sa, a) + c;
    if (b * pow(s(x), a) + c == x && x < (int)1e9) {
      ans.push_back(x);
    }
  }
  printf("%d\n", (int)ans.size());
  if (ans.size() > 0) {
    for (int i = 0; i < ans.size(); i++) {
      if (i != 0)
        printf(" ");
      printf("%d", ans[i]);
    }
  }
}
