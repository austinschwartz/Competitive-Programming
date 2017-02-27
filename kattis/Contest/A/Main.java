import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    String str = sc.nextLine();
    StringBuilder sb = new StringBuilder();
    for (char c : str.toCharArray()) {
      switch (Character.toLowerCase(c)) {
        case 'a':
          sb.append("@"); break;
        case 'b':
          sb.append("8"); break;
        case 'c':
          sb.append("("); break;
        case 'd':
          sb.append("|)"); break;
        case 'e':
          sb.append("3"); break;
        case 'f':
          sb.append("#"); break;
        case 'g':
          sb.append("6"); break;
        case 'h':
          sb.append("[-]"); break;
        case 'i':
          sb.append("|"); break;
        case 'j':
          sb.append("_|"); break;
        case 'k':
          sb.append("|<"); break;
        case 'l':
          sb.append("1"); break;
        case 'm':
          sb.append("[]\\/[]"); break;
        case 'n':
          sb.append("[]\\[]"); break;
        case 'o':
          sb.append("0"); break;
        case 'p':
          sb.append("|D"); break;
        case 'q':
          sb.append("(,)"); break;
        case 'r':
          sb.append("|Z"); break;
        case 's':
          sb.append("$"); break;
        case 't':
          sb.append("\'][\'"); break;
        case 'u':
          sb.append("|_|"); break;
        case 'v':
          sb.append("\\/"); break;
        case 'w':
          sb.append("\\/\\/"); break;
        case 'x':
          sb.append("}{"); break;
        case 'y':
          sb.append("`/"); break;
        case 'z':
          sb.append("2"); break;
        default:
          sb.append(c); break;


      }
    }
    out.println(sb.toString());
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
