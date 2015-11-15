import java.util.*;
import java.io.*;

class Main {
  // i--j
  // |  |
  // k--l
  // O(n^6)
  public static int maxSum(int[][] matrix, int N) {
    int max = -1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = i; k < N; k++) {
          for (int l = j; l < N; l++) {
            int subArraySum = 0;
            for (int a = i; a <= k; a++) {
              for (int b = j; b <= l; b++) {
                subArraySum += matrix[a][b];
              }
            }
            if (subArraySum > max)
              max = subArraySum;
          }
        }
      }
    }
    return max;
  }

  public static int maxSumBetter(int[][] matrix, int N) {
    int[][] sat = new int[N][N];
    sat[0][0] = matrix[0][0];
    for (int i = 1; i < N; i++)
      sat[0][i] = matrix[0][i] + sat[0][i-1];
    for (int i = 1; i < N; i++)
      sat[i][0] = matrix[i][0] + sat[i-1][0];
    
    for (int i = 1; i < N; i++) {
      for (int j = 1; j < N; j++) {
        sat[i][j] = sat[i-1][j] + sat[i][j-1] - sat[i-1][j-1] + matrix[i][j];
      }
    }

    int max = -1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k <= i; k++) {
          for (int l = 0; l <= j; l++) {
            int sum = sat[i][j];
            if (k > 0 && l > 0)
              sum += sat[k-1][l-1];
            if (k > 0)
              sum -= sat[k-1][j];
            if (l > 0)
              sum -= sat[i][l-1];
            max = Math.max(sum, max);
          }
        }
      }
    }

    return max;
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] nums = new int[N][N];
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        nums[i][j] = sc.nextInt();

    System.out.println(maxSumBetter(nums, N));
  }
}
