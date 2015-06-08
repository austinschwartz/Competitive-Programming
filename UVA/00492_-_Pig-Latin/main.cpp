#include <cstdlib>
#include <cstdio>
#include <ctype.h>

int isVowel(char a) {
  if (a == 'A' || a == 'a' ||
      a == 'E' || a == 'e' ||
      a == 'I' || a == 'i' ||
      a == 'O' || a == 'o' ||
      a == 'U' || a == 'u')
    return 1;
  else
    return 0;
}

int main() {
  char save, ch;
  while ((ch = getchar()) != EOF) {
    if (isalpha(ch)) {
      if (isVowel(ch)) {
        while (isalpha(ch)) {
          printf("%c", ch);
          ch = getchar();
        }
        printf("ay");
      } else {
        save = ch;
        ch = getchar();
        while (isalpha(ch)) {
          printf("%c", ch);
          ch = getchar();
        }
        printf("%cay", save);
      }
    }
    printf("%c", ch);
  }

  return 0;
}
