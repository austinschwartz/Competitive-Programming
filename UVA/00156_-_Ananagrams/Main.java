import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    String word;
    List<String> words = new ArrayList<String>();
    while (!(word = sc.next()).equals("#")) {
      words.add(word);
    }
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    for (String w : words) {
      char[] arr = w.toLowerCase().toCharArray();
      Arrays.sort(arr);
      String sorted = new String(arr);
      List<String> lst;
      if (map.containsKey(sorted)) {
        lst = map.get(sorted); 
      } else {
        lst = new ArrayList<String>();
      }
      lst.add(w);
      map.put(sorted, lst);
    }
    List<String> outList = new ArrayList<String>();
    for (String w : map.keySet()) {
      List<String> list = map.get(w);
      if (list.size() != 1) continue;
      outList.add(list.get(0));
    }
    Collections.sort(outList);
    for (String str : outList)
      System.out.println(str);

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
