package com.isograd.exercise;

import java.util.Scanner;

public class IsoContest_5 {
  public static boolean DEBUG = true;
  private static int[] fn;
  public static void main(String[] argv) throws Exception {
    Scanner sc = new Scanner(System.in);
    solve(sc);
  }

  static int creneaux[][];
  private static int N;
  
  static void solve(Scanner sc) {
    N = sc.nextInt();
    debug(N);

    creneaux = new int[N][2];
    for (int i = 0; i < N; i++) {
      creneaux[i][0] = sc.nextInt();
      creneaux[i][1] = sc.nextInt();
      debug(creneaux[i][0], creneaux[i][1]);
      
    }
    
    int c1b[] = new int[1000];
    int crenauxParEtudiant[] = new int[N];
    crenauxParEtudiant = findCreneaux(0, c1b, crenauxParEtudiant, 0);
    
    if (crenauxParEtudiant != null) {
      for (int i=0;i<N;i++) {
        System.out.println(crenauxParEtudiant[i]+1);
      }
    } else {
      System.out.println("KO");
    }
  }
  
  private static int[] findCreneaux(int n, int[] c1, int crenauxParEtudiant[], int max) {
    if (n == N) return crenauxParEtudiant;
    
    int c1b[] = new int[1000];
    int c2b[] = new int[1000];
    int cpe[] = new int[N];
    
    System.arraycopy(c1, 0, c1b, 0, 1000);
    System.arraycopy(c1, 0, c2b, 0, 1000);
    System.arraycopy(crenauxParEtudiant, 0, cpe, 0, N);
    
    int creneau1 = creneaux[n][0];
    int creneau2 = creneaux[n][1];
    boolean canTakeIt;
    canTakeIt = checkIfCanFill(c1b, creneau1);

    int[] crenauxParEtudiant1 = null, crenauxParEtudiant2 = null;
    if (canTakeIt) {
      cpe[n] = 0;
      crenauxParEtudiant1 = findCreneaux(n+1, c1b, cpe, max+1);
    }
    
    canTakeIt = checkIfCanFill(c2b, creneau2);
    if (canTakeIt) {
      cpe[n] = 1;
      crenauxParEtudiant2 = findCreneaux(n+1, c2b, cpe, max+1);
    } 
    
    if (crenauxParEtudiant1 != null) {
      return crenauxParEtudiant1;
    }
    if (crenauxParEtudiant2 != null) {
      return crenauxParEtudiant2;
    }
    return null;
  }

  private static boolean checkIfCanFill(int[] c2b, int creneau2) {
    boolean canTakeIt = true;
    for (int i=0;i<60;i++) {
      if (c2b[creneau2+i] != 0) {
        canTakeIt = false;
        break;
      }
      c2b[creneau2+i] = 1;
    }
    return canTakeIt;
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
