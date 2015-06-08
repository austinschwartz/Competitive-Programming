#include <cstdio>

using namespace std;

int main() {
 int t;
 scanf("%d\n", &t);
 for (int i = 0; i < t; i++) {
   int N, T;
   scanf("%d %d\n", &N, &T);
   int time[N+1][N+1];
   int risk[N+1][N+1];
   bool mark[N+1];
   for (int j = 0; j <= N; j++)
     mark[j] = false;
   for (int j = 1; j <= N; j++) {
     for (int k = 1; k <= N; k++) {
       scanf("%d", &time[j][k]);
   for (int j = 0; j < N; j++) {
     for (int k = 0; k < N; k++) {
       scanf("%d", &risk[j][k]);
     }
   }
   for (int j = 0; j < N; j++) {
     for (int k = 0; k < N; k++) {
       printf("%d ", risk[j][k]);
     }
     printf("\n");
   }


 }

}
