import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      boolean correct = true;
      Stack<Character> stack = new Stack<Character>();
      char p = ' ';
      char a;
      if (line.length() % 2 == 1)
        correct = false;
      for (int j = 0; j < line.length() && correct == true; j++) {
        if (line.charAt(j) == '(' || line.charAt(j) == '[') {
          stack.push(line.charAt(j));
          p = line.charAt(j);
        } else {
          if (stack.isEmpty())
            correct = false;
          else {
            a = stack.pop();
            char cur = line.charAt(j);
            if ((cur == ')' && a == '[') || 
                (cur == ']' && a == '(') )
              correct = false;
          }
        }
      }
      if (stack.size() > 0)
        correct = false;
      System.out.println(correct ? "Yes" : "No");
    }
  }
}
