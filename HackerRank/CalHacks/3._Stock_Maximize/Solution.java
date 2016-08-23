import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static long maxProfit(long[] stocks, int n) {
        long currMax = Long.MIN_VALUE;
        long profit = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (currMax <= stocks[j]) {
                currMax = stocks[j];
            }
            profit += (currMax - stocks[j]);
        }
        return profit;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            long[] stocks = new long[N];
            for (int j = 0; j < N; j++) {
                stocks[j] = Long.parseLong(s[j]);
            }
            System.out.println(maxProfit(stocks, N));
        }
    }
}
