#include <cstdio>

using namespace std;

int main() {
  int n;
  for (;;) {
    scanf("%d\n", &n);
    if (n == 0)
      return 0;
    double a;
    double C[n];
    double min = 9999999.0;
    double total = 0.0;
    for (int i = 0; i < n; i++) {
      scanf("%lf\n", &a);
      C[i] = a;
      if (a < min) min = a;
      total += a;
    }
    double avg = total / n;
    double high = 0;
    double low = 0;
    for (int i = 0; i < n; i++) {
      double diff = ((double)(long)((C[i] - avg) * 100.0) / 100.0);
      if (diff < 0)
        low -= diff;
      else
        high += diff;
    }
    if (low > high)
      printf("$%.2lf\n",  low);
    else
      printf("$%.2lf\n", high);
  }
}
