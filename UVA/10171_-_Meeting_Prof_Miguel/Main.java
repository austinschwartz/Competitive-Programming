import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner in = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int N;
    while ((N = in.nextInt()) != 0) {
      int[][] yWeights = new int[26][26];
      int[][] mWeights = new int[26][26];
      for (int i = 0; i < 26; i++) {
        Arrays.fill(yWeights[i], -1);
        Arrays.fill(mWeights[i], -1);
      }
      for (int k = 0; k < N; k++) {
        char age = in.nextChar();
        char dir = in.nextChar();
        int i = in.nextChar() - 'A';
        int j = in.nextChar() - 'A';
        int weight = in.nextInt();
        if (age == 'Y') {
          yWeights[i][j] = weight;
          if (dir == 'B')
            yWeights[j][i] = weight;
        } else if (age == 'M') {
          mWeights[i][j] = weight;
          if (dir == 'B')
            mWeights[j][i] = weight;
        }
      }
      int[][] yDist = new int[26][26];
      int[][] mDist = new int[26][26];
      for (int i = 0; i < 26; i++) {
        Arrays.fill(yDist[i], 1 << 29);
        Arrays.fill(mDist[i], 1 << 29);
      }

      for (int i = 0; i < 26; i++) {
        yDist[i][i] = 0;
        mDist[i][i] = 0;
      }


      for (int i = 0; i < 26; i++) {
        for (int j = 0; j < 26; j++) {
          if (yWeights[i][j] != -1 && yDist[i][j] > yWeights[i][j])
            yDist[i][j] = yWeights[i][j];
          if (mWeights[i][j] != -1 && mDist[i][j] > mWeights[i][j])
            mDist[i][j] = mWeights[i][j];
        }
      }


      for (int k = 0; k < 26; k++) {
        for (int i = 0; i < 26; i++) {
          for (int j = 0; j < 26; j++) {
            if (yDist[i][j] > yDist[i][k] + yDist[k][j])
              yDist[i][j] = yDist[i][k] + yDist[k][j];
            if (mDist[i][j] > mDist[i][k] + mDist[k][j])
              mDist[i][j] = mDist[i][k] + mDist[k][j];
          }
        }
      }

      int yStart = in.nextChar() - 'A';
      int mStart = in.nextChar() - 'A';

      Map<Character, Integer> endpoints = new HashMap<Character, Integer>();


      for (int i = 0; i < 26; i++)
        if (yDist[yStart][i] < (1 << 10))
          endpoints.put((char)(i + 'A'), yDist[yStart][i]);

      int min = Integer.MAX_VALUE;
      List<Character> meetingPoints = new ArrayList<Character>();

      for (int i = 0; i < 26; i++) {
        if (mDist[mStart][i] < (1 << 10)) {
          int dist = mDist[mStart][i];
          char c = (char)(i + 'A');
          if (endpoints.containsKey(c)) {
            int theirDist = endpoints.get(c);
            min = Math.min(theirDist + dist, min);
          }
        }
      }

      for (int i = 0; i < 26; i++) {
        if (mDist[mStart][i] < (1 << 10)) {
          int dist = mDist[mStart][i];
          char c = (char)(i + 'A');
          if (endpoints.containsKey(c) && endpoints.get(c) + dist == min) {
            meetingPoints.add(c);
          }
        }
      }

      Collections.sort(meetingPoints);

      if (meetingPoints.size() != 0) {
        System.out.print(min + " ");
        for (int i = 0; i < meetingPoints.size(); i++) {
          System.out.print(meetingPoints.get(i));
          if (i < meetingPoints.size() - 1)
            System.out.print(" ");
        }
        System.out.println();
      } else {
        System.out.println("You will never meet.");
      }
    }
    out.close();
  }


  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
       br = new BufferedReader(new InputStreamReader(System.in));
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
