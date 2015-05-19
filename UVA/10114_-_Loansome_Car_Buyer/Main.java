import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while (!(line = br.readLine()).startsWith("-")) {
      int exit = 0;
      String[] arr = line.split(" ");
      int duration = Integer.parseInt(arr[0]);
      double downpayment = Double.parseDouble(arr[1]);
      double amount = Double.parseDouble(arr[2]);
      int records = Integer.parseInt(arr[3]);
      double monthlyamt = amount / duration;

      TreeMap<Integer, Double> map = new TreeMap<Integer, Double>();
      for (int i = 0; i < records; i++) {
        String[] arr2 = br.readLine().split(" ");
        int monthnum = Integer.parseInt(arr2[0]);
        double depreciationpercent = Double.parseDouble(arr2[1]);
        map.put(monthnum, depreciationpercent);
      }
      
      int nummonths = 0;
      double lastpercent = 0;
      double currentworth = amount + downpayment;
      double amountowed = amount;
      int j;
      for (j = 0; j < duration; j++) {
        if (map.containsKey(j)) {
          lastpercent = map.get(j);
        }
        currentworth -= (currentworth * lastpercent);
        amountowed = amount - (j * monthlyamt);
        //System.out.println(j + " - " + currentworth + " - " + amountowed);
        if (amountowed < currentworth) {
          exit = 1;
          System.out.print(j);
          if (j == 1)
            System.out.println(" month");
          else
            System.out.println(" months");
          j = Integer.MAX_VALUE - 1;
        }
      }
      if (exit == 0)
        System.out.println("100 months");
    }
  }
}
