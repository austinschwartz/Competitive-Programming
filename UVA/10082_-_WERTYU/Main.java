import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static Map<Character, Character> map = 
    new HashMap<Character, Character>(){{
      put('\\', ']');
      put(']', '[');
      put('[', 'P');
      put('P', 'O');
      put('P', 'O');
      put('O', 'I');
      put('I', 'U');
      put('U', 'Y');
      put('Y', 'T');
      put('T', 'R');
      put('R', 'E');
      put('E', 'W');
      put('W', 'Q');

      put('\'', ';');
      put(';', 'L');
      put('L', 'K');
      put('K', 'J');
      put('J', 'H');
      put('H', 'G');
      put('G', 'F');
      put('F', 'D');
      put('D', 'S');
      put('S', 'A');

      put('/', '.');
      put('.', ',');
      put(',', 'M');
      put('M', 'N');
      put('N', 'B');
      put('B', 'V');
      put('V', 'C');
      put('C', 'X');
      put('X', 'Z');

      put('=', '-');
      put('-', '0');
      put('0', '9');
      put('9', '8');
      put('8', '7');
      put('7', '6');
      put('6', '5');
      put('5', '4');
      put('4', '3');
      put('3', '2');
      put('2', '1');
      put('1', '`');
      
    }};

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    char[] line;
    while (sc.hasNext()) {
      line = sc.nextLine().toCharArray();
      for (int i = 0; i < line.length; i++) {
        if (map.containsKey(line[i]))
          System.out.print(map.get(line[i]));
        else
          System.out.print(line[i]);
      }
      System.out.println();
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
