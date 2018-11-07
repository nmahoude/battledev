package com.isograd.exercise;

import java.util.Scanner;

public class IsoContest_3 {
  public static boolean DEBUG = true;
  private static int[] fn;
  public static void main(String[] argv) throws Exception {
    Scanner sc = new Scanner(System.in);
    solve(sc);
  }

  static void solve(Scanner sc) {
    int N = sc.nextInt();
    debug(N);

    int total = 0;
    double match = 1.0 * N / 2;
    fn = new int[N+1];
    for (int i = 0; i < N + 1; i++) {
      fn[i] = sc.nextInt();
      debug(fn[i]);
      if (i == 0) continue;
      if (fn[i] >= match && fn[i-1] <= match) {
        total++;
      }
      if (fn[i] <= match && fn[i-1] >= match) {
        total++;
      }
      if (fn[i] == match && fn[i-1] == match) {
        total = -1;
        break;
      }
    }

    if (total == -1) {
      System.out.println("INF");
    } else {
      System.out.println(total);
    }
  }
  
  public static void debug(Object... values) {
    if (!DEBUG) return;
    
    System.err.print("+\"");
    for (Object value : values) {
      System.err.print(""+value+" ");
    }
    System.err.println("\"+NL");
  }

}
