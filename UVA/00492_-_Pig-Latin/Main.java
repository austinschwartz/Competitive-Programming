import java.util.*;
import java.io.*;

class Main {
  public static boolean isVowel(char a) {
    if (a == 'A' || a == 'a' ||
        a == 'E' || a == 'e' ||
        a == 'I' || a == 'i' ||
        a == 'O' || a == 'o' ||
        a == 'U' || a == 'u')
      return true;
    else
      return false;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char ch, save;
    while ((ch = (char)br.read()) != (char)-1) {
      if (Character.isAlphabetic(ch)) {
        if (isVowel(ch)) {
          while (Character.isAlphabetic(ch)) {
            System.out.print(ch);
            ch = (char)br.read();
          }
          System.out.print("ay");
        } else {
          save = ch;
          ch = (char)br.read();
          while (Character.isAlphabetic(ch)) {
            System.out.print(ch);
            ch = (char)br.read();
          }
          System.out.print(save + "ay");
        }
      }
      System.out.print(ch);
    }
  }
}
