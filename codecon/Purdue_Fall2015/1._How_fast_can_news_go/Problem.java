import java.util.*;
import java.io.*;

public class Problem {
  public static int func(int N, int K, int T) {
    int t = 0;
    int n = 1;
    while (n < N) {
     n += (K);
    }
    return t;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());
    int T = Integer.parseInt(br.readLine());
    
    System.out.println(func(N, K, T));
  }
}
