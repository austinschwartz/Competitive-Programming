import java.util.*;
import java.io.*;

class Main {
  public static double ET(int lambda, Map<String, Integer> p) {
    double total = 1.0 / lambda;
    double sum = 0;
    for (String key : p.keySet()) {
      sum += (p.get(key) * (Math.log10(lambda) - Math.log10(p.get(key))));
    }
    total = total * sum;
    return total;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in, "ISO-8859-1" ), 65536 );
    String line;
    while (true) {
      int lambda = 0;
      Map<String, Integer> map = new HashMap<String, Integer>();
      while (!(line = br.readLine()).equals("****END_OF_TEXT****")) {
        if (line.equals("****END_OF_INPUT****"))
          return;
        if (line.equals(""))
          continue;
        String[] arr = line.toLowerCase().split("[ ,.:;!?\"()\t\n]+");
        int lambdai = 0;
        for (int i = 0; i < arr.length; i++) {
          if (arr[i].length() == 0)
            continue;
          else if (map.containsKey(arr[i]))
            map.put(arr[i], map.get(arr[i]) + 1);
          else
            map.put(arr[i], 1);
          lambdai++;
        }

        lambda += lambdai;
      }
      double etval = ET(lambda, map);
      double emax = Math.log10(lambda);
      double erel = etval / emax * 100;
      System.out.printf("%d %.1f %.0f\n", lambda, etval, erel);
    }
  }
}
