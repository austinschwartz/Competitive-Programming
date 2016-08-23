import java.util.*;

public class ArrayIntersection {
  public static List<Integer> intersect(List<List<Integer>> list) {
    if (list.size() == 0) return new ArrayList<Integer>();
    Set<Integer> set = new HashSet<Integer>();
    set.addAll(list.get(0));
    for (int i = 1; i < list.size(); i++) {
      set.retainAll(list.get(i));
    }
    return new ArrayList<Integer>(set);
  }
  public static void main(String[] args) {
    System.out.println(intersect(Arrays.asList(
            Arrays.asList(1, 3, 4, 7), 
            Arrays.asList(2, 8, 6, 0, 3), 
            Arrays.asList(3, 9, 1, 4))));
  }
}
