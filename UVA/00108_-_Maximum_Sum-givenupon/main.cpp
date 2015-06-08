#include <cstdio>

using namespace std;

int main() {
  int N;
  scanf("%d\n", &N);
  int x[N][N];
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) {
      scanf("%d", &x[i][j]);
    }
  }
}
