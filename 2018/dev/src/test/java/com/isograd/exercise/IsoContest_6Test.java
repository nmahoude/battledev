package com.isograd.exercise;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class IsoContest_6Test {

  private static final String NL = "";

  @Before 
  public void setup() {
    IsoContest_6.DEBUG = false;
  }
  
  
  @Test
  public void direct() throws Exception {
    Scanner in = new Scanner(""
        +"5 "
        +"0 2 4 3 2 1 "
        +"3 ");
    
    IsoContest_6.solve(in);
  }
  
  
  @Test
  @Ignore
  public void directdepth3() throws Exception {
    Scanner in = new Scanner(""
        +"3 "
        +"0 2 0 2 "
        +"2 ");
    
    IsoContest_6.solve(in);
  }
}
