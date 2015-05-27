import java.util.*;
import java.io.*;

class Main {
  public static int addDigits(int a) {
    if (a == 0)
      return 0;
    int total = 0;
    while (a > 0) {
      total += (a % 10);
      a /= 10;
    }
    if (total >= 10)
      return addDigits(total);
    else
      return total;
  }

  public static int score(String a) {
    int sum = 0;
    int total = 0;
    for (int i = 0; i < a.length(); i++)
      if (Character.isAlphabetic(a.charAt(i)))
        sum += (a.charAt(i) - 'a' + 1);
    total = addDigits(sum);
    return total;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      if (line.equals("")) {
        if (line.equals(br.readLine()))
          System.out.println();
        else
          System.out.println("0.00 %");
        continue;
      }
      String name1 = line.toLowerCase();
      String name2 = br.readLine().toLowerCase();
      int sum1 = score(name1);
      int sum2 = score(name2);

      double dif;
      if (sum1 == 0 && sum2 == 0) {
        System.out.println();
        continue;
      }
      else if (sum1 == 0 || sum2 == 0)
        dif = 0.0;
      else if (sum2 > sum1)
        dif = sum1 / (double)sum2 * 100;
      else
        dif = sum2 / (double)sum1 * 100;
      System.out.printf("%.2f %%\n", dif); 
    }
  }
}
