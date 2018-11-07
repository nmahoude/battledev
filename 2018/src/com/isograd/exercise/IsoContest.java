package com.isograd.exercise;
import java.util.*;

public class IsoContest {
public static void main( String[] argv ) throws Exception {
    String  line;
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    System.err.println("N is "+N);
    for (int i=0;i<N;i++) {
        int qn = sc.nextInt();
        int qsa = sc.nextInt();
        int qss = sc.nextInt();
      System.err.println("values : "+qn+","+qsa+","+qss);
    }
  /* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
  }
}
