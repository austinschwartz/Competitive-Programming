#include <cstdio>

using namespace std;

int main(int argc, const char** argv) {
  int n;
  scanf("%d\n", &n);
  for (int i = 0; i < n; i++) {
    int m;
    int s;
    scanf("%d", &m);
    int C[m];
    for (int j = 0; j < m; j++) {
      scanf("%d", &C[m]);
      printf("%d", C[m]);
    }
    scanf("%d\n", &s);
    printf("\n%d\n", s);
  }
}
