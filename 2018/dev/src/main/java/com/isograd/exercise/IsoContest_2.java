package com.isograd.exercise;

import java.util.Scanner;

public class IsoContest_2 {
  public static boolean DEBUG = true;
  public static void main(String[] argv) throws Exception {
    Scanner sc = new Scanner(System.in);
    solve(sc);
  }

  static void solve(Scanner sc) {
    int N = sc.nextInt();
    debug(N);

    int magic = 0;
    for (int i = 0; i < N; i++) {
      String name = sc.next();
      //debug(name);
      boolean takeit = true;
      if (name.length() <5 || name.length() >7) takeit = false;
      if (name.charAt(0)<'a' || name.charAt(0)>'z') takeit = false;
      if (name.charAt(1)<'a' || name.charAt(1)>'z') takeit = false;
      if (((int)name.charAt(0)) != ((int)name.charAt(1)-1)) takeit = false;
      char last = name.charAt(name.length()-1);
      if (last != 'a' && last != 'e' && last != 'i' && last != 'o' && last != 'u' && last != 'y') takeit = false;
      if (takeit) {
        magic++;
        System.err.println(name);
      }
    }

    System.out.println(magic);
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
