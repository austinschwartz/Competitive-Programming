import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      char[] arr = br.readLine().toLowerCase().replaceAll("[^a-z]", "").toCharArray();
      String x = new String(arr);
      System.out.println("Case #" + (i + 1) + ":");
      int square = (int)Math.sqrt(arr.length);

      if (arr.length != square * square) {
        System.out.println("No magic :(");
      } else {
        char[][] matrix = new char[square][square];
        int k = 0;
        for (int m = 0; m < square; m++) {
          for (int n = 0; n < square; n++) {
            matrix[m][n] = arr[k];
            k++;
          }
        } 
        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < square; m++)
          for (int n = 0; n < square; n++)
            sb.append(matrix[m][n]);

        String y = sb.toString();
        if (!y.equals(x)) {
          System.out.println("No magic :(");
        } else {
          sb = new StringBuilder();
          for (int m = 0; m < square; m++)
            for (int n = 0; n < square; n++)
              sb.append(matrix[n][m]);

          y = sb.toString();
          if (!y.equals(x)) {
            System.out.println("No magic :(");
          } else {
            sb = new StringBuilder();
            for (int m = square - 1; m >= 0; m--)
              for (int n = square - 1; n >= 0; n--)
                sb.append(matrix[m][n]);

            y = sb.toString();
            if (!y.equals(x)) {
              System.out.println("No magic :(");
            } else {
              sb = new StringBuilder();
              for (int m = square - 1; m >= 0; m--)
                for (int n = square - 1; n >= 0; n--)
                  sb.append(matrix[n][m]);

              y = sb.toString();
              if (!y.equals(x)) {
                System.out.println("No magic :(");
              } else {
                System.out.println(square);
              }
            }
          }
        }
      }
    }
  }
}
