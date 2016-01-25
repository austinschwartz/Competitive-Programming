import java.util.*;
import java.io.*;

class Building {
  int left, right, height;
  public Building(int L, int R, int H) {
    this.left = L;
    this.right = R;
    this.height = H;
  }
}

class Strip {
  int x, height;
  public Strip(int x, int height) {
    this.x = x;
    this.height = height;
  }
}

public class Main {
  public static List<Strip> skyline(Building[] buildings) {
    List<Strip> strips = new ArrayList<Strip>();
    return strips;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    List<Building> buildings = new ArrayList<Building>();
    int maxR = 0;
    while ((line = br.readLine()) != null) {
      String[] sp = line.split(" ");
      int L = Integer.parseInt(sp[0]);
      int H = Integer.parseInt(sp[1]);
      int R = Integer.parseInt(sp[2]);
      if (R > maxR) maxR = R;
      Building building = new Building(L, R, H);
      buildings.add(building);
    }
    int[] sky = new int[maxR + 1];
    Arrays.fill(sky, 0);
    for (Building b : buildings) {
      int left = b.left;
      int right = b.right;
      for (int i = left; i < right; i++) {
        if (sky[i] < b.height)
          sky[i] = b.height;
      }
    }
    List<Strip> strips = new ArrayList<Strip>();

    int currentHeight = 0;
    for (int i = 0; i < maxR + 1; i++) {
      if (sky[i] != currentHeight)
        strips.add(new Strip(i, sky[i]));
      currentHeight = sky[i];
    }



    for (int i = 0; i < strips.size(); i++) {
      Strip a = strips.get(i);
      System.out.printf("(%d, %d)", a.x, a.height);
      if (i < strips.size() - 1)
        System.out.print(", ");
    }
    System.out.println();
  }
}
