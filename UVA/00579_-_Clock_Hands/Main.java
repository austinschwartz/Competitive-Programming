import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while (!(line = br.readLine()).equals("0:00")) {
      String[] time = line.split(":");
      int hour = Integer.parseInt(time[0]);
      int mins = Integer.parseInt(time[1]);

      double hourAngle = (hour * 30.0) + (mins / 60.0) * 30.0;
      double minAngle = (mins * 360.0 / 60);
      
      double angle = Math.abs(hourAngle - minAngle);
      angle = angle > 180 ? Math.abs(angle - 360.0) : angle;

      System.out.printf("%.3f\n", angle);

    }
  }
}
