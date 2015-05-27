import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N;
    while ((N = Integer.parseInt(br.readLine())) != -1) {
      System.out.println("Round " + N);
      Set<Character> solutionSet = new HashSet<Character>();
      Set<Character> guessSet = new LinkedHashSet<Character>();
      String solution = br.readLine();
      String guesses = br.readLine();
      for (int i = 0; i <= solution.length() - 1; i++)
        solutionSet.add(solution.charAt(i));
      for (int i = 0; i <= guesses.length() - 1; i++)
        guessSet.add(guesses.charAt(i));

      int wrongCount = 0;
      for (char ch : guessSet) {
        if (solutionSet.contains(ch)) {
          solutionSet.remove(ch);
        } else {
          if (solutionSet.size() > 0) {
            wrongCount++;
          }
        }
      }
      if (solutionSet.isEmpty() && wrongCount < 7) {
        System.out.println("You win.");
      } else if (!solutionSet.isEmpty() && wrongCount < 7) {
          System.out.println("You chickened out.");
      } else {
          System.out.println("You lose.");
      }
    }
  }
}
