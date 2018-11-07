package com.isograd.exercise;

import java.util.Scanner;

public class IsoContest_1 {
  public static boolean DEBUG = true;
  public static void main(String[] argv) throws Exception {
    Scanner sc = new Scanner(System.in);
    solve(sc);
  }

  static void solve(Scanner sc) {
    int N = sc.nextInt();
    debug(N);
    int reserve = sc.nextInt();
    debug(reserve);
    
    String vainqueur = "";
    int bestPrix = reserve;
    for (int i = 0; i < N; i++) {
      int prix = sc.nextInt();
      String name = sc.next();
      debug(prix, name);
      if (prix > bestPrix) {
        vainqueur = name;
      }
    }

    System.out.println(vainqueur);
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
