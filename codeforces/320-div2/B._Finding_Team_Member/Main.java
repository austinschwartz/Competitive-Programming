import java.util.*;
import java.io.*;

public class Main {
  public static class PossibleTeam {
    public int i;
    public int j;
    public int score;
    public PossibleTeam(int i, int j, int score) {
      this.i = i;
      this.j = j;
      this.score = score;
    }

    @Override
    public String toString() {
      return String.format("%d + %d = %d", i, j, score);
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int i = 2;
    String line;
    int[] teammates = new int[2 * n];
    Arrays.fill(teammates, -1);
    LinkedList<PossibleTeam> lst = new LinkedList<PossibleTeam>();
    while ((line = br.readLine()) != null) {
      String[] ls = line.split(" ");
      for (int o = 0; o < ls.length; o++) {
        int score = Integer.parseInt(ls[o]);
        PossibleTeam a = new PossibleTeam(i, o+1, score);
        lst.add(a);
      }
      i++;
    }
    Collections.sort(lst, new Comparator<PossibleTeam>() {
      public int compare(PossibleTeam a, PossibleTeam b) {
        return new Integer(b.score).compareTo(new Integer(a.score));
      }
    });
    /*
    for (PossibleTeam team : lst) {
      System.out.println(team);
    }
    */
    int currentTeams = 0;
    while (currentTeams < n && lst.size() > 0) {
      PossibleTeam team = lst.remove();
      if (teammates[team.i-1] == -1 &&
          teammates[team.j-1] == -1) {
        teammates[team.i-1] = team.j;
        teammates[team.j-1] = team.i;
        currentTeams++;
      }
    }
    for (int m = 0; m < 2 * n; m++) {
      System.out.print(teammates[m]);
      if (m < 2 * n - 1) System.out.print(" ");
    }
    System.out.println();
  }
}
