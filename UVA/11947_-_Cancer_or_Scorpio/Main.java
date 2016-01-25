import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));

    Calendar aquarius = Calendar.getInstance();
    Calendar pisces = Calendar.getInstance();
    Calendar aries = Calendar.getInstance();
    Calendar taurus = Calendar.getInstance();
    Calendar gemini = Calendar.getInstance();
    Calendar cancer = Calendar.getInstance();
    Calendar leo = Calendar.getInstance();
    Calendar virgo = Calendar.getInstance();
    Calendar libra = Calendar.getInstance();
    Calendar scorpio = Calendar.getInstance();
    Calendar sagittarius = Calendar.getInstance();
    Calendar capricorn = Calendar.getInstance();

    int n = sc.nextInt();

    for (int i = 1; i <= n; i++) {
      String date = sc.nextLine();
      int m = Integer.parseInt(date.substring(0, 2));
      int d = Integer.parseInt(date.substring(2, 4));
      int y = Integer.parseInt(date.substring(4, 8));

      Calendar cal = Calendar.getInstance();
      cal.set(y, m - 1, d);
      cal.add(Calendar.WEEK_OF_YEAR, 40);
      y = cal.get(Calendar.YEAR);
      aquarius.set(y, 0, 21);
      pisces.set(y, 1, 20);
      aries.set(y, 2, 21);
      taurus.set(y, 3, 21);
      gemini.set(y, 4, 22);
      cancer.set(y, 5, 22);
      leo.set(y, 6, 23);
      virgo.set(y, 7, 22);
      libra.set(y, 8, 24);
      scorpio.set(y, 9, 24);
      sagittarius.set(y, 10, 23);
      capricorn.set(y, 11, 23);

      System.out.printf("%d %02d/%02d/%04d ", i,
              cal.get(Calendar.MONTH) + 1,
              cal.get(Calendar.DAY_OF_MONTH),
              y);

      String res = null;
      if (cal.compareTo(aquarius) >= 0 && cal.before(pisces)) res = "aquarius";
      else if (cal.compareTo(pisces) >= 0 && cal.before(aries)) res = "pisces";
      else if(cal.compareTo(aries) >= 0 && cal.before(taurus))  res = "aries";
      else if(cal.compareTo(taurus) >= 0 && cal.before(gemini)) res = "taurus";
      else if(cal.compareTo(gemini) >= 0 && cal.before(cancer)) res = "gemini";
      else if(cal.compareTo(cancer) >= 0 && cal.before(leo)) res = "cancer";
      else if(cal.compareTo(leo) >= 0 && cal.before(virgo)) res = "leo";
      else if(cal.compareTo(virgo) >= 0 && cal.before(libra)) res = "virgo";
      else if(cal.compareTo(libra) >= 0 && cal.before(scorpio)) res = "libra";
      else if(cal.compareTo(scorpio) >= 0 && cal.before(sagittarius)) res = "scorpio";
      else if(cal.compareTo(sagittarius) >= 0 && cal.before(capricorn)) res = "sagittarius";
      else if (cal.compareTo(capricorn) >= 0 || cal.before(aquarius)) res = "capricorn";
      if (res != null) System.out.println(res);
    }
    out.close();
  }


  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
       br = new BufferedReader(new InputStreamReader(System.in));
    }
 
    public boolean hasNext() {
      try {
        boolean a = br.ready();
        return a;
      } catch (IOException e) {
        return false;
      }
    }

    public String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }
 
    public int nextInt() {
      return Integer.parseInt(next());
    }
 
    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public char nextChar() {
      return next().charAt(0);
    }

    public String nextLine() {
      String str = "";
      try {
         str = br.readLine();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return str;
    }
  }
}
