#include <cstdio>
#include <vector>

using namespace std;

int main() {
  freopen("input.txt", "r", stdin);
  freopen("output.txt", "w", stdout);

  int n, a;
  vector<int> index[5001];
  scanf("%d", &n);
  for (int i = 1; i <= n * 2; i++) {
    scanf("%d", &a);
    index[a].push_back(i);
  }

  bool possible = true;
  for (int i = 1; i < 5001; i++) {
    if (index[i].size() % 2 == 1) {
      possible = false;
      break;
    }
  }

  if (!possible) {
    printf("-1\n");
    return 0;
  }

  for (int i = 1; i < 5001; i++) {
    for (size_t j = 0; j < index[i].size(); j += 2)
    {
      printf("%d %d\n", index[i][j], index[i][j+1]);
    }
  }

  return 0;
}
