#include <cstdio>
#define min(a,b) ((a) < (b) ? a : b)
using namespace std;

int main() {
  int b1, g1, c1, b2, g2, c2, b3, g3, c3;
  while (scanf("%d %d %d %d %d %d %d %d %d\n", &b1, &g1, &c1, &b2, &g2, &c2, &b3, &g3, &c3) != EOF) {
    int gbc = (g2 + g3) + (b1 + b3) + (c1 + c2);
    int gcb = (g2 + g3) + (c1 + c3) + (b1 + b2);
    int cgb = (c2 + c3) + (g1 + g3) + (b1 + b2);
    int cbg = (c2 + c3) + (b1 + b3) + (g1 + g2);
    int bcg = (b2 + b3) + (c1 + c3) + (g1 + g2); 
    int bgc = (b2 + b3) + (g1 + g3) + (c1 + c2);
    int min = min(gbc, min(gcb, min(cgb, min(cbg, min(bcg, bgc)))));
    if (bcg == min) printf("BCG %d\n", min);
    else if (bgc == min) printf("BGC %d\n", min);
    else if (cbg == min) printf("CBG %d\n", min);
    else if (cgb == min) printf("CGB %d\n", min);
    else if (gbc == min) printf("GBC %d\n", min);
    else if (gcb == min) printf("GCB %d\n", min);
  }
}
