package com.isograd.exercise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IsoContest_6 {
  public static boolean DEBUG = true;
  private static int[] fn;
  private static int nbIteration;
  private static int N;
  private static double match;
  public static void main(String[] argv) throws Exception {
    Scanner sc = new Scanner(System.in);
    solve(sc);
  }

  
  static Set<Double> entries = new HashSet<>();
  
  static void solve(Scanner sc) {
    N = sc.nextInt();
    debug(N);

    int total = 0;
    match = 1.0 * N / 2;
    fn = new int[N+1];
    for (int i = 0; i < N + 1; i++) {
      fn[i] = sc.nextInt();
      debug(fn[i]);
    }
    nbIteration = sc.nextInt();
    debug(nbIteration);
    
    total = project(0, 1, 0, N, 0);
    
    if (total == -1) {
      System.out.println("INF");
    } else {
      System.out.println(total % 1000);
    }
  }

  
  private static int project(double i1, double i2, int min, int max, int depth) {
    if (min > max) {
      int tmp = min;
      min = max;
      max = tmp;
    }
    if (depth == nbIteration) {
      return values(i1, i2, min, max); 
    } else {
      int total = 0;
      for (int i=min;i<=max;i++) {
        if (i == min) continue;
        double delta = i2 - i1;
        double deltay = fn[i] - fn[i-1];
        double alpha = delta / deltay;
        int value = project(i1, i2, fn[i-1], fn[i], depth+1);
        if (value == -1) return -1;
        total += value;
      }
      return total;
    }
  }

  private static int values(double i1, double i2, int min, int max) {
    if (min == match && max == match) return -1;
    if (match >= min && match <= max) {
      double entry = 1.0 * (match - min) * (i2-i1) / (max - min);
      if (entries.contains(entry)) {
        return 0;
      } else {
        //entries.add(entry);
        return 1;
      }
    }
    return 0;
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
