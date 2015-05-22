import java.util.*;
import java.io.*;

class Main {
  static String[] arr = new String[83681];
  static int x = 0;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int indx;
    StringBuilder sb;
    int i, j, k, l, m;
    for (i = 0; i < 26; i++) {
      sb = new StringBuilder();
      sb.append((char)(i + 'a'));
      arr[x] = sb.toString();
      x++;
    }
    for (i = 0; i < 26; i++) {
      for (j = 0; j < 26; j++) {
        if ((i < j)) {
          sb = new StringBuilder();
          sb.append((char)(i + 'a'));
          sb.append((char)(j + 'a'));
          arr[x] = sb.toString();
          x++;
        }
      }
    }
    for (i = 0; i < 26; i++) {
      for (j = 0; j < 26; j++) {
        for (k = 0; k < 26; k++) {
          if ((i < j) && 
              (j < k)) {
            sb = new StringBuilder();
            sb.append((char)(i + 'a'));
            sb.append((char)(j + 'a'));
            sb.append((char)(k + 'a'));
            arr[x] = sb.toString();
            x++;
          }
        }
      }
    }
    for (i = 0; i < 26; i++) {
      for (j = 0; j < 26; j++) {
        for (k = 0; k < 26; k++) {
          for (l = 0; l < 26; l++) {
            if ((i < j) && 
                (j < k) && 
                (k < l)) {
              sb = new StringBuilder();
              sb.append((char)(i + 'a'));
              sb.append((char)(j + 'a'));
              sb.append((char)(k + 'a'));
              sb.append((char)(l + 'a'));
              arr[x] = sb.toString();
              x++;
            }
          }
        }
      }
    }
    for (i = 0; i < 26; i++) {
      for (j = 0; j < 26; j++) {
        for (k = 0; k < 26; k++) {
          for (l = 0; l < 26; l++) {
            for (m = 0; m < 26; m++) {
              if ((i < j) && 
                  (j < k) && 
                  (k < l) && 
                  (l < m)) {
                sb = new StringBuilder();
                sb.append((char)(i + 'a'));
                sb.append((char)(j + 'a'));
                sb.append((char)(k + 'a'));
                sb.append((char)(l + 'a'));
                sb.append((char)(m + 'a'));
                arr[x] = sb.toString();
                x++;
              }
            }
          }
        }
      }
    }
    
    while ((line = br.readLine()) != null) {
      int found = 0;
      for (int n = 0; n < 83681; n++) {
        if (arr[n].equals(line)) {
          System.out.println(n + 1);
          found = 1;
          break;
        }
      }
      if (found == 0)
        System.out.println(0);
    }
  }
}
