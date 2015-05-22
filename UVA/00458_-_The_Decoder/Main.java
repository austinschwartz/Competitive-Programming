import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    byte[] buffer = new byte[2048];
    while (true) {
      int len = System.in.read(buffer);
      if (len <= 0) break;
      for (int i = 0; i < len; i++) {
        if (buffer[i] != (byte)'\n')
          buffer[i] = (byte)(buffer[i] - 7);
      }
      System.out.write(buffer, 0, len);
    }
  }
}
