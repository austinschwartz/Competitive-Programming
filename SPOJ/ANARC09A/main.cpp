#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

#define MAX 2000

char str[MAX];

int main() {
  int k = 1;
  while (scanf("%s", str) > 0) {
    if (str[0] == '-')
      break;
    int n = strlen(str);
    int flipped = 0;
    int stack = 0;
    for (int i = 0; i < n; i++) {
      if (str[i] == '{') {
        stack++;
      } else {
        stack--;
        if (stack < 0) {
          flipped++;
          stack = 1;
        }
      }
    }
    printf("%d. %d\n", k++, flipped + stack / 2);
  }
  return 0;
}
