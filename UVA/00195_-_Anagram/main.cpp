#include <bits/stdc++.h>

using namespace std;

bool cmp(char A, char B){
  if (tolower(A) == tolower(B))
    return A < B;
  return tolower(A) < tolower(B);
}

int main() {
  int n;
  scanf("%d", &n);
  while (n--) {
    char str[10000];
    scanf("%s", str);
    int len = strlen(str);
    sort(str, str + len, cmp);
    do {
      printf("%s\n", str);
    } while( next_permutation(str, str + len, cmp));
  }
  return 0;
}
