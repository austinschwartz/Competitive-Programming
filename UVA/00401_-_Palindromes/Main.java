import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static Map<Character, Character> map = new HashMap<Character, Character>(){{
    put('A', 'A');
    put('E', '3');
    put('H', 'H');
    put('I', 'I');
    put('J', 'L');
    put('L', 'J');
    put('M', 'M');
    put('O', 'O');
    put('S', '2');
    put('T', 'T');
    put('U', 'U');
    put('V', 'V');
    put('W', 'W');
    put('X', 'X');
    put('Y', 'Y');
    put('Z', '5');
    put('1', '1');
    put('2', 'S');
    put('3', 'E');
    put('5', 'Z');
    put('8', '8');
  }};
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      String line = sc.nextLine();
      if (line.length() > 0)
        out.println(line + " -- is " + f(line) + "\n");
    }
    out.close();
  }

  public static boolean isPalindrome(String str) {
    return str.equals(new StringBuilder(str).reverse().toString());
  }

  public static boolean isMirrored(String str) {
    StringBuilder sb = new StringBuilder();
    for (Character ch : str.toCharArray()) {
      if (!map.containsKey(ch))
        return false;
      sb.append(map.get(ch));
    }
    return str.equals(sb.reverse().toString());
  }
  
  public static String f(String line) {
    boolean isP = isPalindrome(line);
    boolean isM = isMirrored(line);
    if (isP && isM) return "a mirrored palindrome.";
    if (!isP && isM) return "a mirrored string.";
    if (isP && !isM) return "a regular palindrome.";
    return "not a palindrome.";
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
